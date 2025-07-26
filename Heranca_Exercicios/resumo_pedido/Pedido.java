import java.util.Locale;
import produtos.Produto;
import produtos.Livro;
import produtos.Dvd;

public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itensPedido;

    public Pedido(double percentualDesconto, ItemPedido[] itensPedido) {
        this.percentualDesconto = percentualDesconto;
        this.itensPedido = itensPedido;
    }

    public double calcularTotal() {
        double soma = 0;
        for (int i = 0; i < itensPedido.length; i++) {
            ItemPedido itemPedido = itensPedido[i];
            Produto produto = itemPedido.getProduto();
            soma = soma + (produto.obterPrecoLiquido() * itemPedido.getQuantidade());
        }
        percentualDesconto = percentualDesconto / 100;
        return soma - (soma * percentualDesconto);
    }

    public double calcularTotalSemDesconto() {
        double soma = 0;
        for (int i = 0; i < itensPedido.length; i++) {
            ItemPedido itemPedido = itensPedido[i];
            Produto produto = itemPedido.getProduto();
            soma = soma + (produto.obterPrecoLiquido() * itemPedido.getQuantidade());
        }
        return soma;
    }
    
    public double calcularDesconto(double total) {
        percentualDesconto = percentualDesconto / 100;
        return total - (total * percentualDesconto);
    }
    
    public void apresentarResumoPedido() {
        System.out.printf(new Locale("pt","BR"), "------- RESUMO PEDIDO -------\n");

        for (int i = 0; i < itensPedido.length; i++ ) {
            apresentarTotalDeCadaItemPedido(itensPedido[i]);
        }
        
        System.out.printf(new Locale("pt","BR"), "----------------------------\n");
        System.out.printf(new Locale("pt","BR"), "DESCONTO: %.2f\n", calcularDesconto(calcularTotalSemDesconto()));
        System.out.printf(new Locale("pt","BR"), "TOTAL PRODUTOS: %.2f\n", calcularTotalSemDesconto());
        System.out.printf(new Locale("pt","BR"), "----------------------------\n");
        System.out.printf(new Locale("pt","BR"), "TOTAL PEDIDO: %.2f\n", calcularTotal());
        System.out.printf(new Locale("pt","BR"), "----------------------------\n");
    }

    private void apresentarTotalDeCadaItemPedido(ItemPedido itemPedido) {
       
        String nomeInstanciaProduto = getNomeInstanciaProduto(itemPedido);
        String titulo = itemPedido.getProduto().getTitulo();
        double precoLiquido = itemPedido.getProduto().obterPrecoLiquido();
        int quantidade = itemPedido.getQuantidade();
        double total = precoLiquido * quantidade;
        
        System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n", 
                nomeInstanciaProduto,
                titulo,
                precoLiquido,
                quantidade,
                total
        );
    }

    private String getNomeInstanciaProduto(ItemPedido itemPedido) {
        return itemPedido.getProduto().getClass().getSimpleName();
    }

    private String getNomeInstanciaProduto_queTambemFunciona1(ItemPedido itemPedido) {
        String nomeInstancia = "";
        
        if (itemPedido.getProduto() instanceof Livro) {
            nomeInstancia = Livro.class.getSimpleName();
        }

        if (itemPedido.getProduto() instanceof Dvd) {
            nomeInstancia = Dvd.class.getSimpleName();
        }

        return nomeInstancia;
    }

    private String getNomeInstanciaProduto_queTambemFunciona2(ItemPedido itemPedido) {
        String nomeInstancia = "";
        
        if (Livro.class.isInstance(itemPedido.getProduto())) {
            nomeInstancia = Livro.class.getSimpleName();
        }
            
        if (Dvd.class.isInstance(itemPedido.getProduto())) {
            nomeInstancia = Dvd.class.getSimpleName();
        }

        return nomeInstancia;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itensPedido;
    }

    public void setItens(ItemPedido[] itensPedido) {
        this.itensPedido = itensPedido;
    }

}