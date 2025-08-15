import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura

        // efetue a leitura do arquivo
        System.out.printf("Conteúdo do arquivo '%s':\n\n", fileName);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            
            String linha = bufferedReader.readLine();

            while (linha != null) {
                System.out.println(linha);
                linha = bufferedReader.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        System.out.println("\nLeitura do arquivo concluída.");
    }
}