package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.daos.MateriaisDao;
import com.live.adsfatene.biblioteca_publica.views.materiais.ListaView;
import java.util.List;

public final class MateriaisController {

    private final AplicacaoController aplicacaoController;
    private final MateriaisDao materiaisDao;
    private final ListaView listaPesquisaView;

    public MateriaisController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        materiaisDao = new MateriaisDao(aplicacaoController.getConexao());
        listaPesquisaView = new ListaView(this);
    }

    public void iniciar() {
        aplicacaoController.mudarPara(listaPesquisaView, " - Materiais");
        filtrar(new Material());
    }

    public void filtrar(Material material) {
        List<Material> materiais = materiaisDao.pesquisarPorTodosOsDadosNaoNulos(material);
        listaPesquisaView.atualizar(materiais);
    }

    public void iniciarFiltroView() {
        List<Material> materiais = materiaisDao.pesquisarPorTodosOsDadosNaoNulos(new Material());
        listaPesquisaView.getFiltroView().atualizar(materiais);
    }

    public void mostrarMaterialPeloSeuCodigoUnico(Integer codigo) {
        Material material = materiaisDao.buscarPeloCodigo(codigo);
    }

    public void atualizarDadosDoMaterial(Material material) {
        Boolean sucesso = materiaisDao.atualizarPorTodosOsDados(material);
    }

    public void cadastrarNovoMaterial(List<Material> materiais) {
        Boolean sucesso = materiaisDao.cadastarNovos(materiais);
    }

    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }
}