import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fila {

    List<Integer> listFila = Collections.synchronizedList(new LinkedList<>());
    //List<Integer> listFila = new LinkedList<>();

    Object lock1 = new Object();
    Object lock2 = new Object();

    int limiteFila = 10;

    public synchronized void adicionar(int item) throws InterruptedException {

        //synchronized(lock1) {

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread atual adicionando: " + threadName);

            while (this.listFila.size() == limiteFila) {
                System.out.println("A fila esta cheia!");
                listFila.wait();
            }

            listFila.add(item);
            System.out.println("Item adicionado: " + item + " na thread " + threadName);
            listFila.notifyAll();
        //}
    }

    public synchronized void retirar() throws InterruptedException {

        //synchronized(lock2) {

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread atual removendo: " + threadName);

            while (this.listFila.size() == 0) {
                System.out.println("A fila esta vazia!");
                listFila.wait();
            }

            Integer removido = listFila.remove(0);
            System.out.println("Item removido: " + removido + " na thread " + threadName);
            listFila.notifyAll();
        //}
    }

}