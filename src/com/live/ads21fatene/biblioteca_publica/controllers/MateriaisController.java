package com.live.ads21fatene.biblioteca_publica.controllers;

import com.live.ads21fatene.biblioteca_publica.models.Material;
import com.live.ads21fatene.biblioteca_publica.models.daos.MateriaisDAO;
import com.live.ads21fatene.biblioteca_publica.views.materiais.ListaPesquisaView;
import java.util.List;

public final class MateriaisController {

    private final AplicacaoController aplicacaoController;
    private final MateriaisDAO materiaisDAO;
    private final ListaPesquisaView listaPesquisaView;

    public MateriaisController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        materiaisDAO = new MateriaisDAO(aplicacaoController.getConexao());
        listaPesquisaView = new ListaPesquisaView(this);
    }

    public void iniciar() {
        pesquisarCadastroDeMateriaisPorAlgumDeSeusDados(new Material());
    }

    public void pesquisarCadastroDeMateriaisPorAlgumDeSeusDados(Material material) {
        aplicacaoController.mudarPara(listaPesquisaView, " - Lista de Pesquisa - Materiais");
        List<Material> materiais = materiaisDAO.pesquisarPorTodosOsDadosNaoNulos(material);
        listaPesquisaView.atualizar(materiais);
    }

    public void mostrarMaterialPeloSeuCodigoUnico(Integer codigo) {
        Material material = materiaisDAO.buscarPeloCodigo(codigo);
    }

    public void atualizarDadosDoMaterial(Material material) {
        Boolean sucesso = materiaisDAO.atualizarPorTodosOsDados(material);
    }

    public void cadastrarNovoMaterial(List<Material> materiais) {
        Boolean sucesso = materiaisDAO.cadastarNovo(materiais);
    }

    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }

}