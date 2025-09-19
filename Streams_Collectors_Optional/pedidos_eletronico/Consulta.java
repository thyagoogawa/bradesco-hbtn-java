import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

}
