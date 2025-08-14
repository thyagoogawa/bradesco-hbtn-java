import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();


        // implemente o codigo aqui
        try (FileWriter fileWriter = new FileWriter(fileName)) {
        
            System.out.println("Digite novas linhas. Para fechar e salvar, digite 'sair' e tecle Enter :");
            String linha = "";

            //while( !linha.contains("sair")) {
            //    linha = scanner.nextLine();
            //    fileWriter.write(linha + "\n");
            //}

            while(true) {
                linha = scanner.nextLine();
                fileWriter.write(linha + "\n");
                if (linha.contains("sair"))
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();

        System.out.println("Arquivo salvo com sucesso!");

    }
}