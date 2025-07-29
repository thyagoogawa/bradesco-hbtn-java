public class Pedido {
    
    private int codigo;
    private double peso;
    private double total;
    private Frete frete;

    public Pedido (int codigo, double peso, double total, Frete frete) {
        this.codigo = codigo;
        this.peso = peso;
        this.total = total;
        this.frete = frete;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public double getTotal() {
        return total;
    }

    public Frete getFrete() {
        return frete;
    }

}
