import java.util.LinkedList;
import java.util.List;

/*
 * Como precisamos sincronizar o acesso entre o Produtor e o Consumidor rodando 
 * concorrentemente duas threads, basicamente, precisamos usar a mesma trava para
 * os dois. A trava se deu no objeto da lista listFila, aplicado nos dois blocos
 * synchronized, tando do metodo adicioar(), quanto do metodo retirar().
 * E como usamos 2 produtores e 2 consumidores, quando produtor lança um notifyAll(),
 * por exemplo, o outro produtor também vai tentar pegar a trava do monitor do objeto
 * critico, e se ele for primeiro a solicitar a trava ao monitor, ele vai ver que a 
 * lista estah cheia e vai cair no metodo wait do monitor do objeto, e as duas 
 * threads de consumidor vao tentar pegar a trava do monitor e a que chegar primeiro
 * irah pegar a trava e vai executar o seu codigo. E vice-versa.
 */
public class Fila {

    //List<Integer> listFila = Collections.synchronizedList(new LinkedList<>());
    List<Integer> listFila = new LinkedList<>();

    int limiteFila = 10;

    public void adicionar(int item) throws InterruptedException {

        synchronized(listFila) {

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread atual adicionando: " + threadName);

            while (listFila.size() == limiteFila) {
                System.out.println("A fila esta cheia!");
                listFila.wait();
            }

            listFila.add(item);
            System.out.println("Item adicionado: " + item + " na thread " + threadName);
            listFila.notifyAll();
        }
    }

    public void retirar() throws InterruptedException {

        synchronized(listFila) {

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread atual removendo: " + threadName);

            while (listFila.isEmpty()) {
                System.out.println("A fila esta vazia!");
                listFila.wait();
            }

            Integer removido = listFila.remove(0);
            System.out.println("Item removido: " + removido + " na thread " + threadName);
            listFila.notifyAll();
        }
    }
    
    public int getLimiteFila() {
        return this.limiteFila;
    }

}