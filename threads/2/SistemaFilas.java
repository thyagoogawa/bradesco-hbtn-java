import java.util.LinkedList;
import java.util.List;

public class SistemaFilas {

    public static void main(String[] args) throws InterruptedException {
        
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

        Thread.sleep(20000); // Deixa a thread principal dormindo enquanto as suas sub-threads
                             // continuam sua execucao paralela.
        
        System.exit(0);      // Encerra a thread principal, encerrando todas as sub-threads.

    }
    
}
