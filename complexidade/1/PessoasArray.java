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

    // implementar o método de buscaLinear
    public void buscaLinear(String nome){
        System.out.println("Procurando pelo nome: \"" + nome + "\"");

        boolean encontrado = false;
        int indiceAtual = 0;

        while (true) {
            if (indiceAtual == nomes.length && !encontrado) {
                throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
            }

            if (indiceAtual == nomes.length && encontrado) {
                break;
            }

            System.out.println("Passando pelo indice:" + indiceAtual);
            if (nome.compareTo(nomes[indiceAtual]) == 0) {
                encontrado = true;
                System.out.println("Nome pesquisado é " + nome + " que está na posição " + indiceAtual);
            }

            indiceAtual++;
        }

        

    }
}