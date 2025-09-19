import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consulta {
    
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {

        List<Produto> produtosFiltrados = pedido.getProdutos().stream()
                .filter(p -> p.getCategoriaProduto().equals(CategoriaProduto.LIVRO))
                .collect(Collectors.toList());

        return produtosFiltrados;    
    }

    // Versao 1:
    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        Produto produto = produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .findFirst()
                .get();

        return produto;
    }

    // Versao 2:
    public static Produto obterProdutoMaiorPrecoV2(List<Produto> produtos) {
        Produto produto = produtos.stream()
                .max(Comparator.comparing(p -> p.getPreco()))
                .get();

        return produto;
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        
        List<Produto> produtosFiltrados = produtos.stream()
                .filter(p -> p.getPreco() >= precoMinimo)
                .collect(Collectors.toList());
        
        return produtosFiltrados;
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {

        List<Pedido> pedidosComEletronicos = pedidos
                .stream()
                .filter(pedido -> pedido.getProdutos()
                        .stream()
                        .anyMatch(produto -> produto.getCategoriaProduto()
                                .equals(CategoriaProduto.ELETRONICO)))
                .collect(Collectors.toList());

        return pedidosComEletronicos;
    }

    /*
    aplicar15PorcentoDescontoEletronicos na classe Consulta que recebe uma lista de produtos 
    e retorna todos os produtos, porem os produtos que sejam eletronicos deve estar com 
    15% de desconto aplicado no preco.

    DICA: Utilizar map
    */

    // Versao 1, altera a ordem da lista: 
    public static List<Produto> aplicar15PorcentoDescontoEletronicosV1(List<Produto> produtos) {
        Stream<Produto> streamProdutosTransformados = produtos.stream()
                .filter(p -> p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO))
                .peek(p -> p.setPreco(p.getPreco() * 0.85));

        Stream<Produto> streamProdutos = produtos.stream()
                .filter(p -> !p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO));

        Stream<Produto> streamResultante = Stream.concat(streamProdutosTransformados, streamProdutos);

        List<Produto> produtosTransformados = streamResultante
                .collect(Collectors.toList());

        return produtosTransformados;
    }

    // Versao 2, nao altera a ordem da lista:
    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        List<Produto> produtosTransformados = produtos.stream()
                .map(p -> p.getCategoriaProduto().equals(CategoriaProduto.ELETRONICO) ? 
                        p.setPrecoGetProduto(p.getPreco() * 0.85) : 
                        p)
                .collect(Collectors.toList());

        return produtosTransformados;
    }

}
