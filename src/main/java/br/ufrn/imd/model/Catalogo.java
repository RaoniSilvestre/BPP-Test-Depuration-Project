package br.ufrn.imd.model;

import java.util.ArrayList;
import java.util.Optional;

public class Catalogo {
    ArrayList<Produto> catalogo;

    public Catalogo() {
        this.catalogo = new ArrayList<Produto>();
    }

    public void adicionarProduto(Produto produto) {
        this.catalogo.add(produto);
    }

    public ArrayList<Produto> listarProdutos() {
        return this.catalogo;
    }

    public Optional<Produto> buscarProdutoPorId(int id) {
        for (Produto produto : this.catalogo) {
            if (produto.getId() == id) return Optional.of(produto);
        }
        return Optional.empty();
    }
}
