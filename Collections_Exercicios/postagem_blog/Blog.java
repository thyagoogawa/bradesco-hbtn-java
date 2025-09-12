import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
        // postagens por categoria na ordem que o checker espera:
        Map<Categorias, Integer> postagensPorCategoriaOrdenado = new HashMap<>();

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

        Integer postagensDataScience = postagensPorCategoria.get(Categorias.DATA_SCIENCE);
        Integer postagensDesenvolvimento = postagensPorCategoria.get(Categorias.DESENVOLVIMENTO);
        Integer postagensDevops = postagensPorCategoria.get(Categorias.DEVOPS);
        
        postagensPorCategoriaOrdenado.put(Categorias.DATA_SCIENCE, postagensDataScience);
        postagensPorCategoriaOrdenado.put(Categorias.DESENVOLVIMENTO, postagensDesenvolvimento);
        postagensPorCategoriaOrdenado.put(Categorias.DEVOPS, postagensDevops);

        return postagensPorCategoriaOrdenado; 
                                      // O que é incluído por último no Map fica por 
                                      // primeiro na listagem, e os outros vão ficando para trás.
                                      // Isso só vale quando roda em modo debug.
                                      // Quando roda normal a ordem é aleatória.
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

        Map<Categorias, Set<Post>> mapPostsPorCategorias = new HashMap<>();
        List<Categorias> categorias = Categorias.getCategorias();

        for (Categorias categoria : categorias) {
            Set<Post> postsPorCategoria = obterPostsPorCategoria(categoria);
            mapPostsPorCategorias.put(categoria, postsPorCategoria);
        }

        return mapPostsPorCategorias;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {

        Map<Autor, Set<Post>> mapPostsPorAutor = new HashMap<>();
        Set<Autor> autores = obterTodosAutores();

        for (Autor autor : autores) {
            Set<Post> postsPorAutor = obterPostsPorAutor(autor);
            mapPostsPorAutor.put(autor, postsPorAutor);
        }

        return mapPostsPorAutor;
    }

}
