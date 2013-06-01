package com.live.adsfatene.biblioteca_publica.views.emprestimos;

import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.EmprestimoEstoque;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ExibicaoView extends javax.swing.JDialog {

    private final ListaView listaView;
    private final DefaultTableModel dtm;

    ExibicaoView(ListaView listaView, boolean modal) {
        super(listaView.getEmprestimosController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
        dtm = (DefaultTableModel) jTableEstoques.getModel();
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            setLocationRelativeTo(listaView.getEmprestimosController().getAplicacaoController().getAplicacaoView());
        }
        super.setVisible(flag);
    }

    public void atualizar(Emprestimo emprestimo) {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        jTextFieldCodigo.setText(emprestimo.getCodigo().toString());
        jTextFieldCidadao.setText(emprestimo.getCidadao().toString());
        jTextFieldlDataHoraEmprestado.setText(listaView.getSdf().format(emprestimo.getDataHoraEmprestato().getTime()));
        jTextFieldlDataHoraDevolucaoPrevista.setText(listaView.getSdf().format(emprestimo.getDataHoraDevolucaoPrevista().getTime()));

        if (emprestimo.getDataHoraDevolucaoEfetiva() != null) {
            jTextFieldlDataHoraDevolucaoEfetiva.setText(listaView.getSdf().format(emprestimo.getDataHoraDevolucaoEfetiva().getTime()));
        }

        for (EmprestimoEstoque emprestimoEstoque : emprestimo.getEmprestimosEstoques()) {
            Estoque estoque = emprestimoEstoque.getEstoque();
            dtm.addRow(new Object[dtm.getColumnCount()]);
            int coluna = 0;
            dtm.setValueAt(estoque, dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(estoque.getMaterial().getDadoMaterial().getTitulo(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(estoque.getMaterial().getFormato(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(estoque.getLocalLogicoFisico(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(emprestimoEstoque.getEstadoDevolucao(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(emprestimoEstoque.getMotivo(), dtm.getRowCount() - 1, coluna++);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldlDataHoraEmprestado = new javax.swing.JTextField();
        jLabelDataHoraDevolucaoPrevista = new javax.swing.JLabel();
        jLabelEstoques = new javax.swing.JLabel();
        jLabelDataHoraEmprestado = new javax.swing.JLabel();
        jTextFieldCidadao = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldlDataHoraDevolucaoEfetiva = new javax.swing.JTextField();
        jLabellDataHoraDevolucaoEfetiva = new javax.swing.JLabel();
        jLabelCidadao = new javax.swing.JLabel();
        jTextFieldlDataHoraDevolucaoPrevista = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEstoques = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setTitle("Exibicao");
        setResizable(false);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTextFieldlDataHoraEmprestado.setEditable(false);
        jTextFieldlDataHoraEmprestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldlDataHoraEmprestadoActionPerformed(evt);
            }
        });

        jLabelDataHoraDevolucaoPrevista.setText("Data/Hora Devolução Prevista");

        jLabelEstoques.setText("Estoques");

        jLabelDataHoraEmprestado.setText("Data/Hora Emprestado");

        jTextFieldCidadao.setEditable(false);

        jLabelCodigo.setText("Codigo");

        jTextFieldlDataHoraDevolucaoEfetiva.setEditable(false);
        jTextFieldlDataHoraDevolucaoEfetiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldlDataHoraDevolucaoEfetivaActionPerformed(evt);
            }
        });

        jLabellDataHoraDevolucaoEfetiva.setText("Data/Hora Devolução Efetiva");

        jLabelCidadao.setText("Cidadão");

        jTextFieldlDataHoraDevolucaoPrevista.setEditable(false);
        jTextFieldlDataHoraDevolucaoPrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldlDataHoraDevolucaoPrevistaActionPerformed(evt);
            }
        });

        jTextFieldCodigo.setEditable(false);

        jTableEstoques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Estoque", "Titulo", "Formato", "Localização", "Estado Devolução", "Motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableEstoques);
        jTableEstoques.getColumnModel().getColumn(0).setMinWidth(0);
        jTableEstoques.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableEstoques.getColumnModel().getColumn(0).setMaxWidth(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDataHoraEmprestado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldlDataHoraEmprestado, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDataHoraDevolucaoPrevista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(jTextFieldlDataHoraDevolucaoPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabellDataHoraDevolucaoEfetiva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldlDataHoraDevolucaoEfetiva, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEstoques, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCidadao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCidadao, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidadao)
                    .addComponent(jTextFieldCidadao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEstoques)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataHoraEmprestado)
                    .addComponent(jTextFieldlDataHoraEmprestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataHoraDevolucaoPrevista)
                    .addComponent(jTextFieldlDataHoraDevolucaoPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabellDataHoraDevolucaoEfetiva)
                    .addComponent(jTextFieldlDataHoraDevolucaoEfetiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Emprestimo Continuar exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            listaView.getEmprestimosController().excluir(Integer.valueOf(jTextFieldCodigo.getText()));
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldlDataHoraEmprestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldlDataHoraEmprestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldlDataHoraEmprestadoActionPerformed

    private void jTextFieldlDataHoraDevolucaoEfetivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldlDataHoraDevolucaoEfetivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldlDataHoraDevolucaoEfetivaActionPerformed

    private void jTextFieldlDataHoraDevolucaoPrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldlDataHoraDevolucaoPrevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldlDataHoraDevolucaoPrevistaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabelCidadao;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataHoraDevolucaoPrevista;
    private javax.swing.JLabel jLabelDataHoraEmprestado;
    private javax.swing.JLabel jLabelEstoques;
    private javax.swing.JLabel jLabellDataHoraDevolucaoEfetiva;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableEstoques;
    private javax.swing.JTextField jTextFieldCidadao;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldlDataHoraDevolucaoEfetiva;
    private javax.swing.JTextField jTextFieldlDataHoraDevolucaoPrevista;
    private javax.swing.JTextField jTextFieldlDataHoraEmprestado;
    // End of variables declaration//GEN-END:variables
}