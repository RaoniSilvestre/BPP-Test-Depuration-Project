package br.ufrn.imd.model;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class LojaTest {

    @Test
    void testeCompleto() {

        Catalogo catalogo = new Catalogo();

        Produto produto1 = new Produto(1, "Geladeira", 1899.99);
        Produto produto2 = new Produto(2, "Freezer", 899.99);
        Produto produto3 = new Produto(3, "Ar condicionado", 2599.99);

        catalogo.adicionarProduto(produto1);
        catalogo.adicionarProduto(produto2);
        catalogo.adicionarProduto(produto3);

        Assertions.assertEquals(catalogo.buscarProdutoPorId(1), Optional.of(produto1));
        Assertions.assertEquals(catalogo.buscarProdutoPorId(2), Optional.of(produto2));
        Assertions.assertEquals(catalogo.buscarProdutoPorId(3), Optional.of(produto3));

        Pedido pedido = new Pedido("Jorge Amado");

        Optional<Produto> id1Product = catalogo.buscarProdutoPorId(1);
        id1Product.ifPresent(pedido::adicionarProduto);

        Assertions.assertEquals(1899.99 * 0.9,pedido.calcularTotal());

        Optional<Produto> id2Product = catalogo.buscarProdutoPorId(2);
        id2Product.ifPresent(pedido::adicionarProduto);

        Assertions.assertEquals((1899.99 + 899.99) * 0.9,pedido.calcularTotal());
    }
}
