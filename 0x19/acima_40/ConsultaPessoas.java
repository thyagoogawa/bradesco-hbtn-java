import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    /* Filtra depois de gerar os mapeamentos do groupingBy, criando as chaves de cargos vazias. */
    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.filtering(
                    pessoa -> pessoa.getIdade() > 40,
                    Collectors.toList()
                )
        ));
    }

    /* Filtra antes de gerar os mapeamentos do groupingBy e evitando de gerar as chaves de 
       cargos vazias. 
       */
    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos_v0(List<Pessoa> pessoas) {
        return pessoas.stream()
            .filter(pessoa -> pessoa.getIdade() > 40)
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.toList()
        ));
    }

}
