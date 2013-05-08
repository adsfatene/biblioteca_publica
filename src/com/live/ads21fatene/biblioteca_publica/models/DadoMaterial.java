package com.live.ads21fatene.biblioteca_publica.models;

public class DadoMaterial {

    private Integer codigo;
    private String titulo;
    private String descricao;
    private Integer edicao;
    private Integer anoPublicacao;
    private String autor;
    private Editora editora;
    private Categoria categoria;
    private Publico publico;

    public Integer getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public Editora getEditora() {
        return editora;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Publico getPublico() {
        return publico;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }
}