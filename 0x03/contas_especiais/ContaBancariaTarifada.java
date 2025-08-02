import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {

    int quantidadeTransacoes = 0;
    double tarifaPorTransacao = 0.10;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
    }

    @Override
    void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        descontarTarifa();
        quantidadeTransacoes++;
    }
    
    @Override
    void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        descontarTarifa();
        quantidadeTransacoes++;
    }

    void descontarTarifa() {
        super.setSaldo(super.getSaldo() - tarifaPorTransacao);
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
    
}