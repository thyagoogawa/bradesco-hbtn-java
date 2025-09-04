public class Aluno {

    private String nome;
    private int idade;

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getidade(){
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno [nome = " + this.nome + ", idade = " + this.idade + "]" ;
    }

}