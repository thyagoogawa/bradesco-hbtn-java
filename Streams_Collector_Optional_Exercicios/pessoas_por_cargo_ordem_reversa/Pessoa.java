import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {

    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
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

    @Override
    public int compareTo(Pessoa pessoa) {
        int thisCargoAscii = this.getCargo().charAt(0);
        int pessoaCargoAscii = pessoa.getCargo().charAt(0); // Faz a conversao impliscita do char para o ascii.
        return Integer.compare(thisCargoAscii, pessoaCargoAscii);
    }

    @Override
    public String toString() {
        return String.format(new Locale("pt", "BR"), "[%d] %s %s %d R$ %f", 
                this.codigo, this.nome, this.cargo, this.idade, this.salario);
    }

}