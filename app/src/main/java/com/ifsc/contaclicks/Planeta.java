package com.ifsc.contaclicks;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Planeta implements Serializable {
    String nome;
    Integer imagem;

    public Planeta(String nome, Integer imagem) {
        this.nome = nome;
        this.imagem = imagem;

    }
}