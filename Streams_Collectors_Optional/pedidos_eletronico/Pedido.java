import java.util.List;

public class Pedido {

    private int codigo;
    private List<Produto> produtos;
    private Cliente cliente;

    public Pedido(int codigo, List<Produto> produtos, Cliente cliente) {
        this.codigo = codigo;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", this.codigo, this.cliente.getNome());
    }
    
}
