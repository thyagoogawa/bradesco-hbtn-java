package provedores;

public class Loggi implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        
        if (peso > 5000) {
            // valor do frete é 12% do valor total do pedido.
            frete.setValor(valor * 0.12);
        } else {
            // valor do frete é 4% do valor total do pedido.
            frete.setValor(valor * 0.04);
        }

        frete.setTipoProvedorFrete(obterTipoProvedorFrete());

        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
    
}