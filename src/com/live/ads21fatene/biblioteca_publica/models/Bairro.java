package com.live.ads21fatene.biblioteca_publica.models;

public class Bairro {

    private Integer codigo;
    private String nome;
    private Cidade cidade;    

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
