public class Produto {
    
    private int codigo;
    private String nome;
    private CategoriaProduto categoria;
    private double preco;

    public Produto(int codigo, String nome, CategoriaProduto categoria, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public CategoriaProduto getCategoriaProduto() {
        return this.categoria;
    }

    public double getPreco() {
        return this.preco;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s R$ %.2f" , this.codigo, this.nome, this.categoria, this.preco);
    }

}
