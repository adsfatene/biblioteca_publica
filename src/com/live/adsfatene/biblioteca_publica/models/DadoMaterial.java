package com.live.adsfatene.biblioteca_publica.models;

public class DadoMaterial {

    private Integer codigo;
    private String titulo;
    private String descricao;
    private Edicao edicao;
    private AnoPublicacao anoPublicacao;
    private Autor autor;
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

    public Edicao getEdicao() {
        return edicao;
    }

    public Editora getEditora() {
        return editora;
    }

    public AnoPublicacao getAnoPublicacao() {
        return anoPublicacao;
    }

    public Autor getAutor() {
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

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setAnoPublicacao(AnoPublicacao anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }

    boolean ehIgual(DadoMaterial dadoMaterial) {
        return titulo.equals(dadoMaterial.titulo)
                && descricao.equals(dadoMaterial.descricao)
                && edicao.ehIgual(dadoMaterial.edicao)
                && anoPublicacao.ehIgual(dadoMaterial.anoPublicacao)
                && autor.equals(dadoMaterial.autor)
                && editora.ehIgual(dadoMaterial.editora)
                && categoria.ehIgual(dadoMaterial.categoria)
                && publico.ehIgual(dadoMaterial.publico);
    }
}