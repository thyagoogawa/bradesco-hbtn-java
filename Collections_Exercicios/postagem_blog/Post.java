public class Post  { // implements Comparable<Post>

    private Autor autor; 
    private String titulo; 
    private String corpo; 
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return this.corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Categorias getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

/* Nâo é nesessário implementar a interface Comparable e sobrescrever o método compareTo(),
 * uma vez que o método Comparator.comparing() já tem uma definição para utilizar a ordem
 * natural (alfabética) para classificar Strings.
*/
/*
    @Override
    public int compareTo(Post post) {
        int thisTituloCharAscii = this.titulo.charAt(0);
        int postTituloCharAscii = post.getTitulo().charAt(0);
        return Integer.compare(thisTituloCharAscii, postTituloCharAscii);
    }
*/
    @Override
    public String toString() {
        return this.titulo;
    }

}
