package com.live.adsfatene.biblioteca_publica.models.util;

import com.live.adsfatene.biblioteca_publica.models.AnoPublicacao;
import com.live.adsfatene.biblioteca_publica.models.Autor;
import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Edicao;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Publico;
import java.util.LinkedList;
import java.util.List;

public class EmprestimoComboBox {

    private final List<Emprestimo> emprestimos;
    private final List<Cidadao> cidadaos;
    private final List<Estoque> estoques;

    public EmprestimoComboBox() {
        emprestimos = new LinkedList<>();
        cidadaos = new LinkedList<>();
        estoques = new LinkedList<>();
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Cidadao> getCidadaos() {
        return cidadaos;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }
}