import java.util.List;
import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {

    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private List<String> hobbies; 

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCargo() {
        return this.cargo;
    }

    public int getIdade() {
        return this.idade;
    }

    public double getSalario() {
        return this.salario;
    }

    public List<String> getHobbies() {
        return this.hobbies;
    }

    /*
     * Usa o Comparator da classe String, que já está implementado para processamento
     * de ordem natural (alfabética).
     */
    @Override
    public int compareTo(Pessoa pessoa) {
        String thisNome = this.nome;
        String pessoaNome = pessoa.getNome();
        return thisNome.compareTo(pessoaNome);
    }

    @Override
    public String toString() {
        return String.format(new Locale("pt", "BR"), "[%d] %s %s %d R$ %f %s", 
                this.codigo, this.nome, this.cargo, this.idade, this.salario, this.hobbies);
    }

}