package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.daos.CidadaosDAO;
import com.live.adsfatene.biblioteca_publica.views.cidadaos.PesquisaView;
import java.util.List;

public final class CidadaosController {

    private final AplicacaoController aplicacaoController;
    private final CidadaosDAO cidadaosDAO;

    private final PesquisaView pesquisaView;

    public CidadaosController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        cidadaosDAO = new CidadaosDAO(aplicacaoController.getConexao());
    
        pesquisaView = new PesquisaView(this);
    }

     public void iniciar(){
         pesquisarCadastroDeCidadaosPorAlgumDeSeusDados(new Cidadao());
     }

    public void pesquisarCadastroDeCidadaosPorAlgumDeSeusDados(Cidadao cidadao) {
        aplicacaoController.mudarPara(pesquisaView, " - Pesquisa - Cidadãos");
        List<Cidadao> cidadaos = cidadaosDAO.pesquisarPorTodosOsDadosNaoNulos(cidadao);
    }

    public void mostrarCidadaosPeloSeuCodigoUnico(Integer codigo) {
        Cidadao cidadao = cidadaosDAO.buscarPeloCodigo(codigo);
    }

    public void atualizarDadosDoCidadao(Cidadao cidadao) {
        Boolean sucesso = cidadaosDAO.atualizarPorTodosOsDados(cidadao);
    }

    public void cadastrarNovoCidadao(Cidadao cidadao) {
        Boolean sucesso = cidadaosDAO.cadastarNovo(cidadao);
    }
}