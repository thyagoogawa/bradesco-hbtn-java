import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private String nomeArquivo;

    private List<Produto> produtos = new ArrayList<>();

    private void lerArquivo(boolean imprimirEstoque) {

        produtos.clear();
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nomeArquivo))) {
            
            String linha = bufferedReader.readLine();
            
            while (linha != null) {

                String[] colunas = linha.split(",");
                
                int id = Integer.parseInt(colunas[0]);
                String nome = colunas[1];
                int quantidade = Integer.parseInt(colunas[2]);
                double preco = Double.parseDouble(colunas[3]);
                Produto produto = new Produto(id, nome, quantidade, preco);
                produtos.add(produto);

                linha = bufferedReader.readLine();

                if (imprimirEstoque){
                    System.out.println(produto.toString());
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    public void adicionarProduto(String nome, int quantidade, double preco) {

        //validarQuantidadeEPreco(quantidade, preco);
        
        Produto produto = new Produto(obterNovoId(), nome, quantidade, preco);
        produtos.add(produto);

        reescreverArquivoComListaAtualizada(produtos);

        System.out.println("Produto adicionado com sucesso!");

    }

    /* 
    private void validarQuantidadeEPreco(int quantidade, double preco) {
        if (quantidade < 0) {
            throw QuantidadeNegativaException("Insira uma quantidade maior ou igual a zero");
        }
        if (preco <= 0) {
            throw PrecoMenorOuIgualAZeroException("Insira um preço maior que zero");
        }
    }
    */

    private int obterNovoId() {
        int size = produtos.size();
        Produto produto = produtos.get(size -1);
        int maiorIdSalvo = produto.getId();
        maiorIdSalvo++;
        return maiorIdSalvo;
    }

    public void excluirProduto(int idExcluir) {

        boolean idExiste = false;

        for (Produto produto : produtos) {
            if (produto.getId() == idExcluir) {
                idExiste = true;
                produtos.remove(produto);
                reescreverArquivoComListaAtualizada(produtos);
                System.out.println("Produto excluído com sucesso!\n");
                break;
            }
        }

        if ( !idExiste) {
            System.out.println("O id fornecido não existe.\n");
        }
    }

    public void exibirEstoque() {
        lerArquivo(true);
        System.out.println("--------");
    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
        
        // atualiza a lista
        for (Produto produto : produtos) {
            if (produto.getId() == idAtualizar) {
                produto.setQuantidade(novaQuantidade);
            }
        }

        reescreverArquivoComListaAtualizada(produtos);

        System.out.println("Quantidade atualizada com sucesso!\n");

    }

    public void reescreverArquivoComListaAtualizada(List<Produto> produtos) {
        // reescreve todo o arquivo com a lista atualizada
        try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
            
            for (int i = 0; i < produtos.size(); i++) {
                fileWriter.write(produtos.get(i).toCsv() + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Estoque(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        lerArquivo(false);
    }
    
}
