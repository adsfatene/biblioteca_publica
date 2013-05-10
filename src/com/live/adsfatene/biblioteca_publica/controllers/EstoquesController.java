package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.EmprestimoIrrecuperavel;
import com.live.adsfatene.biblioteca_publica.models.daos.EstoquesDAO;
import com.live.adsfatene.biblioteca_publica.views.estoques.PesquisaView;
import java.util.List;

public final class EstoquesController {

    private final AplicacaoController aplicacaoController;
    private final EstoquesDAO estoquesDAO;
    private final PesquisaView pesquisaView;

    public EstoquesController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        estoquesDAO = new EstoquesDAO(aplicacaoController.getConexao());
        pesquisaView = new PesquisaView(this);
    }

    public void iniciar(){
        pesquisarEstoquesDeMateriaisPorAlgumDeSeusDados(new Estoque());
    }
    
    public void pesquisarEstoquesDeMateriaisPorAlgumDeSeusDados(Estoque estoque) {
        aplicacaoController.mudarPara(pesquisaView, " - Pesquisa - Estoques");
        List<Estoque> estoques = estoquesDAO.pesquisarPorTodosOsDadosNaoNulos(estoque);
    }

    /* 
     * quando for formato digital deve receber o caminho do arquivo, 
     * mover para uma estrutura de organização padrão da aplicação 
     * e salvar no padrão “codigo do material ponto nome do formato” ex: 1.pdf, 
     * quando formato físico deve receber a informação exata da localização 
     * na biblioteca)
     */
    public void estocarDeterminadoVolumeDeMaterial(Estoque estoque) {
        Boolean sucesso = estoquesDAO.estocarNovo(estoque);
    }

    public void aumentarVolumeEstocadoDeUmDeterminadoMaterial(Estoque estoque, Integer volumeAdicional) {
        Boolean sucesso = estoquesDAO.aumentar(estoque, volumeAdicional);
    }

    public void moverDeterminadoVolumeDeMaterialEstocadoParaEstoquesIrrecuperáveis(EmprestimoIrrecuperavel estoqueIrrecuperavel) {
        Boolean sucesso = estoquesDAO.moverVolumeDeMaterialEstocadoParaEstoquesIrrecuperavel(estoqueIrrecuperavel);
    }
}