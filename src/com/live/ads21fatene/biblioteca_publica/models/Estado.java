package com.live.ads21fatene.biblioteca_publica.models;

public class Estado {

    private Integer codigo;
    private String nome;
    private String uf;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
