package com.live.adsfatene.biblioteca_publica.views.emprestimos;

import javax.swing.JOptionPane;

public class EstadoDevolucaoMotivoView extends javax.swing.JDialog {

    private final EdicaoView edicaoView;
    private String motivo;
    private String estadoDevolucao;

    EstadoDevolucaoMotivoView(EdicaoView edicaoView, boolean modal) {
        super(edicaoView, modal);
        initComponents();
        this.edicaoView = edicaoView;
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            setLocationRelativeTo(edicaoView);
        }
        super.setVisible(flag);
    }

    public void atualizar() {
        jButtonLimparActionPerformed(null);
        estadoDevolucao = edicaoView.getDtm().getValueAt(edicaoView.getjTableEstoques().getSelectedRow(),
                edicaoView.getDtm().getColumnCount() - 2).toString();
        motivo = edicaoView.getDtm().getValueAt(edicaoView.getjTableEstoques().getSelectedRow(),
                edicaoView.getDtm().getColumnCount() - 1).toString();
        jComboBoxEstadoDevolucao.setSelectedItem(estadoDevolucao);
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
        jButtonLimpar = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jComboBoxEstadoDevolucao = new javax.swing.JComboBox();
        jLabelMotivo = new javax.swing.JLabel();
        jLabelEstadoDevolucao = new javax.swing.JLabel();
        jTextFieldMotivo = new javax.swing.JTextField();

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

        setTitle("Cadastro");
        setResizable(false);

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

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jComboBoxEstadoDevolucao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perfeito", "Avariado", "Irrecuperavel" }));

        jLabelMotivo.setText("Motivo");

        jLabelEstadoDevolucao.setText("Estado Devolução");

        jTextFieldMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMotivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEstadoDevolucao)
                    .addComponent(jLabelMotivo))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxEstadoDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstadoDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstadoDevolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMotivo)
                    .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        if (estadoDevolucao != null) {
            jComboBoxEstadoDevolucao.setSelectedItem(estadoDevolucao);
        } else {
            jComboBoxEstadoDevolucao.setSelectedIndex(0);
        }
        jTextFieldMotivo.setText(motivo);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (jComboBoxEstadoDevolucao.getSelectedIndex() > 0 && jTextFieldMotivo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "motivo obrigatorio.", "aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            edicaoView.getDtm().setValueAt(jComboBoxEstadoDevolucao.getSelectedItem(), edicaoView.getjTableEstoques().getSelectedRow(), edicaoView.getDtm().getColumnCount() - 2);
            edicaoView.getDtm().setValueAt(jTextFieldMotivo.getText().trim(), edicaoView.getjTableEstoques().getSelectedRow(), edicaoView.getDtm().getColumnCount() - 1);
            motivo = null;
            estadoDevolucao = null;
            setVisible(false);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTextFieldMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMotivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMotivoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JComboBox jComboBoxEstadoDevolucao;
    private javax.swing.JLabel jLabelEstadoDevolucao;
    private javax.swing.JLabel jLabelMotivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldMotivo;
    // End of variables declaration//GEN-END:variables
}