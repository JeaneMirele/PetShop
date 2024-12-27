package com.petshop.model;

public class Servico {
    private Long id;
    private String tipo;
    private float valor;

    public Servico(){

    }

    public Servico(Long id, String tipo, float valor) {
        this.id= id;
        this.tipo = tipo;
        this.valor = valor;
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

}
