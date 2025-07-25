package Heranca_Exercicios.pedido_livraria;

import produtos.Produto;

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

