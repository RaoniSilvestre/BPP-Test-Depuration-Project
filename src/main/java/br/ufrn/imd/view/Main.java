package br.ufrn.imd.view;

import br.ufrn.imd.model.Catalogo;
import br.ufrn.imd.model.Pedido;
import br.ufrn.imd.model.Produto;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Iniciando programa");

        Catalogo catalogo = new Catalogo();
        logger.info("Inicializando catálogo");

        Produto produto1 = new Produto(1, "Geladeira", 1899.99);
        Produto produto2 = new Produto(2, "Freezer", 899.99);
        Produto produto3 = new Produto(3, "Ar condicionado", 2599.99);
        logger.info("Inicializando produtos");

        catalogo.adicionarProduto(produto1);
        catalogo.adicionarProduto(produto2);
        catalogo.adicionarProduto(produto3);
        logger.info("Produtos adicionados ao catálogo");

        Pedido pedido = new Pedido("Jorge Amado");
        logger.info("Pedido do " + pedido.getClienteComprador() + " inicializado");

        catalogo.buscarProdutoPorId(1).ifPresent(pedido::adicionarProduto);
        logger.info("Produto " + produto1.getNome() + " adicionado ao carrinho de " + pedido.getClienteComprador());

        catalogo.buscarProdutoPorId(2).ifPresent(pedido::adicionarProduto);
        logger.info("Produto " + produto2.getNome() + " adicionado ao carrinho de " + pedido.getClienteComprador());

        logger.info("Total do pedido com desconto de 10%: " + pedido.calcularTotal());

    }
}