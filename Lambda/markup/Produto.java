import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {

    private String nome;
    private Double preco;
    private Double percentualMarkup = 10d;
    
    public Supplier<Double> precoComMarkup = () -> preco + ((preco * percentualMarkup) / 100);
    public Consumer<Double> atualizarMarkup = markup -> setPercentualMarkup(markup);

    public Produto(Double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPercentualMarkup() {
        return this.percentualMarkup;
    }

    public void setPercentualMarkup(Double percentualMarkup) {
        this.percentualMarkup = percentualMarkup;
    }

}