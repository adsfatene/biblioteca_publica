package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.EstoqueDanificado;
import com.live.adsfatene.biblioteca_publica.models.daos.EmprestimosIrrecuperaveisDAO;
import com.live.adsfatene.biblioteca_publica.views.estoques_danificados.ListaView;
import java.util.List;

public final class EstoquesDanificadosController {

    private final AplicacaoController aplicacaoController;
    private final EmprestimosIrrecuperaveisDAO estoquesIrrecuperaveisDAO;
    private final ListaView listaView;

    public EstoquesDanificadosController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        estoquesIrrecuperaveisDAO = new EmprestimosIrrecuperaveisDAO(aplicacaoController.getConexao());
        listaView = new ListaView(this);
    }

    public void iniciar() {
        pesquisarMateriaisIrrecuperaveisPorAlgumDeSeusDados(new EstoqueDanificado());
    }

    public void pesquisarMateriaisIrrecuperaveisPorAlgumDeSeusDados(EstoqueDanificado estoqueDanificado) {
        aplicacaoController.mudarPara(listaView, " - Estoques Danificados");
        List<EstoqueDanificado> estoquesIrrecuperaveis = estoquesIrrecuperaveisDAO.pesquisarPorTodosOsDadosNaoNulos(estoqueDanificado);
    }

    public void cadastrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void filtrar(EstoqueDanificado estoqueDanificado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editar(EstoqueDanificado estoqueDanificado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void exibir(EstoqueDanificado estoqueDanificado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }

    public void excluir(Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salvar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}