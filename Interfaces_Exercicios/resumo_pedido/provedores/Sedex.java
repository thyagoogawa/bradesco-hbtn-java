public class Sedex implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        if (peso > 1000) {
            // valor do frete é 10% maior.
        } else {
            // valor do frete é 5% maior.
        }
        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
    
}