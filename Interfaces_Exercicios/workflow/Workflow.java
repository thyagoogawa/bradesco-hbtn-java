import java.util.ArrayList;
import java.util.List;
import atividades.Atividade;

public class Workflow {

    private List<Atividade> listaAtividades = new ArrayList<>();

    void registrarAtividade(Atividade atividade) {
        listaAtividades.add(atividade);
    }

    public List<Atividade> getListaAtividades() {
        return listaAtividades;
    }

}
