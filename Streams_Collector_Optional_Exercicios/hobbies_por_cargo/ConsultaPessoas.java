import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;

public class ConsultaPessoas {

    /*
     * O TreeSet no Collector nao permite cargos repetidos na colecao, mostrando somente o
     * primeiro cargo que ele encontra no stream.
     * Se for escrever e ler de forma declarativa e corrida, ficaria assim:
     * 
     * pessoas.stream().sorted(naturalOrder()).collect(groupingBy(
     *      Pessoa::getCargo, getTreeMapReverseOrder(), toList()));
     */
    public static TreeMap<String, List<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream()
            .sorted(Comparator.naturalOrder())
            .collect(groupingBy(
                Pessoa::getCargo, // Function
                getTreeMapReverseOrder(), // Supplier 
                toList() // Collector  
            )
        );
    }

    private static Supplier<TreeMap<String, List<Pessoa>>> getTreeMapReverseOrder() {
        return () -> new TreeMap<>(Comparator.reverseOrder());
    }

    /*
     * Se for escrever e ler de forma declarativa e corrida, ficaria assim:
     * 
     * pessoas.stream().collect(groupingBy(Pessoa::getCargo, counting()));
     */
    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(groupingBy(
                Pessoa::getCargo, // Function
                counting() // Collector
            )
        );
    }

    /*
     * Se for escrever e ler de forma declarativa e corrida, ficaria assim:
     * 
     * pessoas.stream().collect(groupingBy(Pessoa::getCargo, 
     *      groupingBy(Pessoa::getIdade, counting())));   
     */
    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(groupingBy(
                Pessoa::getCargo, // Function
                groupingBy( // Collector
                    Pessoa::getIdade, // Function
                    counting() // Collector
                )
            )
        );            
    }

    /*
     * Se for escrever e ler de forma declarativa e corrida, ficaria assim:
     * 
     * pessoas.stream().collect(groupingBy(Pessoa::getCargo, 
     *      averagingDouble(Pessoa::getSalario)));
     */
    public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(groupingBy(
                Pessoa::getCargo,
                averagingDouble(Pessoa::getSalario)
            )
        );
    }

    /*
     * Se for escrever e ler de forma declarativa e corrida, ficaria assim:
     * 
     * pessoas.stream().collect(groupingBy(Pessoa::getCargo, flatMapping(pessoa -> pessoa.getHobbies().stream(), 
     *      toCollection(() -> new TreeSet<String>()))));
     */
    public static Map<String, TreeSet<String>> obterHobbiesPorCargo(List<Pessoa> pessoas) {

        return pessoas.stream()
            .collect(groupingBy(
                Pessoa::getCargo, // Function
                flatMapping( // Collector
                    pessoa -> pessoa.getHobbies().stream(), // Function , abre um stream pra iterar na lista de hobbies
                    toCollection(() -> new TreeSet<String>()) // Collector
                )
            )
        );
    }

}
