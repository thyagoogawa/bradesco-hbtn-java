public class ContaBancariaControlada extends ContaBancariaBasica {

    private double saldoMinimo;
    private double valorPenalidade;
    
    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    void aplicarAtualizacaoMensal() {
        super.aplicarAtualizacaoMensal();
        double saldoPenalizado = super.getSaldo() - obterValorPenalidade();
        super.setSaldo(saldoPenalizado);
    }

    double obterValorPenalidade() {
        if (super.getSaldo() < saldoMinimo) {
            return valorPenalidade;
        }
        return 0;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public double getValorPenalidade() {
        return valorPenalidade;
    }

}