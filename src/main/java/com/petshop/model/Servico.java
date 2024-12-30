package com.petshop.model;

public class Servico {
    private Long id;
    private String tipo;
    private float valor;
    private String descricaoServ;

    public Servico(){

    }

    public Servico(Long id, String tipo, float valor, String descricaoServ) {
        this.id= id;
        this.tipo = tipo;
        this.valor = valor;
        this.descricaoServ = descricaoServ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }



    public String getDescricaoServ() {
        return descricaoServ;
    }

    public void setDescricaoServ(String descricaoServ) {
        this.descricaoServ = descricaoServ;
    }
}
