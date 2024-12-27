package com.petshop.model;


public class Funcionario{
    private Long id;
    private String nome;
    private float salario;
    private String telefone;
    private String cargo;

    public Funcionario(){

    }

    public Funcionario(Long id, String nome, float salario, String telefone, String cargo) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
        this.cargo = cargo;
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

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}