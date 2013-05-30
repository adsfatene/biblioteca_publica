package com.live.adsfatene.biblioteca_publica.controllers;

import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.daos.EmprestimosDAO;
import com.live.adsfatene.biblioteca_publica.models.util.EmprestimoComboBox;
import com.live.adsfatene.biblioteca_publica.views.emprestimos.ListaView;
import java.util.List;
import javax.swing.JOptionPane;

public final class EmprestimosController {

    private final AplicacaoController aplicacaoController;
    private final EmprestimosDAO emprestimosDAO;
    private final ListaView listaView;

    public EmprestimosController(AplicacaoController aplicacaoController) {
        this.aplicacaoController = aplicacaoController;
        emprestimosDAO = new EmprestimosDAO(aplicacaoController.getConexao());
        listaView = new ListaView(this);
    }

    public void iniciar() {
        aplicacaoController.mudarPara(listaView, " - Emprestimos");
        filtrar(new Emprestimo());
    }

    public void filtrar(Emprestimo emprestimo) {
        List<Emprestimo> emprestimosTable = emprestimosDAO.pesquisarPorTodosOsDadosNaoNulos(emprestimo);
        EmprestimoComboBox emprestimoComboBox = emprestimosDAO.pesquisarTodosCodigoCidadaoEstoque();
        listaView.atualizar(emprestimosTable, emprestimoComboBox);
        listaView.getFiltroView().atualizar();
        listaView.getFiltroView().setVisible(listaView.getjToggleButtonFiltro().isSelected());
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

    public AplicacaoController getAplicacaoController() {
        return aplicacaoController;
    }

    public void alterarCidadao(boolean aFlag) {
        listaView.getAlterarCidadaoView().setVisible(aFlag);
        if (aFlag) {
            aplicacaoController.getCidadaosController().iniciar();
        } else {
            aplicacaoController.mudarPara(aplicacaoController.getEmprestimosController().getListaView(), " - Emprestimos");
        }
    }

    public void adicionarEstoque(boolean aFlag) {
        listaView.getAdicionarEstoqueView().setVisible(aFlag);
        if (aFlag) {
            aplicacaoController.getEstoquesController().iniciar();
        } else {
            aplicacaoController.mudarPara(aplicacaoController.getEmprestimosController().getListaView(), " - Emprestimos");
        }
    }

    public void salvar(Emprestimo emprestimo) {
        if (emprestimosDAO.cadastarNovo(emprestimo)) {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "cadastrado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            iniciar();
            cadastrar();
        } else {
            JOptionPane.showMessageDialog(listaView.getEdicaoView(), "falha no cadastro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ListaView getListaView() {
        return listaView;
    }

    public void concluir(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editar(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editar(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void exibir(Emprestimo emprestimo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cadastrar() {
        listaView.getCadastroView().atualizar();
        listaView.getCadastroView().setVisible(listaView.getjToggleButtonCadastro().isSelected());
    }
}