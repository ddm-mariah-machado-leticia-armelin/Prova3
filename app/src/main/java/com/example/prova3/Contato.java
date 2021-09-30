package com.example.prova3;

public class Contato {

    private String nome;
    private Double nota1;
    private Double nota2;
    private Double media;

    public Contato ( String nome, Double nota1, Double nota2) {

        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {

        return nome;
    }

    public Double getNota1() {

        return nota1;
    }

    public Double getNota2() {

        return nota2;
    }
    public Double getMedia() {
        media= (nota1 + nota2)/2;

        return media;
    }
}
