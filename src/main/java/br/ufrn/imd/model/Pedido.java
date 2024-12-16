package br.ufrn.imd.model;

import java.util.ArrayList;

public class Pedido {
    ArrayList<Produto> carrinho;
    String clienteComprador;

    public Pedido(String cliente) {
        this.carrinho = new ArrayList<>();
        this.clienteComprador =cliente;
    }

    public String getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(String clienteComprador) {
        this.clienteComprador = clienteComprador;
    }

    public void adicionarProduto(Produto produto) {
        this.carrinho.add(produto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : this.carrinho) {
            total += produto.getPreco();
        }
        if (total > 100) {
            return 0.9 * total;
        }

        return total;
    }
}
