import java.util.LinkedList;
import java.util.List;

public class Produtor extends Thread {
    
    private Fila fila;
    private List<Integer> taskQueue = new LinkedList<>();

    public Produtor(Fila fila, List<Integer> sharedQueue) {
        this.fila = fila;
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 1000001; i++) {
                adicionar(i);  // O produtor coloca os itens no buffer
                Thread.sleep(200);   // Simula o tempo para produzir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void adicionar(int item) throws InterruptedException {

        synchronized(taskQueue) {

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread atual adicionando: " + threadName);

            while (taskQueue.size() == fila.getLimiteFila()) {
                System.out.println("A fila esta cheia!");
                taskQueue.wait();
            }

            taskQueue.add(item);
            System.out.println("Item adicionado: " + item + " na thread " + threadName);
            taskQueue.notifyAll();
        }
    }
}