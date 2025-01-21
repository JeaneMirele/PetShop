package com.petshop.model;


import java.time.LocalDate;

public class Produto {
    private Long Id;
    private String nome;
    private Long qtdEstoque;
    private Float valor;
    private LocalDate dataValidade;
    private String descricao;
    private String categoria;

    public Produto (){

    }

    public Produto(String nome, Long qtdEstoque, Float valor, LocalDate dataValidade, String descricao, String categoria) {
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valor = valor;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.categoria = categoria;
    }


    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId(){
        return Id;
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


    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade;
    }
}
