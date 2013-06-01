package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.EmprestimoEstoque;
import com.live.adsfatene.biblioteca_publica.models.daos.DanificadosDAO;
import com.live.adsfatene.biblioteca_publica.views.danificados.ListaView;
import java.util.List;
import javax.swing.JOptionPane;

public final class DanificadosController {


    private final AplicacaoController aplicacaoController;
    private final DanificadosDAO danificadosDAO;
    private final ListaView listaView;

    public DanificadosController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        danificadosDAO = new DanificadosDAO(aplicacaoController.getConexao());
        listaView = new ListaView(this);
    }

    public void iniciar() {
        aplicacaoController.mudarPara(listaView, " - Danificados");
        filtrar(new EmprestimoEstoque());
    }

    public void filtrar(EmprestimoEstoque emprestimoEstoque) {
        List<EmprestimoEstoque> emprestimosEstoquesTable = danificadosDAO.pesquisarPorTodosOsDadosNaoNulos(emprestimoEstoque);
        listaView.atualizar(emprestimosEstoquesTable);
        listaView.getFiltroView().atualizar();
        listaView.getFiltroView().setVisible(listaView.getjToggleButtonFiltro().isSelected());
    }


    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }


    public ListaView getListaView() {
        return listaView;
    }

    public void restaurar(EmprestimoEstoque emprestimoEstoque) {
        if (danificadosDAO.restaurar(emprestimoEstoque.getCodigo())) {
            JOptionPane.showMessageDialog(listaView, "restaurado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
        } else {
            JOptionPane.showMessageDialog(listaView, "falha na restauracao", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}