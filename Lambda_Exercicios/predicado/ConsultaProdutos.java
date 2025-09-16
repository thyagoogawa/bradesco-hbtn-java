import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConsultaProdutos {
    
    public static List<Produto> filtrarV1(List<Produto> produtos, Predicate<Produto> predicate) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        
        // Versão 1:
        for (Produto p : produtos) {
            if (predicate.test(p)) {
                produtosFiltrados.add(p);
            }
        }

        return produtosFiltrados;
    }

    public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> predicate) {
        List<Produto> produtosFiltrados = new ArrayList<>();

        // Versão 2:
        produtos
            .stream()
            .filter(predicate)
            .forEach(p -> produtosFiltrados.add((Produto) p));

        return produtosFiltrados;
    }
}
