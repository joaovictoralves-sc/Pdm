package com.ifsc.contaclicks;

public class Planeta {
    private String nome;
    private Integer foto;

    public Planeta(String nome, Integer foto) {
        this.nome = nome;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public Integer getFoto() {
        return foto;
    }
}
