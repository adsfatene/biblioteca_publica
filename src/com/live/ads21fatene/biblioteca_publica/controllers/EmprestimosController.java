package com.live.ads21fatene.biblioteca_publica.controllers;

import com.live.ads21fatene.biblioteca_publica.models.Emprestimo;
import com.live.ads21fatene.biblioteca_publica.models.daos.EmprestimosDAO;
import com.live.ads21fatene.biblioteca_publica.views.emprestimos.PesquisaView;
import java.util.List;

public final class EmprestimosController {

    private final AplicacaoController aplicacaoController;
    private final EmprestimosDAO emprestimosDAO;

    private final PesquisaView pesquisaView;

    public EmprestimosController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        emprestimosDAO = new EmprestimosDAO(aplicacaoController.getConexao());
        pesquisaView = new PesquisaView(this);
    }

    public void iniciar(){
        pesquisarCadastroDeEmprestimosPorAlgumDeSeusDados(new Emprestimo());
    }

    public void pesquisarCadastroDeEmprestimosPorAlgumDeSeusDados(Emprestimo emprestimo) {
        aplicacaoController.mudarPara(pesquisaView, " - Pesquisa - Emprestimos");
        List<Emprestimo> emprestimos = emprestimosDAO.pesquisarPorTodosOsDadosNaoNulos(emprestimo);
    }

    public void mostrarEmprestimoPeloSeuCodigoUnico(Integer codigo) {
        Emprestimo emprestimo = emprestimosDAO.buscarPeloCodigo(codigo);
    }

    public void atualizarDadosDeDevolucaoDoEmprestimo(Emprestimo emprestimo) {
        Boolean sucesso = emprestimosDAO.atualizarDadosDeDevolucao(emprestimo);
    }

    /*
     * quando for formato digital deve copiar o arquivo da estrutura de
     * organização padrão da aplicação para alguma mídia salvando no 
     * padrão “titulo do material underline nome da editora ponto nome do 
     * formato” ex: xyz_zyx.pdf, quando for formato físico deve mostrar 
     * a informação exata na biblioteca).  
     */
    public void cadastrarNovoEmprestimo(Emprestimo emprestimo) {
        Boolean sucesso = emprestimosDAO.cadastarNovo(emprestimo);
    }
}