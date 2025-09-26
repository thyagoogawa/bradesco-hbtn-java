public class Autor { // implements Comparable<Autor>

    private String nome; 
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

/* Nâo é nesessário implementar a interface Comparable e sobrescrever o método compareTo(),
 * uma vez que o método Comparator.comparing() já tem uma definição para utilizar a ordem
 * natural (alfabética) para classificar Strings.
*/
/*
    @Override
    public int compareTo(Autor arg0) {
        int nomeCharAscii = this.nome.charAt(0);
        int arg0CharAscii = arg0.getNome().charAt(0);
        return Integer.compare(nomeCharAscii, arg0CharAscii);
    } 
 */
    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }

}