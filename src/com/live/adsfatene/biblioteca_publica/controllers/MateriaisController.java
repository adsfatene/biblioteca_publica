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

    public void atualizar(Material material) {
        if (materiaisDao.atualizarPorTodosOsDados(material)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "atualizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            editar(material);
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cadastrar() {
        listaView.getCadastroView().atualizar();
        listaView.getCadastroView().setVisible(listaView.getjToggleButtonCadastro().isSelected());
    }

    public void salvar(List<Material> materiais) {
        if (materiaisDao.cadastarNovos(materiais)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "cadastrado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            cadastrar();
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha no cadastro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }

    public void excluir(Integer codigo) {
        if (materiaisDao.excluirPeloCodigo(codigo)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "excluido com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            listaView.getExibicaoView().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha no exclusao", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exibir(Material material) {
        listaView.getExibicaoView().atualizar(material);
        listaView.getExibicaoView().setVisible(true);
    }

    public MateriaisDao getMateriaisDao() {
        return materiaisDao;
    }

    public ListaView getListaView() {
        return listaView;
    }
}