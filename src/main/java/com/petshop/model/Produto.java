package com.petshop.model;


import java.time.LocalDateTime;

public class Produto {
    private Long id;
    private String nome;
    private Long qtdEstoque;
    private float valor;
    private LocalDateTime dataValidade;
    private String descricao;
    private String categoria;

    public Produto (){

    }

    public Produto(Long id, String nome, Long qtdEstoque, float valor, LocalDateTime dataValidade, String descricao, String categoria) {
        this.id= id;
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valor = valor;
        this.dataValidade = dataValidade;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
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
