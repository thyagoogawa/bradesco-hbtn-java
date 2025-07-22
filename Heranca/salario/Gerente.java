package Heranca.salario;

public class Gerente extends Empregado {

    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            return super.getSalarioFixo() * 0.20;
        }
        return 0;
    }

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }
    
}
