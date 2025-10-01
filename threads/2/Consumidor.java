import java.util.List;

public class Consumidor extends Thread {
    
    private Fila fila;
    private List<Integer> taskQueue;

    public Consumidor(Fila fila, List<Integer> sharedQueue) {
        this.fila = fila;
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10000; i++) {
                //retirar();
                fila.retirar();  // O consumidor retira os itens do buffer
                Thread.sleep(500);  // Simula o tempo para consumir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Conseguimos usar o synchronized aqui, ao invez de usar na classe Fila, contanto 
     * que passemos a mesma referencia do objeto listFila para o objeto local taskQueue, 
     * que irah apontar para a mesma referencia de memoria do objeto critico listFila.
     */
    private void retirar() throws InterruptedException {

        synchronized(taskQueue) {

            String threadName = Thread.currentThread().getName();
            //System.out.println("Thread atual removendo: " + threadName);

            while (taskQueue.isEmpty()) {
                //System.out.println("A fila esta vazia!");
                taskQueue.wait();
            }

            Integer removido = taskQueue.remove(0);
            //System.out.println("Item removido: " + removido + " na thread " + threadName);
            taskQueue.notifyAll();
        }
    }
}