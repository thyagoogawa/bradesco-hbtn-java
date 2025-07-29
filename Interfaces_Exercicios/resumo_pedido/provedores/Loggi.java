public class Loggi implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        if (peso > 5000) {
            // valor do frete é 12% maior.
        } else {
            // valor do frete é 4% maior.
        }
        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
    
}