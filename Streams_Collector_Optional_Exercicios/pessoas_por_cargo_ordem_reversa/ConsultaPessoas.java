import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

import java.util.Comparator;

public class ConsultaPessoas {

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(groupingBy(
                Pessoa::getCargo, // Function
                () -> new TreeMap<>(Comparator.reverseOrder()), // Supplier -- () -> new TreeMap<>(Comparator.comparing(Pessoa::getCargo).reversed())
                toCollection(TreeSet::new) // Collector
            )
        );
    }
    
}
