import java.util.List;

public class Produtor extends Thread {
    
    private Fila fila;
    private List<Integer> taskQueue;

    public Produtor(Fila fila, List<Integer> sharedQueue) {
        this.fila = fila;
        this.taskQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10000; i++) {
                //adicionar(i);
                fila.adicionar(i);  // O produtor coloca os itens no buffer
                Thread.sleep(500);   // Simula o tempo para produzir um item
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
    private void adicionar(int item) throws InterruptedException {

        synchronized(taskQueue) {

            String threadName = Thread.currentThread().getName();
            //System.out.println("Thread atual adicionando: " + threadName);

            while (taskQueue.size() == fila.getLimiteFila()) {
                //System.out.println("A fila esta cheia!");
                taskQueue.wait();
            }

            taskQueue.add(item);
            //System.out.println("Item adicionado: " + item + " na thread " + threadName);
            taskQueue.notifyAll();
        }
    }
}