public class Produto {
    
    String nome;
    double preco;
    double peso;
    int quantidadeEmEstoque;
    TiposProduto tipo;

    public Produto(String nome, double preco, double peso, int quantidadeEmEstoque, TiposProduto tipo) {
        this.nome = nome;
        this.preco = preco;
        this.peso = peso;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPeso() {
        return this.peso;
    }

    public int getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }

    public TiposProduto getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return String.format("%s %f %f %d %s", 
            this.nome, this.preco, this.peso, this.quantidadeEmEstoque, this.tipo);
    }

}
