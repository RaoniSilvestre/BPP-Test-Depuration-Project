package br.ufrn.imd.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void calcularTotalSemDesconto() {
        Pedido pedido = new Pedido("Jorge Amado");
        Produto produto0 = new Produto(0, "Caderno", 19.99);

        pedido.adicionarProduto(produto0);
        assertEquals(19.99,
                pedido.calcularTotal());
    }

    @Test
    void calcularTotalComDesconto() {
        Pedido pedido = new Pedido("Pedro da roça");

        Produto produto1 = new Produto(1, "Geladeira", 1899.99);
        Produto produto2 = new Produto(2, "Freezer", 899.99);
        Produto produto3 = new Produto(3, "Ar condicionado", 2599.99);

        pedido.adicionarProduto(produto1);
        assertEquals(1899.99 * 0.9, pedido.calcularTotal());

        pedido.adicionarProduto(produto2);
        assertEquals((1899.99 + 899.99) * 0.9, pedido.calcularTotal());

        pedido.adicionarProduto(produto3);
        assertEquals((1899.99 + 899.99 + 2599.99) * 0.9, pedido.calcularTotal());
    }
}