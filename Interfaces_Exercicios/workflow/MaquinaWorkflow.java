import atividades.Atividade;

public class MaquinaWorkflow {

    void executar(Workflow workflowEncodificarVideos) {
        for (Atividade atividade : workflowEncodificarVideos.getListaAtividades()) {
            atividade.executar(); // Exemplo de polimorfismo
        }
    }

}
