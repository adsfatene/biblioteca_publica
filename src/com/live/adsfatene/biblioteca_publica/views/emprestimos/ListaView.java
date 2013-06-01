package com.live.adsfatene.biblioteca_publica.views.emprestimos;

import com.live.adsfatene.biblioteca_publica.controllers.EmprestimosController;
import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.util.EmprestimoComboBox;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

public class ListaView extends javax.swing.JPanel {

    private final EmprestimosController emprestimosController;
    private final List<Emprestimo> emprestimos;
    private final DefaultTableModel dtm;
    private final AdicionarEstoqueView adicionarEstoqueView;
    private final CadastroView cadastroView;
    private final FiltroView filtroView;
    private final EdicaoView edicaoView;
    private EmprestimoComboBox emprestimoComboBox;
    private final ExibicaoView exibicaoView;
    private final SimpleDateFormat sdf;
    private final AlterarCidadaoView alterarCidadaoView;

    public ListaView(EmprestimosController emprestimosController) {
        initComponents();
        this.emprestimosController = emprestimosController;
        dtm = (DefaultTableModel) jTableLista.getModel();
        cadastroView = new CadastroView(this, false);
        filtroView = new FiltroView(this, false);
        edicaoView = new EdicaoView(this, false);
        exibicaoView = new ExibicaoView(this, false);
        sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        adicionarEstoqueView = new AdicionarEstoqueView(emprestimosController.getAplicacaoController().getEstoquesController().getListaView(), false);
        alterarCidadaoView = new AlterarCidadaoView(emprestimosController.getAplicacaoController().getCidadaosController().getListaView(), false);
        emprestimos = new LinkedList<>();
    }

