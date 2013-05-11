package com.live.adsfatene.biblioteca_publica.models.util;

import com.live.adsfatene.biblioteca_publica.models.AnoPublicacao;
import com.live.adsfatene.biblioteca_publica.models.Autor;
import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.Edicao;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Publico;
import java.util.LinkedList;
import java.util.List;

public class MaterialComboBox {

    private final List<Edicao> edicoes;
    private final List<AnoPublicacao> anosPublicacoes;
    private final List<Autor> autores;
    private final List<Editora> editoras;
    private final List<Categoria> categorias;
    private final List<Publico> publicos;
    private final List<Formato> formatos;

    public MaterialComboBox() {
        edicoes = new LinkedList<>();
        anosPublicacoes = new LinkedList<>();
        autores = new LinkedList<>();
        editoras = new LinkedList<>();
        categorias = new LinkedList<>();
        publicos = new LinkedList<>();
        formatos = new LinkedList<>();
    }

    public List<Edicao> getEdicoes() {
        return edicoes;
    }

    public List<AnoPublicacao> getAnosPublicacoes() {
        return anosPublicacoes;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Editora> getEditoras() {
        return editoras;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Publico> getPublicos() {
        return publicos;
    }

    public List<Formato> getFormatos() {
        return formatos;
    }
}