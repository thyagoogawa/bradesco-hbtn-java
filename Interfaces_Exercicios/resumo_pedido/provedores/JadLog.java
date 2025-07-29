public class JadLog implements ProvedorFrete {

    @Override
    public Frete calcularFrete(double peso, double valor) {
        if (peso > 2000) {
            // valor do frete é 7% maior.
        } else {
            // valor do frete é 4,5% maior.
        }
        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }

}