package br.ufrn.imd.model;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CatalogoTest {

    private Catalogo mockCatalogo;

    @BeforeEach
    void setup() {
        mockCatalogo = new Catalogo();
    }

    @Test
    void testAdicionarProduto() {
        Produto produto = new Produto(1, "Geladeira", 1900.99);
        mockCatalogo.adicionarProduto(produto);

        Assertions.assertEquals(mockCatalogo.buscarProdutoPorId(1), Optional.of(produto));
        Assertions.assertEquals(mockCatalogo.buscarProdutoPorId(2), Optional.empty());
    }

    @Test
    void listarProdutos() {
        Produto produto1 = new Produto(1, "Geladeira", 1899.99);
        Produto produto2 = new Produto(2, "Freezer", 899.99);
        Produto produto3 = new Produto(3, "Ar condicionado", 2599.99);

        mockCatalogo.adicionarProduto(produto1);
        mockCatalogo.adicionarProduto(produto2);
        mockCatalogo.adicionarProduto(produto3);

        ArrayList<Produto> produtos = mockCatalogo.listarProdutos();

        Assertions.assertEquals(produtos, List.of(produto1, produto2, produto3));

    }
}