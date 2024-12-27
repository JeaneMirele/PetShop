package com.petshop.model;

import java.time.LocalDate;

public class Produto {
    private Long id;
    private String nome;
    private Long qtdEstoque;
    private float valor;
    private LocalDate dataValidade;
    private String descricao;
    private String categoria;

    public Produto (){

    }

    public Produto(Long id, String nome, Long qtdEstoque, float valor, LocalDate dataValidade, String descricao, String categoria) {
        this.id= id;
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valor = valor;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.categoria = categoria;
    }

     public Long getId(){
        return id;
     }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Long qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
