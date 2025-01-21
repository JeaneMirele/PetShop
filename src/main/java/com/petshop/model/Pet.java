package com.petshop.model;
import java.time.LocalDate;

    public class Pet {
        private Long id;
        private String nome;
        private String especie;
        private String raca;
        private LocalDate dataNascimento;
        private Double peso;


        public Pet() {}

        public Pet(Long id, String nome, String especie, String raca, LocalDate dataNascimento, Double peso) {
            this.id = id;
            this.nome = nome;
            this.especie = especie;
            this.raca = raca;
            this.dataNascimento = dataNascimento;
            this.peso = peso;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEspecie() {
            return especie;
        }

        public void setEspecie(String tipo) {
            this.especie = especie;
        }

        public String getRaca() {
            return raca;
        }

        public void setRaca(String raca) {
            this.raca = raca;
        }

        public LocalDate getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public Double getPeso() {
            return peso;
        }

        public void setPeso(Double peso) {
            this.peso = peso;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", especie='" + especie + '\'' +
                    ", raca='" + raca + '\'' +
                    ", dataNascimento=" + dataNascimento +
                    ", peso=" + peso +
                    '}';
        }
    }


