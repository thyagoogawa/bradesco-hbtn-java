package Heranca.salario;

public class Gerente extends Empregado {

    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            double bonusPart1 = super.getSalarioFixo() * 0.20;
            double bonusPart2 = (departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01;
            return bonusPart1 + bonusPart2;
        }
        return 0;
    }

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }
    
}
