import provedores.Frete;
import provedores.ProvedorFrete;

public class ProcessadorPedido {
    ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }

    public void processar(Pedido pedido) {
        // Criou um polimorfismo com a invocação da interface:
        Frete frete = provedorFrete.calcularFrete(pedido.getPeso(), pedido.getTotal());
        pedido.setFrete(frete);
    }

}