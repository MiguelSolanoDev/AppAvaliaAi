package com.miguelsolano.appavaliaai.model;

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

    public Eventos() {
    }

    public Eventos(String titulo, String descricao, String data, String horarioFN, String horarioIN,
                   String visibilidade, String minPart, String maxPart, String modalidade,
                   String tipo, String status, double avaliacao) {

        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.horarioIN = horarioIN;
        this.horarioFN = horarioFN;
        this.modalidade = modalidade;
        this.tipo = tipo;
        this.status = status;
        this.visibilidade = visibilidade;
        this.minPart = minPart;
        this.maxPart = maxPart;
        this.avaliacao = avaliacao;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getData() { return data; }
    public String getHorarioIN() { return horarioIN; }
    public String getHorarioFN() { return horarioFN; }
    public String getModalidade() { return modalidade; }
    public String getTipo() { return tipo; }
    public String getStatus() { return status; }
    public String getVisibilidade() { return visibilidade; }
    public String getMaxPart() { return maxPart; }
    public String getMinPart() { return minPart; }
    public double getAvaliacao() { return avaliacao; }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorarioIN(String horarioIN) {
        this.horarioIN = horarioIN;
    }

    public void setHorarioFN(String horarioFN) {
        this.horarioFN = horarioFN;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public void setMaxPart(String maxPart) {
        this.maxPart = maxPart;
    }

    public void setMinPart(String minPart) {
        this.minPart = minPart;
    }

    public void setImagemUri(String imagemUri) {
        this.imagemUri = imagemUri;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getImagemUri() {
        return imagemUri != null ? imagemUri : "";
    }
}