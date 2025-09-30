public class SistemaFilas {

    public static void main(String[] args) {
        
        Fila fila = new Fila();

        Produtor threadProdutor1 = new Produtor(fila);
        Produtor threadProdutor2 = new Produtor(fila);

        Consumidor threadConsumidor1 = new Consumidor(fila);
        Consumidor threadConsumidor2 = new Consumidor(fila);

        threadProdutor1.start();
        threadProdutor2.start();
        
        threadConsumidor1.start();
        threadConsumidor2.start();

    }
    
}
