package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.daos.CidadaosDao;
import com.live.adsfatene.biblioteca_publica.models.util.CidadaoComboBox;
import com.live.adsfatene.biblioteca_publica.views.cidadaos.ListaView;
import java.util.List;
import javax.swing.JOptionPane;

public final class CidadaosController {

    private final AplicacaoController aplicacaoController;
    private final CidadaosDao cidadaosDao;
    private final ListaView listaView;

    public CidadaosController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        cidadaosDao = new CidadaosDao(aplicacaoController.getConexao());
        listaView = new ListaView(this);
    }

    public void iniciar() {
        aplicacaoController.mudarPara(listaView, " - Cidadãos");
        filtrar(new Cidadao());
    }

    public void filtrar(Cidadao cidadao) {
        List<Cidadao> cidadaosTable = cidadaosDao.pesquisarPorTodosOsDadosNaoNulos(cidadao);
        CidadaoComboBox cidadaoComboBox = cidadaosDao.pesquisarTodosLogradouroEstadoBairroCidadeTelefoneCelularDDD();
        listaView.atualizar(cidadaosTable, cidadaoComboBox);
        listaView.getFiltroView().atualizar();
        listaView.getFiltroView().setVisible(listaView.getjToggleButtonFiltro().isSelected());
    }

    public void editar(Cidadao cidadao) {
        listaView.getEdicaoView().atualizar(cidadao);
        listaView.getEdicaoView().setVisible(listaView.getjToggleButtonEdicao().isSelected());
    }

    public void atualizar(Cidadao cidadao) {
        if (cidadaosDao.atualizarPorTodosOsDados(cidadao)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "atualizado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            editar(cidadao);
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha na atualização", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cadastrar() {
        listaView.getCadastroView().atualizar();
        listaView.getCadastroView().setVisible(listaView.getjToggleButtonCadastro().isSelected());
    }

    public void salvar(Cidadao cidadao) {
        if (cidadaosDao.cadastarNovo(cidadao)) {
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
        if (cidadaosDao.excluirPeloCodigo(codigo)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "excluido com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            listaView.getExibicaoView().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha no exclusao", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exibir(Cidadao cidadao) {
        listaView.getExibicaoView().atualizar(cidadao);
        listaView.getExibicaoView().setVisible(true);
    }

    public CidadaosDao getCidadaosDao() {
        return cidadaosDao;
    }

    public ListaView getListaView() {
        return listaView;
    }
}