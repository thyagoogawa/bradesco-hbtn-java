import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consulta {
    
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream()
                .filter(p -> p.getCategoriaProduto().equals(CategoriaProduto.LIVRO))
                .collect(Collectors.toList());
    }

    // Versao 1:
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .findFirst()
                .get();
    }

    // Versao 2:
    public static Produto obterProdutoMaiorPrecoV2(List<Produto> produtos) {
        return produtos.stream()
                .max(Comparator.comparing(p -> p.getPreco()))
                .get();
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(p -> p.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos
                .stream()
                .filter(pedido -> pedido.getProdutos()
                        .stream()
                        .anyMatch(produto -> produto.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO)))
                .collect(Collectors.toList());
    }

    /*  
     * Versao 1, altera a ordem da lista, altera o produto na origem
     */
    public static List<Produto> aplicar15PorcentoDescontoEletronicosV1(List<Produto> produtos) {
        Stream<Produto> streamProdutosTransformados = produtos.stream()
                .filter(p -> p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO))
                .peek(p -> p.setPreco(p.getPreco() * 0.85));

        Stream<Produto> streamProdutos = produtos.stream()
                .filter(p -> !p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO));

        Stream<Produto> streamResultante = Stream.concat(streamProdutosTransformados, streamProdutos);

        return streamResultante
                .collect(Collectors.toList());
    }

    /*  
     * Versao 2, nao altera a ordem da lista, usa ternario com Produto.setPrecoGetProduto(preco).
     * Altera o produto original.
     * */
    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(p -> p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO) ? 
                        p.setPrecoGetProduto(p.getPreco() * 0.85) : 
                        p)
                .collect(Collectors.toList());
    }

    /*
     * Versao 3: nao altera a ordem da lista. Eh a forma mais simples e astuta de iterar numa lista,
     * fazer alteracoes nela e retornar ela mesma. Mas altera o produto original.
     */
    public static List<Produto> aplicar15PorcentoDescontoEletronicosV3(List<Produto> produtos) {
        produtos.stream()
                .filter(p -> p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO))
                .forEach(p -> p.setPreco(p.getPreco() * 0.85));
        return produtos;
    }

    /* 
     * Versao 4: nao altera a ordem da lista, usa if dentro do map, cria novo produto para nao
     * alterar o original, pois o stream, por padrao, nao altera os elementos da origem.
     */
    public static List<Produto> aplicar15PorcentoDescontoEletronicosV4(List<Produto> produtos) {
        return produtos.stream()
                .map(p -> {
                    if (p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO)) {
                        double novoPreco = p.getPreco() * 0.85;
                        return new Produto(p.getCodigo(), p.getNome(), p.getCategoriaProduto(), novoPreco);
                    } else {
                        return p;
                    }
                })
                .collect(Collectors.toList());
    }

    /*
     * Versao 5: eh a versao 2 melhorada. Nao altera o produto original.
     */
    public static List<Produto> aplicar15PorcentoDescontoEletronicosV5(List<Produto> produtos) {
        return produtos.stream()
                .map(p -> p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO) ? 
                        new Produto(p.getCodigo(), p.getNome(), p.getCategoriaProduto(), p.getPreco() * 0.85) : 
                        p)
                .collect(Collectors.toList());
    }
    
}
