import java.util.LinkedList;
import java.util.List;

public class SistemaFilas {

    public static void main(String[] args) {
        
        Fila fila = new Fila();
        List<Integer> sharedQueue = new LinkedList<>();

        Produtor threadProdutor1 = new Produtor(fila, sharedQueue);
        Produtor threadProdutor2 = new Produtor(fila, sharedQueue);

        Consumidor threadConsumidor1 = new Consumidor(fila, sharedQueue);
        Consumidor threadConsumidor2 = new Consumidor(fila, sharedQueue);

        threadProdutor1.start();
        threadProdutor2.start();
        
        threadConsumidor1.start();
        threadConsumidor2.start();

        //System.exit(0);

    }
    
}
