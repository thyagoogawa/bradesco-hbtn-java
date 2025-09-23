import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {

        return pessoas.stream().collect(Collectors.groupingBy(
            Pessoa::getCargo,
            Collectors.mapping(
                pessoa -> pessoa,
                Collectors.toList()
            )));

    }

    /*
     *  inclua o método estático para listar a Idades das pessoas agrupadas por cargo:
        obterIdadePorCargo: recebe uma lista de Pessoa e retorna um Map<String, List<Integer>> 
        que contém o nome do cargo como chave do Map 
        e a lista de idades de pessoas daquele cargo como valor do Map.
        DICA: Utilizar Collectors.mapping
     * 
     */
    public static Map<String, List<Integer>> obterIdadePorCargo(List<Pessoa> pessoas) {
        
        return pessoas.stream().collect(Collectors.groupingBy(
            Pessoa::getCargo,
            Collectors.mapping(
                Pessoa::getIdade, 
                Collectors.toList()
        )));

    }
}
