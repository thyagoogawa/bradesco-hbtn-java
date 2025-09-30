class ThreadContador extends Thread {
    private Contador contador;


    public ThreadContador(Contador contador) {
        this.contador = contador;
    }


    @Override
    public void run() {
        //String nomeThread = Thread.currentThread().getName();
        //System.out.println("Thread iniciada: " + nomeThread);

        // Cada thread incrementa o contador 1000 vezes
        for (int i = 0; i < 1000; i++) {
//            System.out.println("Thread executando: " + nomeThread + " contador: " + contador.getContagem());
            contador.incrementar();
        }

        //System.out.println("Thread finalizando: " + nomeThread);
    }
}