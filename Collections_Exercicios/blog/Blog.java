import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Blog {

    private List<Post> posts = new ArrayList<>();

    public void adicionarPostagem(Post post) { 
        // recebe uma postagem e adiciona a lista de postagens.
        posts.add(post);
    }

    public Set<String> obterTodosAutores() {                        
              
        Set<String> conjuntoNomes = new HashSet<>();

        for (Post post : posts) {
            conjuntoNomes.add(post.getAutor()); // o HashSet remove duplicados
        }

        Set<String> conjuntoNomesOrdenados = new TreeSet<>(conjuntoNomes); // o TreeSet ordena as Strings em ordem alfabética
        
        return conjuntoNomesOrdenados;
    }

    public Map<String, Integer> obterContagemPorCategoria() { 
 
        Map<String, Integer> postagensPorCategoria = new HashMap<>();

        int postagens;

        for (Post post : posts) {

            String categoria = post.getCategoria();

            if ( !postagensPorCategoria.containsKey(categoria)) {
                postagensPorCategoria.put(categoria, 1);

            } else {
                postagens = postagensPorCategoria.get(categoria) + 1;
                postagensPorCategoria.put(categoria, postagens) ;
            }

        }

        Map<String, Integer> postagensPorCategoriaOrdenada = new TreeMap<>(postagensPorCategoria); // o TreeMap ordena as Keys de String em ordem alfabética

        return postagensPorCategoriaOrdenada;
    }
}
