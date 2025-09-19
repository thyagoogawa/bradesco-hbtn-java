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

}
