package com.miguelsolano.appavaliaai.model;
public class Eventos {

    String titulo;
    String data;
    String status;
    String tipo;
    String categoria;
    double avaliacao;

    public Eventos(String titulo, String data, String status, String tipo, String categoria, double avaliacao) {
        this.titulo = titulo;
        this.data = data;
        this.status = status;
        this.tipo = tipo;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getAvaliacao() {
        return avaliacao;
    }
}