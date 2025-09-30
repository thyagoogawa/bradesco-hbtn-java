public class Consumidor extends Thread {
    private Fila fila;


    public Consumidor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= 1000001; i++) {
                fila.retirar();  // O consumidor retira os itens do buffer
                Thread.sleep(500);  // Simula o tempo para consumir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}