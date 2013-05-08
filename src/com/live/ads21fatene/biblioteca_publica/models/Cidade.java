package com.live.ads21fatene.biblioteca_publica.models;

public class Cidade {

    private Integer codigo;
    private String nome;
    private Estado estado;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}