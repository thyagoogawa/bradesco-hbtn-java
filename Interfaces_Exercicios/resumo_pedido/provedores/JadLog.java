package provedores;

public class JadLog implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        
        if (peso > 2000) {
            // valor do frete é 7% do valor total do pedido.
            frete.setValor(valor * 0.07);
        } else {
            // valor do frete é 4,5% do valor total do pedido.
            frete.setValor(valor * 0.045);
        }

        frete.setTipoProvedorFrete(obterTipoProvedorFrete());

        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }

}