import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {

    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double saldo) {
        this.numeracao = numeracao;
        this.saldo = saldo;
        this.taxaJurosAnual = 0;
    }

    void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        saldo += valor;
    }

    void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (saldo < valor) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        saldo -= valor;
    }

    double calcularTarifaMensal() {
        double tarifaMensal = 0;
        double decimaParteDoSaldo = saldo * 0.1;
        
        if (decimaParteDoSaldo < 10.00) {
            tarifaMensal = decimaParteDoSaldo;
        } else {
            tarifaMensal = 10.00;
        }

        return tarifaMensal;
    }

    double calcularJurosMensal() {
        double taxaJuros = 0;
        double valorJuros = 0;

        if (saldo > 0) {

        }

        return taxaJuros;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

}