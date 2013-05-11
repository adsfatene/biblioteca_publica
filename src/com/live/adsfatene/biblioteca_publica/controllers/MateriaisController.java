package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.daos.MateriaisDao;
import com.live.adsfatene.biblioteca_publica.models.util.MaterialComboBox;
import com.live.adsfatene.biblioteca_publica.views.materiais.ListaView;
import java.util.List;
import javax.swing.JOptionPane;

public final class MateriaisController {

    private final AplicacaoController aplicacaoController;
    private final MateriaisDao materiaisDao;
    private final ListaView listaView;

    public MateriaisController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        materiaisDao = new MateriaisDao(aplicacaoController.getConexao());
        listaView = new ListaView(this);
    }

    public void iniciar() {
        aplicacaoController.mudarPara(listaView, " - Materiais");
        filtrar(new Material());
    }

    public void filtrar(Material material) {
        List<Material> materiaisTable = materiaisDao.pesquisarPorTodosOsDadosNaoNulos(material);
        MaterialComboBox materialComboBox = materiaisDao.pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormato();
        listaView.atualizar(materiaisTable, materialComboBox);
        listaView.getFiltroView().atualizar();
        listaView.getFiltroView().setVisible(listaView.getjToggleButtonFiltro().isSelected());
    }

    public void editar(Material material) {
        listaView.getEdicaoView().atualizar(material);
        listaView.getEdicaoView().setVisible(listaView.getjToggleButtonEdicao().isSelected());
    }

    public void mostrarMaterialPeloSeuCodigoUnico(Integer codigo) {
        Material material = materiaisDao.buscarPeloCodigo(codigo);
    }

    public void atualizar(Material material) {
        if (materiaisDao.atualizarPorTodosOsDados(material)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "atualizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            editar(material);
        } else {
           JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cadastrarNovoMaterial(List<Material> materiais) {
        Boolean sucesso = materiaisDao.cadastarNovos(materiais);
    }

    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }
}