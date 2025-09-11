import java.util.HashMap;
import java.util.Map;

public class Armazem<T> implements Armazenavel<T> {

    Map<String, T> items = new HashMap<>();

    @Override
    public void adicionarAoInventario(String nome, T valor) {
        items.put(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return items.get(nome);
    }
    
}
