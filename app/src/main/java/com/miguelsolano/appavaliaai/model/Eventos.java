package com.miguelsolano.appavaliaai.model;

import android.net.Uri;

public class Eventos {

    String titulo;
    String descricao;
    String data;
    String horarioIN;
    String horarioFN;
    String modalidade;
    String tipo;
    String status;
    String visibilidade;
    String maxPart;
    String minPart;
    String imagemUri;
    double avaliacao;

    public Eventos(String titulo, String descricao ,String data, String horarioFN,String horarioIN,
                   String visibilidade,String minPart,String maxPart,String modalidade,
                   String tipo, String status, double avaliacao, String imagemUri) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.horarioIN = horarioIN;
        this.horarioFN = horarioFN;
        //Presencial / Online / Híbrido
        this.modalidade = modalidade;
        //Evento pode ser de inúmeros tipos: culinário, esportivo, etc...
        this.tipo = tipo;
        //Ativo / Andamento / Encerrado
        this.status = status;
        //Público / Privado
        this.visibilidade = visibilidade;
        this.minPart = minPart;
        this.maxPart = maxPart;
        this.avaliacao = avaliacao;
        this.imagemUri = imagemUri;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImagemUri() {
        return imagemUri != null ? imagemUri : "";
    }

    public String getDescricao() {
        return descricao;
    }

       public String getData() {
        return data;
    }

    public String getHorarioIN() {
        return horarioIN;
    }

    public String getHorarioFN() {
        return horarioFN;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getStatus() {
        return status;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public String getMaxPart() {
        return maxPart;
    }

    public String getMinPart() {
        return minPart;
    }

    public double getAvaliacao() {
        return avaliacao;
    }
}