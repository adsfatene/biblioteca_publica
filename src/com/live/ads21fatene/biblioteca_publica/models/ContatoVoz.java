package com.live.ads21fatene.biblioteca_publica.models;

public abstract class ContatoVoz {

    private Integer codigo;
    private Cidadao cidadao;
    private DDD ddd;
    private Integer numero;
    private String tipo;

    public Integer getCodigo() {
        return codigo;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public DDD getDdd() {
        return ddd;
    }

    public Integer getNumero() {
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

    public void setDdd(DDD ddd) {
        this.ddd = ddd;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
