package com.petshop.service;

import com.petshop.model.Produto;
import com.petshop.repository.ProdutoDao;
import java.util.List;
import java.util.stream.Collectors;


public class ProdutoService {
    private ProdutoDao produtoDao;

    public ProdutoService(){
        produtoDao = new ProdutoDao();
    }

    public List<Produto> getProdutos(){
        return produtoDao.findAll();
    }

    public boolean save(Produto produto){
        return produtoDao.save(produto);
    }

    public boolean update(Produto produto){
        return produtoDao.update(produto);
    }

    public boolean delete(Long id){
        return produtoDao.delete(id);
    }

    public List<Produto> findByName(String nome) {
        List<Produto> produtos = produtoDao.findAll();
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }
}


