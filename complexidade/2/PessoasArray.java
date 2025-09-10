public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome) throws Exception {
        System.out.println("Procurando o nome: \"" + nome + "\"");

        boolean encontrado = false;

        int inicio = 0;
        int fim = nomes.length -1;
        int meio = (inicio + fim) / 2;
        
        while(!encontrado) {
            int nomeAscii = nome.charAt(0); // Converte char em int para obter valor ASCII
            int meioAscii = nomes[meio].charAt(0); // Converte char em int para obter valor ASCII

            System.out.println("Passando pelo indice: " + meio);

            if (nomeAscii < meioAscii) {
                fim = meio - 1;
                meio = (inicio + fim) / 2;

            } else if (nomeAscii > meioAscii) {
                inicio = meio + 1;
                meio = (inicio + fim) / 2;

            } else if (nomeAscii == meioAscii) {
                if (nome.equals(nomes[meio])) {
                    encontrado = true;
                    System.out.println("Nome " + nome + " encontrado na posição " + meio);
                } else {
                    throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
                }
            } 
        }
    }
}