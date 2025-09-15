public class FolhaPagamento {

    public static double calcularLiquido(Funcionario funcionario, CalculadorDeSalario calculadorSalario) {
        return calculadorSalario.calcular(funcionario.getSalario());
    }
    
}
