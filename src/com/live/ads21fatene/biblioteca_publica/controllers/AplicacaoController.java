package com.live.ads21fatene.biblioteca_publica.controllers;


import com.live.ads21fatene.biblioteca_publica.models.daos.Conexao;
import com.live.ads21fatene.biblioteca_publica.models.daos.ConexaoDesenvolvimento;
import com.live.ads21fatene.biblioteca_publica.views.AplicacaoView;
import java.awt.Container;
import javax.swing.JFrame;

public final class AplicacaoController implements Runnable {

    private final AplicacaoView aplicacaoView;
    private final Conexao conexao;

    private final Container inicioView;

    private final MateriaisController materiaisController;
    private final EstoquesController estoquesController;
    private final EmprestimosIrrecuperaveisController emprestimosIrrecuperaveisController;
    private final CidadaosController cidadaosController;
    private final EmprestimosController emprestimosController;

    public AplicacaoController() {
        aplicacaoView = new AplicacaoView(this);
        inicioView = aplicacaoView.getContentPane();

        conexao = new ConexaoDesenvolvimento();
        
        materiaisController = new MateriaisController(this);
        estoquesController = new EstoquesController(this);
        emprestimosIrrecuperaveisController = new EmprestimosIrrecuperaveisController(this);
        cidadaosController = new CidadaosController(this);
        emprestimosController = new EmprestimosController(this);
    }

    public void iniciar() {
        mudarPara(inicioView, "");
    }

    public void mudarPara(Container containerView, String titulo) {
        aplicacaoView.getContentPane().setVisible(false);
        aplicacaoView.setContentPane(containerView);
        containerView.setVisible(true);
        aplicacaoView.setTitle("Biblioteca Pública" + titulo);
    }

    public Conexao getConexao() {
        return conexao;
    }
   
    public MateriaisController getMateriaisController() {
        return materiaisController;
    }

    public EstoquesController getEstoquesController() {
        return estoquesController;
    }

    public EmprestimosIrrecuperaveisController getEmprestimosIrrecuperaveisController() {
        return emprestimosIrrecuperaveisController;
    }

    public CidadaosController getCidadaosController() {
        return cidadaosController;
    }

    public EmprestimosController getEmprestimosController() {
        return emprestimosController;
    }

    public AplicacaoView getAplicacaoView() {
        return aplicacaoView;
    }

    @Override
    public void run() {
        iniciar();
        aplicacaoView.setVisible(true);
        aplicacaoView.setExtendedState(JFrame.MAXIMIZED_BOTH);
        aplicacaoView.setMinimumSize(aplicacaoView.getSize());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new AplicacaoController());
    }
}