import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fila {

    //List<Integer> listFila = Collections.synchronizedList(new LinkedList<>());
    List<Integer> listFila = new LinkedList<>();

    int limiteFila = 10;

    public int getLimiteFila() {
        return this.limiteFila;
    }

}