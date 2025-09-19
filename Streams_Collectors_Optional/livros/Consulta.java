import java.util.List;
import java.util.stream.Collectors;

public class Consulta {
    
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {

        List<Produto> produtosFiltrados = pedido.getProdutos().stream()
                .filter(p -> p.getCategoriaProduto().equals(CategoriaProduto.LIVRO))
                .collect(Collectors.toList());

        return produtosFiltrados;    
    }
}
