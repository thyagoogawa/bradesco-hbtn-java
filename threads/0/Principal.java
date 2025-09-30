public class Principal {

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        ThreadContador thread1 = new ThreadContador(contador);
        ThreadContador thread2 = new ThreadContador(contador);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.printf("Valor final do contador: %d\n", contador.getContagem());

    }
    
}
