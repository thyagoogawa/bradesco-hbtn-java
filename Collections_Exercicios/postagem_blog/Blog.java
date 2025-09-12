import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Blog {

    private List<Post> posts = new ArrayList<>();

    public void adicionarPostagem(Post post) throws Exception { 
        for (Post p : posts) {
            if (post.getAutor().equals(p.getAutor()) && post.getTitulo().equals(p.getTitulo())) {
                throw new Exception("Postagem jah existente");
            }
        }

        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {                        
              
        Set<Autor> conjuntoNomesOrdenados = new TreeSet<>(Comparator.comparing(Autor::getNome));

        for (Post post : posts) {
            conjuntoNomesOrdenados.add(post.getAutor()); // o HashSet remove duplicados
        }

        return conjuntoNomesOrdenados;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() { 
 
        Map<Categorias, Integer> postagensPorCategoria = new HashMap<>();

        int postagens;

        for (Post post : posts) {

            Categorias categoria = post.getCategoria();

            if ( !postagensPorCategoria.containsKey(categoria)) {
                postagensPorCategoria.put(categoria, 1);

            } else {
                postagens = postagensPorCategoria.get(categoria) + 1;
                postagensPorCategoria.put(categoria, postagens) ;
            }

        }

        return postagensPorCategoria;
    }

    /*  recebe um autor como parâmetro e retorna um Set de posts daquele autor, 
        deve-se retornar os posts ordenados pelo título */
    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> sortedPosts = new TreeSet<>(Comparator.comparing(Post::getTitulo));
        
        for (Post post : posts) {
            if (post.getAutor().getNome().equals(autor.getNome()) &&
                post.getAutor().getSobrenome().equals(autor.getSobrenome())) {
                sortedPosts.add(post);
            }
        }

        return sortedPosts;
    }
}
