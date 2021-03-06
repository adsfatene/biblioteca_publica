package com.live.adsfatene.biblioteca_publica.views.emprestimos;

import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.EmprestimoEstoque;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import java.util.Calendar;
import java.util.LinkedList;

public class FiltroView extends javax.swing.JDialog {

    private final ListaView listaView;

    FiltroView(ListaView listaView, boolean modal) {
        super(listaView.getEmprestimosController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            jButtonLimparActionPerformed(null);
            if (!isVisible()) {
                setLocationRelativeTo(listaView.getEmprestimosController().getAplicacaoController().getAplicacaoView());
            }
        }
        listaView.getjToggleButtonFiltro().setSelected(flag);
        super.setVisible(flag);
    }

    public void atualizar() {
        jComboBoxCodigo.removeAllItems();
        jComboBoxCidadao.removeAllItems();
        jComboBoxEstoque.removeAllItems();

        jComboBoxCodigo.addItem("Todos");
        for (Emprestimo emprestimo : listaView.getEmprestimoComboBox().getEmprestimos()) {
            jComboBoxCodigo.addItem(emprestimo);
        }

        jComboBoxCidadao.addItem("Todos");
        for (Cidadao cidadao : listaView.getEmprestimoComboBox().getCidadaos()) {
            jComboBoxCidadao.addItem(cidadao);
        }

        jComboBoxEstoque.addItem("Todos");
        for (Estoque estoque : listaView.getEmprestimoComboBox().getEstoques()) {
            jComboBoxEstoque.addItem(estoque);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCidadao = new javax.swing.JLabel();
        jComboBoxCodigo = new javax.swing.JComboBox();
        jLabelEstoque = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jCheckBoxAberto = new javax.swing.JCheckBox();
        jCheckBoxConcluido = new javax.swing.JCheckBox();
        jComboBoxEstoque = new javax.swing.JComboBox();
        jComboBoxCidadao = new javax.swing.JComboBox();

        setTitle("Filtro");
        setResizable(false);

        jLabelCidadao.setText("Cidadão");

        jLabelEstoque.setText("Estoque");

        jLabelCodigo.setText("Codigo");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jCheckBoxAberto.setText("Aberto");
        jCheckBoxAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAbertoActionPerformed(evt);
            }
        });

        jCheckBoxConcluido.setText("Concluido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCidadao)
                    .addComponent(jLabelCodigo)
                    .addComponent(jLabelEstoque))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jComboBoxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxCidadao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxAberto)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxConcluido)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jComboBoxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidadao)
                    .addComponent(jComboBoxCidadao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstoque)
                    .addComponent(jComboBoxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jCheckBoxAberto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxConcluido)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPesquisar)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonLimpar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jComboBoxCodigo.setSelectedIndex(0);
        jComboBoxCidadao.setSelectedIndex(0);
        jComboBoxEstoque.setSelectedIndex(0);
        jCheckBoxAberto.setSelected(true);
        jCheckBoxConcluido.setSelected(true);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        Emprestimo emprestimo = new Emprestimo();

        if (jComboBoxCodigo.getSelectedIndex() > 0) {
            emprestimo.setCodigo(((Emprestimo) jComboBoxCodigo.getSelectedItem()).getCodigo());
        }

        if (jComboBoxCidadao.getSelectedIndex() > 0) {
            emprestimo.setCidadao((Cidadao) jComboBoxCidadao.getSelectedItem());
        }

        if (jComboBoxEstoque.getSelectedIndex() > 0) {
            EmprestimoEstoque emprestimoEstoque = new EmprestimoEstoque();
            emprestimoEstoque.setEstoque((Estoque) jComboBoxEstoque.getSelectedItem());
            emprestimo.setEmprestimosEstoques(new LinkedList<EmprestimoEstoque>());
            emprestimo.getEmprestimosEstoques().add(emprestimoEstoque);
        }
        if(jCheckBoxAberto.isSelected()){
            emprestimo.setDataHoraEmprestato(Calendar.getInstance());
        }
        if(jCheckBoxConcluido.isSelected()){
            emprestimo.setDataHoraDevolucaoEfetiva(Calendar.getInstance());
        }

        listaView.getEmprestimosController().filtrar(emprestimo);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jCheckBoxAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAbertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAbertoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JCheckBox jCheckBoxAberto;
    private javax.swing.JCheckBox jCheckBoxConcluido;
    private javax.swing.JComboBox jComboBoxCidadao;
    private javax.swing.JComboBox jComboBoxCodigo;
    private javax.swing.JComboBox jComboBoxEstoque;
    private javax.swing.JLabel jLabelCidadao;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelEstoque;
    // End of variables declaration//GEN-END:variables
}
