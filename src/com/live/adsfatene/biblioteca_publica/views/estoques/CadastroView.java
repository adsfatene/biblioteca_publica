package com.live.adsfatene.biblioteca_publica.views.estoques;

import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Statu;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.live.adsfatene.biblioteca_publica.views.materiais.ListaView;

public class CadastroView extends javax.swing.JDialog {

    private final ListaView listaView;
    private final DefaultTableModel dtmEstoque;
    private final DefaultTableModel dtmMaterial;

    CadastroView(ListaView listaView, boolean modal) {
        super(listaView.getMateriaisController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
        dtmEstoque = (DefaultTableModel) jTableEstoque.getModel();
        dtmMaterial = (DefaultTableModel) this.listaView.getjTableLista().getModel();
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            jButtonLimparActionPerformed(null);
            setLocationRelativeTo(listaView.getMateriaisController().getAplicacaoController().getAplicacaoView());
        } else {
            listaView.getMateriaisController().getAplicacaoController().getEstoquesController().iniciar();
        }
        listaView.getMateriaisController().getAplicacaoController().getEstoquesController().getListaView().getjToggleButtonCadastro().setSelected(flag);
        listaView.habilitar(!flag);
        super.setVisible(flag);
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
        jButtonRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEstoque = new javax.swing.JTable();
        jButtonEstocar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();

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

        jButtonRemover.setText("-");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jTableEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material", "Codigo", "Titulo", "Formato", "Localização", "Statu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableEstoque);
        jTableEstoque.getColumnModel().getColumn(0).setMinWidth(0);
        jTableEstoque.getColumnModel().getColumn(0).setMaxWidth(0);

        jButtonEstocar.setText("Estocar");
        jButtonEstocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstocarActionPerformed(evt);
            }
        });

        jButtonAdicionar.setText("+");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonEstocar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(322, 322, 322)
                            .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonEstocar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        while (dtmEstoque.getRowCount() > 0) {
            dtmEstoque.removeRow(0);
        }
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        while (jTableEstoque.getSelectedRowCount() > 0) {
            dtmEstoque.removeRow(jTableEstoque.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonEstocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstocarActionPerformed
        if (jTableEstoque.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "material é obrigatorio. adicione pelo menos um material", "aviso", JOptionPane.WARNING_MESSAGE);
        } else if (!validarLocaisLogicosFisicos()) {
            JOptionPane.showMessageDialog(this, "localização é obrigatorio.", "aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            List<Estoque> estoques = new LinkedList<>();
            Estoque estoque;
            for (int i = 0; i < jTableEstoque.getRowCount(); i++) {
                estoque = new Estoque();
                estoque.setMaterial((Material) jTableEstoque.getValueAt(i, 0));
                estoque.setLocalLogicoFisico(jTableEstoque.getValueAt(i, jTableEstoque.getColumnCount() - 2).toString());
                estoque.setStatu((Statu) jTableEstoque.getValueAt(i, jTableEstoque.getColumnCount() - 1));
                estoques.add(estoque);
            }
            listaView.getMateriaisController().getAplicacaoController().getEstoquesController().estocar(estoques);
            setVisible(false);
        }
    }//GEN-LAST:event_jButtonEstocarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        if (listaView.getjTableLista().getSelectedRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "material é obrigatorio. selecione pelo menos um material", "aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            Statu statu = new Statu();
            statu.setNome("Novo");
            for (Integer linha : listaView.getjTableLista().getSelectedRows()) {
                Material material = (Material) listaView.getjTableLista().getValueAt(linha, 0);
                if (!validarMaterialAdicionado(material)) {
                    int coluna = 0;
                    dtmEstoque.addRow(new Object[dtmEstoque.getColumnCount()]);
                    dtmEstoque.setValueAt(material, dtmEstoque.getRowCount() - 1, coluna++);
                    dtmEstoque.setValueAt(material.getCodigo(), dtmEstoque.getRowCount() - 1, coluna++);
                    dtmEstoque.setValueAt(material.getDadoMaterial().getTitulo(), dtmEstoque.getRowCount() - 1, coluna++);
                    dtmEstoque.setValueAt(material.getFormato(), dtmEstoque.getRowCount() - 1, coluna++);
                    dtmEstoque.setValueAt("", dtmEstoque.getRowCount() - 1, coluna++);
                    dtmEstoque.setValueAt(statu, dtmEstoque.getRowCount() - 1, coluna++);
                }
            }
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEstocar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableEstoque;
    // End of variables declaration//GEN-END:variables

    private boolean validarLocaisLogicosFisicos() {
        for (int i = 0; i < dtmEstoque.getRowCount(); i++) {
            if (dtmEstoque.getValueAt(i, dtmEstoque.getColumnCount() - 2).toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean validarMaterialAdicionado(Material material) {
        for (int i = 0; i < dtmEstoque.getRowCount(); i++) {
            if (material.ehIgual((Material) dtmEstoque.getValueAt(i, 0))) {
                return true;
            }
        }
        return false;
    }
}