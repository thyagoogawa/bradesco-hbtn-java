public class Produtor extends Thread {
    private Fila fila;


    public Produtor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= 1000001; i++) {
                fila.adicionar(i);  // O produtor coloca os itens no buffer
                Thread.sleep(200);   // Simula o tempo para produzir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}