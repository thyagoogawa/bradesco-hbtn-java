import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {

    public static String fileName = "funcionarios.csv";
    public static void main(String[] args) {
        
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            
            String linha = bufferedReader.readLine(); // lé a linha do cabeçalho
            linha = bufferedReader.readLine(); // lé a primeira linha

            while(linha != null){
                String[] colunas = linha.split(",");
                
                System.out.println("Funcionário: " + colunas[0]);
                System.out.println("Idade: " + colunas[1]);
                System.out.println("Departamento: " + colunas[2]);
                System.out.println("Salarial: " + colunas[3]);
                System.out.println("------------------------");

                linha = bufferedReader.readLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}