package com.live.ads21fatene.biblioteca_publica.controllers;

import com.live.ads21fatene.biblioteca_publica.models.EmprestimoIrrecuperavel;
import com.live.ads21fatene.biblioteca_publica.models.daos.EmprestimosIrrecuperaveisDAO;
import com.live.ads21fatene.biblioteca_publica.views.emprestimos_irrecuperaveis.PesquisaView;
import java.util.List;

public final class EmprestimosIrrecuperaveisController {

    private final AplicacaoController aplicacaoController;
    private final EmprestimosIrrecuperaveisDAO estoquesIrrecuperaveisDAO;
  
    private final PesquisaView pesquisaView;
    
    public EmprestimosIrrecuperaveisController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        estoquesIrrecuperaveisDAO = new EmprestimosIrrecuperaveisDAO(aplicacaoController.getConexao());
        pesquisaView = new PesquisaView(this);
    }

    public void iniciar() {
        pesquisarMateriaisIrrecuperaveisPorAlgumDeSeusDados(new EmprestimoIrrecuperavel());
    }

    public void pesquisarMateriaisIrrecuperaveisPorAlgumDeSeusDados(EmprestimoIrrecuperavel materialIrrecuperavel) {
        aplicacaoController.mudarPara(pesquisaView, " - Pesquisa - Emprestimos Irrecuperáveis");
        List<EmprestimoIrrecuperavel> estoquesIrrecuperaveis = estoquesIrrecuperaveisDAO.pesquisarPorTodosOsDadosNaoNulos(materialIrrecuperavel);
    }

}