    @Override
    public void setVisible(boolean aFlag) {
        if (!aFlag) {
            filtroView.setVisible(aFlag);
            edicaoView.setVisible(aFlag);
            exibicaoView.setVisible(aFlag);
        }
        super.setVisible(aFlag);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBarAcoes = new javax.swing.JToolBar();
        jToggleButtonFiltro = new javax.swing.JToggleButton();
        jToggleButtonEdicao = new javax.swing.JToggleButton();
        jToggleButtonCadastro = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jToolBarAcoes.setRollover(true);

        jToggleButtonFiltro.setText("Filtro");
        jToggleButtonFiltro.setFocusable(false);
        jToggleButtonFiltro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonFiltro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonFiltroActionPerformed(evt);
            }
        });
        jToolBarAcoes.add(jToggleButtonFiltro);

        jToggleButtonEdicao.setText("Edição");
        jToggleButtonEdicao.setFocusable(false);
        jToggleButtonEdicao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonEdicao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEdicaoActionPerformed(evt);
            }
        });
        jToolBarAcoes.add(jToggleButtonEdicao);

        jToggleButtonCadastro.setText("Cadastro");
        jToggleButtonCadastro.setFocusable(false);
        jToggleButtonCadastro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonCadastro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCadastroActionPerformed(evt);
            }
        });
        jToolBarAcoes.add(jToggleButtonCadastro);

        add(jToolBarAcoes, java.awt.BorderLayout.PAGE_START);

        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emprestimo", "Codigo", "Cidadao", "Quantidade Estoques Emprestado", "Data/Hora Emprestado", "Data/Hora Devolucao Prevista", "Data/Hora Devolucao Efetiva", "Aberto/Concluido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableListaMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableListaMousePressed(evt);
            }
        });
        jTableLista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableListaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLista);
        jTableLista.getColumnModel().getColumn(0).setMinWidth(0);
        jTableLista.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableLista.getColumnModel().getColumn(0).setMaxWidth(0);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonFiltroActionPerformed
        emprestimosController.filtrar(new Emprestimo());
    }//GEN-LAST:event_jToggleButtonFiltroActionPerformed

    private void jTableListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMousePressed
    }//GEN-LAST:event_jTableListaMousePressed

    private void jTableListaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableListaKeyPressed
    }//GEN-LAST:event_jTableListaKeyPressed

    private void jToggleButtonEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEdicaoActionPerformed
        if (jTableLista.getSelectedRowCount() > 0) {
            Emprestimo emprestimo = (Emprestimo) jTableLista.getValueAt(jTableLista.getSelectedRow(), 0);
            if (emprestimo.getDataHoraDevolucaoEfetiva() == null) {
                emprestimosController.editar(emprestimo);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um Emprestimo Aberto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Emprestimo.", "Erro", JOptionPane.ERROR_MESSAGE);
            jToggleButtonEdicao.setSelected(false);
        }
    }//GEN-LAST:event_jToggleButtonEdicaoActionPerformed

    private void jTableListaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseEntered
    }//GEN-LAST:event_jTableListaMouseEntered

    private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            Emprestimo emprestimo = (Emprestimo) jTableLista.getValueAt(jTableLista.getSelectedRow(), 0);
            if (jToggleButtonEdicao.isSelected()) {
                emprestimosController.editar(emprestimo);
            } else {
                emprestimosController.exibir(emprestimo);
            }
        }
    }//GEN-LAST:event_jTableListaMouseClicked

    private void jToggleButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCadastroActionPerformed
        emprestimosController.cadastrar();
    }//GEN-LAST:event_jToggleButtonCadastroActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    private javax.swing.JToggleButton jToggleButtonCadastro;
    private javax.swing.JToggleButton jToggleButtonEdicao;
    private javax.swing.JToggleButton jToggleButtonFiltro;
    private javax.swing.JToolBar jToolBarAcoes;
    // End of variables declaration//GEN-END:variables

    public void atualizar(List<Emprestimo> emprestimos, EmprestimoComboBox emprestimosComboBox) {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        this.emprestimos.clear();

        this.emprestimos.addAll(emprestimos);
        this.emprestimoComboBox = emprestimosComboBox;

        for (Emprestimo emprestimo : this.emprestimos) {
            dtm.addRow(new Object[dtm.getColumnCount()]);
            int coluna = 0;
            dtm.setValueAt(emprestimo, dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(emprestimo.getCodigo(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(emprestimo.getCidadao(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(emprestimo.getEmprestimosEstoques().size(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(sdf.format(emprestimo.getDataHoraEmprestato().getTimeInMillis()), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(sdf.format(emprestimo.getDataHoraDevolucaoPrevista().getTimeInMillis()), dtm.getRowCount() - 1, coluna++);
            String abertoConcluido = "Aberto";
            if (emprestimo.getDataHoraDevolucaoEfetiva() != null) {
                dtm.setValueAt(sdf.format(emprestimo.getDataHoraDevolucaoEfetiva().getTimeInMillis()), dtm.getRowCount() - 1, coluna);
                abertoConcluido = "Concluido";
            }
            coluna++;
            dtm.setValueAt(abertoConcluido, dtm.getRowCount() - 1, coluna);
        }
    }

    public EmprestimosController getEmprestimosController() {
        return emprestimosController;
    }

    public JToggleButton getjToggleButtonCadastro() {
        return jToggleButtonCadastro;
    }

    public JToggleButton getjToggleButtonFiltro() {
        return jToggleButtonFiltro;
    }

    public JToggleButton getjToggleButtonEdicao() {
        return jToggleButtonEdicao;
    }

    public FiltroView getFiltroView() {
        return filtroView;
    }

    public EdicaoView getEdicaoView() {
        return edicaoView;
    }

    public CadastroView getCadastroView() {
        return cadastroView;
    }

    public EmprestimoComboBox getEmprestimoComboBox() {
        return emprestimoComboBox;
    }

    public ExibicaoView getExibicaoView() {
        return exibicaoView;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public AdicionarEstoqueView getAdicionarEstoqueView() {
        return adicionarEstoqueView;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public AlterarCidadaoView getAlterarCidadaoView() {
        return alterarCidadaoView;
    }
}