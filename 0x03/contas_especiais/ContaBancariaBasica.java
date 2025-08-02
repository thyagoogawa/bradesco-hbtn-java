import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {

    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
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
        double tarifaMensal = 10.00;
        double decimaParteDoSaldo = saldo * 0.1;
        
        if (decimaParteDoSaldo < 10.00) {
            tarifaMensal = decimaParteDoSaldo;
        }

        return tarifaMensal;
    }

    double calcularJurosMensal() {

        double taxaJurosAnualPercent = taxaJurosAnual / 100.00000;
        double taxaJurosMensalPercent = 0;

        if (saldo > 0) {
            taxaJurosMensalPercent = taxaJurosAnualPercent / 12.00000;
        } 

        return saldo * taxaJurosMensalPercent;
    }

    void aplicarAtualizacaoMensal() {
        saldo = saldo - calcularTarifaMensal() + calcularJurosMensal();
    }

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    } 

}