package com.live.adsfatene.biblioteca_publica.views.emprestimos;

import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.EmprestimoEstoque;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EdicaoView extends javax.swing.JDialog {

    private Cidadao cidadao;
    private final ListaView listaView;
    private Emprestimo emprestimo;
    private final DefaultTableModel dtm;
    private EstadoDevolucaoMotivoView estadoDevolucaoView;

    EdicaoView(ListaView listaView, boolean modal) {
        super(listaView.getEmprestimosController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
        dtm = (DefaultTableModel) jTableEstoques.getModel();
        estadoDevolucaoView = new EstadoDevolucaoMotivoView(this, true);
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            jButtonLimparActionPerformed(null);
            setLocationRelativeTo(listaView.getEmprestimosController().getAplicacaoController().getAplicacaoView());
        }
        listaView.getjToggleButtonEdicao().setSelected(flag);
        super.setVisible(flag);
    }

    public void atualizar(Emprestimo emprestimo) {
        jTextFieldCodigo.setText(emprestimo.getCodigo().toString());
        jTextFieldCidadao.setText(emprestimo.getCidadao().toString());
        jTextFieldDataHoraEmprestado.setText(listaView.getSdf().format(emprestimo.getDataHoraEmprestato().getTime()));
        jTextFieldDataHoraDevoluçãoPrevista.setText(listaView.getSdf().format(emprestimo.getDataHoraDevolucaoPrevista().getTime()));

        while(dtm.getRowCount() > 0){
            dtm.removeRow(0);
        }
        
        for (EmprestimoEstoque emprestimoEstoque : emprestimo.getEmprestimosEstoques()) {
            Estoque estoque = emprestimoEstoque.getEstoque();
            dtm.addRow(new Object[dtm.getColumnCount()]);
            int coluna = 0;
            dtm.setValueAt(estoque, dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(estoque.getMaterial().getDadoMaterial().getTitulo(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(estoque.getMaterial().getFormato(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt(estoque.getLocalLogicoFisico(), dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt("", dtm.getRowCount() - 1, coluna++);
            dtm.setValueAt("", dtm.getRowCount() - 1, coluna++);
        }

        this.emprestimo = emprestimo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonConcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelCidadao = new javax.swing.JLabel();
        jTextFieldCidadao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEstoques = new javax.swing.JTable();
        jLabelEstoques = new javax.swing.JLabel();
        jLabelDataHoraEmprestado = new javax.swing.JLabel();
        jTextFieldDataHoraEmprestado = new javax.swing.JTextField();
        jLabelDataHoraDevoluçãoPrevista = new javax.swing.JLabel();
        jTextFieldDataHoraDevoluçãoPrevista = new javax.swing.JTextField();
        jButtonAlterarEstadoDevolucaoMotivo = new javax.swing.JButton();

        setTitle("Edição");
        setResizable(false);

        jButtonConcluir.setText("Concluir");
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
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

        jLabelCodigo.setText("Codigo");

        jTextFieldCodigo.setEditable(false);

        jLabelCidadao.setText("Cidadão");

        jTextFieldCidadao.setEditable(false);

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

        jLabelEstoques.setText("Estoques");

        jLabelDataHoraEmprestado.setText("Data/Hora Emprestado");

        jTextFieldDataHoraEmprestado.setEditable(false);
        jTextFieldDataHoraEmprestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataHoraEmprestadoActionPerformed(evt);
            }
        });

        jLabelDataHoraDevoluçãoPrevista.setText("Data/Hora Devolução Prevista");

        jTextFieldDataHoraDevoluçãoPrevista.setEditable(false);
        jTextFieldDataHoraDevoluçãoPrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataHoraDevoluçãoPrevistaActionPerformed(evt);
            }
        });

        jButtonAlterarEstadoDevolucaoMotivo.setText("Alterar Estado Devolução/Motivo");
        jButtonAlterarEstadoDevolucaoMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarEstadoDevolucaoMotivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodigo)
                            .addComponent(jLabelCidadao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCidadao)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEstoques, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAlterarEstadoDevolucaoMotivo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDataHoraEmprestado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldDataHoraEmprestado, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDataHoraDevoluçãoPrevista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldDataHoraDevoluçãoPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelEstoques)
                    .addComponent(jButtonAlterarEstadoDevolucaoMotivo))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataHoraEmprestado)
                    .addComponent(jTextFieldDataHoraEmprestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataHoraDevoluçãoPrevista)
                    .addComponent(jTextFieldDataHoraDevoluçãoPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConcluir)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.setValueAt("", i, dtm.getColumnCount() - 2);
            dtm.setValueAt("", i, dtm.getColumnCount() - 1);
        }
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        boolean sucesso = true;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String estadoDevolucao = dtm.getValueAt(i, dtm.getColumnCount() - 2).toString().trim();
            String motivo = dtm.getValueAt(i, dtm.getColumnCount() - 1).toString().trim();
            if (estadoDevolucao.isEmpty()) {
                sucesso = false;
            } else {
                emprestimo.getEmprestimosEstoques().get(i).setEstadoDevolucao(estadoDevolucao);
                emprestimo.getEmprestimosEstoques().get(i).setMotivo(motivo);
            }
        }
        if (sucesso) {
            listaView.getEmprestimosController().concluir(emprestimo);
        } else {
            JOptionPane.showMessageDialog(this, "estado devolucao obrigatorio.", "aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jTextFieldDataHoraEmprestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataHoraEmprestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataHoraEmprestadoActionPerformed

    private void jTextFieldDataHoraDevoluçãoPrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataHoraDevoluçãoPrevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataHoraDevoluçãoPrevistaActionPerformed

    private void jButtonAlterarEstadoDevolucaoMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarEstadoDevolucaoMotivoActionPerformed
        if (jTableEstoques.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "estoque obrigatorio. selecione um estoque", "aviso", JOptionPane.WARNING_MESSAGE);
            listaView.getjToggleButtonEdicao().setSelected(false);
        } else {
            listaView.getEmprestimosController().atualizarDadosDeDevolucaoDoEmprestimo();
        }
    }//GEN-LAST:event_jButtonAlterarEstadoDevolucaoMotivoActionPerformed

    public JTextField getjTextFieldCidadao() {
        return jTextFieldCidadao;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public JTable getjTableEstoques() {
        return jTableEstoques;
    }

    public EstadoDevolucaoMotivoView getEstadoDevolucaoView() {
        return estadoDevolucaoView;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarEstadoDevolucaoMotivo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JLabel jLabelCidadao;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDataHoraDevoluçãoPrevista;
    private javax.swing.JLabel jLabelDataHoraEmprestado;
    private javax.swing.JLabel jLabelEstoques;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEstoques;
    private javax.swing.JTextField jTextFieldCidadao;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataHoraDevoluçãoPrevista;
    private javax.swing.JTextField jTextFieldDataHoraEmprestado;
    // End of variables declaration//GEN-END:variables
}