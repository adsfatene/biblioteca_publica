package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.daos.EstoquesDAO;
import com.live.adsfatene.biblioteca_publica.models.util.EstoqueComboBox;
import com.live.adsfatene.biblioteca_publica.views.estoques.ListaView;
import java.util.List;
import javax.swing.JOptionPane;

public final class EstoquesController {

    private final AplicacaoController aplicacaoController;
    private final EstoquesDAO estoquesDAO;
    private final ListaView listaView;

    public EstoquesController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        estoquesDAO = new EstoquesDAO(aplicacaoController.getConexao());
        listaView = new ListaView(this);
    }

    public void iniciar() {
        aplicacaoController.mudarPara(listaView, " - Estoques");
        filtrar(new Estoque());
    }

    public void filtrar(Estoque estoque) {
        List<Estoque> estoquesTable = estoquesDAO.pesquisarPorTodosOsDadosNaoNulos(estoque);
        EstoqueComboBox estoqueComboBox = estoquesDAO.pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormatoStatu(aplicacaoController.getMateriaisController().getMateriaisDao());
        listaView.atualizar(estoquesTable, estoqueComboBox);
        listaView.getFiltroView().atualizar();
        listaView.getFiltroView().setVisible(listaView.getjToggleButtonFiltro().isSelected());
    }

    public void editar(Estoque estoque) {
        listaView.getEdicaoView().atualizar(estoque);
        listaView.getEdicaoView().setVisible(listaView.getjToggleButtonEdicao().isSelected());
    }

    public void atualizar(Estoque estoque) {
        if (estoquesDAO.atualizarLocalLogicoFisico(estoque)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "atualizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            editar(estoque);
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cadastrar() {
        aplicacaoController.getMateriaisController().iniciar();
        listaView.getCadastroView().setVisible(listaView.getjToggleButtonCadastro().isSelected());
    }

    public void estocar(List<Estoque> estoques) {
        if (estoquesDAO.estocarNovos(estoques)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "movido com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha na movimentação", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }

    public void excluir(Integer codigo) {
        if (estoquesDAO.removerPeloCodigo(codigo)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "removido com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            listaView.getExibicaoView().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha no remoção", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exibir(Estoque estoque) {
        listaView.getExibicaoView().atualizar(estoque);
        listaView.getExibicaoView().setVisible(true);
    }

    public ListaView getListaView() {
        return listaView;
    }
}