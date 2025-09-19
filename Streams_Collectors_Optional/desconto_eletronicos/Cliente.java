public class Cliente {

    private int codigo;
    private String nome;
    private boolean premium;

    public Cliente(int codigo, String nome, boolean premium) {
        this.codigo = codigo;
        this.nome = nome;
        this.premium = premium;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isPremium() {
        return this.premium;
    }
}