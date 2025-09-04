import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {

    private static List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        
        //Adicionará três alunos.
        adicionarAluno("Carlos", 36);
        adicionarAluno("Fabio", 28);
        adicionarAluno("Ana", 25);

        //Exibirá a lista de alunos.
        listarAlunos();

        //Buscará por um aluno.
        buscarAluno("Ana");

        //Excluirá um aluno.
        excluirAluno("Fabio");

        //Tentará excluir um aluno inexistente e buscará outro aluno.
        excluirAluno("Fabio");
    }
    
    public static void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        alunos.add(aluno);
    }
    
    public static void excluirAluno(String nome) {
        System.out.println("Excluindo aluno: " + nome);
        for (Aluno aluno : alunos) {
            if (aluno.getNome().compareTo(nome) == 0) {
                alunos.remove(aluno);
            }
        }
        listarAlunos();
    }
    
    public static void buscarAluno(String nome) {
        System.out.println("Buscando aluno:");
        for (Aluno aluno : alunos) {
            if (aluno.getNome().compareTo(nome) == 0) {
                System.out.println(aluno);
            }
        }
    }

    public static void listarAlunos() {
        System.out.println("Listando alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

}
