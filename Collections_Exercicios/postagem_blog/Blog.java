import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
 
        // O LinkedHashMap eh ordenado pela ordem de insercao, pois ele utiliza a Double Linked List
        Map<Categorias, Integer> postagensPorCategoria = new LinkedHashMap<>(); 

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

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> sortedPosts = new TreeSet<>(Comparator.comparing(Post::getTitulo));

        for (Post post : posts) {
            if (post.getCategoria().equals(categoria)) {
                sortedPosts.add(post);
            }
        }

        return sortedPosts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {

        // O LinkedHashMap eh ordenado pela ordem de insercao, pois ele utiliza a Double Linked List
        Map<Categorias, Set<Post>> mapPostsPorCategorias = new LinkedHashMap<>();
        List<Categorias> categorias = Categorias.getCategorias();

        for (Categorias categoria : categorias) {
            Set<Post> postsPorCategoria = obterPostsPorCategoria(categoria);
            mapPostsPorCategorias.put(categoria, postsPorCategoria);
        }

        return mapPostsPorCategorias;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {

        // O LinkedHashMap eh ordenado pela ordem de insercao, pois ele utiliza a Double Linked List
        Map<Autor, Set<Post>> mapPostsPorAutor = new LinkedHashMap<>();
        Set<Autor> autores = obterTodosAutores();

        for (Autor autor : autores) {
            Set<Post> postsPorAutor = obterPostsPorAutor(autor);
            mapPostsPorAutor.put(autor, postsPorAutor);
        }

        return mapPostsPorAutor;
    }

}
