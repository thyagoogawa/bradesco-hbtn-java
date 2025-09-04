import java.util.Scanner;


public class ArrayExercicio {


    public static void main(String[] args) {

        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);


        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;


        // Preenchendo o array com números fornecidos pelo usuário
        // Utilize scanner.nextInt(); para receber o numero digitado
        System.out.println("Digite 10 números inteiros:");

        for (int i = 0; i < 10; i++) {
            int nomeNumero = i + 1;
            System.out.println("Digite o número " + nomeNumero + ": ");
            numeros[i] = scanner.nextInt();
            i++;
        }

        // Exibindo os resultados
        String conteudoArray = "";

        for (int a = 0; a < numeros.length; a++) {
            conteudoArray = conteudoArray + numeros[a] + " ";
            soma += numeros[a];

            if (maiorNumero < numeros[a]) {
                maiorNumero = numeros[a];
            }
        }

        System.out.println("Conteúdo do array:");
        System.out.println(conteudoArray);

        System.out.printf("Soma de todos os números: %d\n", soma);
        System.out.printf("Maior número no array: %d%n", maiorNumero);

        // Fechando o scanner
        scanner.close();
    }
}