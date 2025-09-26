import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;

public class ConsultaPessoas {

    /*
     * O TreeSet no Collector nao permite cargos repetidos na colecao, mostrando somente o
     * primeiro cargo que ele encontra no stream.
     */
    public static TreeMap<String, List<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
            .sorted(Comparator.naturalOrder())
            .collect(groupingBy(
                Pessoa::getCargo, // Function
                () -> new TreeMap<>(Comparator.reverseOrder()), // Supplier 
                toList() // Collector  
            )
        );
    }

    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(groupingBy(
                Pessoa::getCargo,
                counting()      
            )
        );
    }
}
