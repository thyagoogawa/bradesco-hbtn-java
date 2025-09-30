import java.util.LinkedList;
import java.util.List;

public class Consumidor extends Thread {
    
    private Fila fila;
    private List<Integer> taskQueue = new LinkedList<>();

    public Consumidor(Fila fila, List<Integer> sharedQueue) {
        this.fila = fila;
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 1000001; i++) {
                retirar();  // O consumidor retira os itens do buffer
                Thread.sleep(500);  // Simula o tempo para consumir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void retirar() throws InterruptedException {

        synchronized(taskQueue) {

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread atual removendo: " + threadName);

            while (taskQueue.isEmpty()) {
                System.out.println("A fila esta vazia!");
                taskQueue.wait();
            }

            Integer removido = taskQueue.remove(0);
            System.out.println("Item removido: " + removido + " na thread " + threadName);
            taskQueue.notifyAll();
        }
    }
}