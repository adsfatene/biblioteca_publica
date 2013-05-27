package com.live.adsfatene.biblioteca_publica.models;

public abstract class ContatoVoz {

    private Integer codigo;
    private Cidadao cidadao;
    private DDD ddd;
    private String numero;
    private String tipo;

    public Integer getCodigo() {
        return codigo;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public DDD getDDD() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public void setDDD(DDD ddd) {
        this.ddd = ddd;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
