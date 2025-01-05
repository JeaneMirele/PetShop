package com.petshop.service;

import com.petshop.model.Produto;
import com.petshop.repository.ProdutoDao;
import java.util.List;

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

    public boolean update(Produto produto, String[] params){
        return produtoDao.update(produto, params);
    }

    public boolean delete(Long id){
        return produtoDao.delete(id);
    }
}

