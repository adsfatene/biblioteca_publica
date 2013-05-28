package com.live.adsfatene.biblioteca_publica.views.cidadaos;

import com.live.adsfatene.biblioteca_publica.models.Bairro;
import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Cidade;
import com.live.adsfatene.biblioteca_publica.models.Estado;
import com.live.adsfatene.biblioteca_publica.models.Telefone;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EdicaoView extends javax.swing.JDialog {

    private final ListaView listaView;
    private Cidadao cidadao;
    private final DefaultTableModel dtmTelefones;
    private final DefaultTableModel dtmCelulares;

    EdicaoView(ListaView listaView, boolean modal) {
        super(listaView.getCidadaosController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
        jComboBoxCidade.setEditable(true);
        jComboBoxBairro.setEditable(true);
        dtmTelefones = (DefaultTableModel) jTableTelefones.getModel();
        dtmCelulares = (DefaultTableModel) jTableCelulares.getModel();
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            jButtonLimparActionPerformed(null);
            setLocationRelativeTo(listaView.getCidadaosController().getAplicacaoController().getAplicacaoView());
        }
        listaView.getjToggleButtonEdicao().setSelected(flag);
        super.setVisible(flag);
    }

    public void atualizar(Cidadao cidadao) {
        jComboBoxEstadoUF.removeAllItems();
        jComboBoxCidade.removeAllItems();
        jComboBoxBairro.removeAllItems();

        jTextFieldNomeCompleto.setText(cidadao.getNomeCompleto());
        jTextFieldLogradouro.setText(cidadao.getLogradouro());
        jTextFieldNumero.setText(cidadao.getNumeroImovel().toString());

        while (dtmTelefones.getRowCount() > 0) {
            dtmTelefones.removeRow(0);
        }
        while (dtmCelulares.getRowCount() > 0) {
            dtmCelulares.removeRow(0);
        }

        for (Estado estado : listaView.getCidadaoComboBox().getEstados()) {
            jComboBoxEstadoUF.addItem(estado);
        }
        jComboBoxEstadoUF.setSelectedItem(cidadao.getBairro().getCidade().getEstado());

        for (Cidade cidade : listaView.getCidadaoComboBox().getCidadades()) {
            jComboBoxCidade.addItem(cidade);
        }
        jComboBoxCidade.setSelectedItem(cidadao.getBairro().getCidade());

        for (Bairro bairro : listaView.getCidadaoComboBox().getBairros()) {
            jComboBoxBairro.addItem(bairro);
        }
        jComboBoxBairro.setSelectedItem(cidadao.getBairro());


        for (Telefone telefone : cidadao.getTelefones()) {
            dtmTelefones.addRow(new Object[dtmTelefones.getColumnCount()]);
            int coluna = 0;
            dtmTelefones.setValueAt(telefone, dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(telefone.getDDD(), dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(telefone.getNumero(), dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(telefone.getDDD().getEstado(), dtmTelefones.getRowCount() - 1, coluna++);
        }
        for (Celular celular : cidadao.getCelulares()) {
            dtmTelefones.addRow(new Object[dtmTelefones.getColumnCount()]);
            int coluna = 0;
            dtmTelefones.setValueAt(celular, dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(celular.getDDD(), dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(celular.getNumero(), dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(celular.getDDD().getEstado(), dtmTelefones.getRowCount() - 1, coluna++);
        }

        this.cidadao = cidadao;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAtualizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableCelulares = new javax.swing.JTable();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldNomeCompleto = new javax.swing.JTextField();
        jLabeCelulares = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstadoUF = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabelTelefones = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTelefones = new javax.swing.JTable();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelLogradouro = new javax.swing.JLabel();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jButtonRemoverTelefone = new javax.swing.JButton();
        jButtonAdicionarTefone = new javax.swing.JButton();
        jButtonAdicionarCelular = new javax.swing.JButton();
        jButtonRemoverCelular = new javax.swing.JButton();
        jComboBoxEstadoUF = new javax.swing.JComboBox();
        jComboBoxCidade = new javax.swing.JComboBox();
        jComboBoxBairro = new javax.swing.JComboBox();

        setTitle("Edição");
        setResizable(false);

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
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

        jTableCelulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefone", "DDD", "Número", "Estado - UF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableCelulares);
        jTableCelulares.getColumnModel().getColumn(0).setMinWidth(0);
        jTableCelulares.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableCelulares.getColumnModel().getColumn(0).setMaxWidth(0);

        jLabelBairro.setText("Bairro");

        jTextFieldNomeCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeCompletoActionPerformed(evt);
            }
        });

        jLabeCelulares.setText("Celulares");

        jLabelCidade.setText("Cidade");

        jLabelEstadoUF.setText("Estado - UF");

        jLabelTelefones.setText("Telefones");

        jLabelNumero.setText("Nº");

        jTableTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefone", "DDD", "Número", "Estado - UF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableTelefones);
        jTableTelefones.getColumnModel().getColumn(0).setMinWidth(0);
        jTableTelefones.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableTelefones.getColumnModel().getColumn(0).setMaxWidth(0);

        jLabelLogradouro.setText("Logradouro");

        jLabelNomeCompleto.setText("Nome Completo");

        jButtonRemoverTelefone.setText("-");
        jButtonRemoverTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverTelefoneActionPerformed(evt);
            }
        });

        jButtonAdicionarTefone.setText("+");
        jButtonAdicionarTefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarTefoneActionPerformed(evt);
            }
        });

        jButtonAdicionarCelular.setText("+");
        jButtonAdicionarCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarCelularActionPerformed(evt);
            }
        });

        jButtonRemoverCelular.setText("-");
        jButtonRemoverCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverCelularActionPerformed(evt);
            }
        });

        jComboBoxCidade.setEditable(true);

        jComboBoxBairro.setEditable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabeCelulares, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAdicionarCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRemoverCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelEstadoUF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNomeCompleto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelLogradouro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxBairro, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                .addComponent(jTextFieldNumero)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(216, 216, 216)
                                    .addComponent(jButtonAdicionarTefone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxEstadoUF, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNomeCompleto, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(0, 15, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeCompleto)
                    .addComponent(jTextFieldNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstadoUF)
                    .addComponent(jComboBoxEstadoUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidade)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jComboBoxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAdicionarTefone)
                        .addComponent(jButtonRemoverTelefone))
                    .addComponent(jLabelTelefones, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAdicionarCelular)
                        .addComponent(jButtonRemoverCelular))
                    .addComponent(jLabeCelulares, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldNomeCompleto.setText(cidadao.getNomeCompleto());
        jTextFieldLogradouro.setText(cidadao.getLogradouro());
        jTextFieldNumero.setText(cidadao.getNumeroImovel().toString());
        jComboBoxEstadoUF.setSelectedItem(cidadao.getBairro().getCidade().getEstado());
        jComboBoxCidade.setSelectedItem(cidadao.getBairro().getCidade());
        jComboBoxBairro.setSelectedItem(cidadao.getBairro());
        while (dtmTelefones.getRowCount() > 0) {
            dtmTelefones.removeRow(0);
        }
        while (dtmCelulares.getRowCount() > 0) {
            dtmCelulares.removeRow(0);
        }
        for (Telefone telefone : cidadao.getTelefones()) {
            dtmTelefones.addRow(new Object[dtmTelefones.getColumnCount()]);
            int coluna = 0;
            dtmTelefones.setValueAt(telefone, dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(telefone.getDDD(), dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(telefone.getNumero(), dtmTelefones.getRowCount() - 1, coluna++);
            dtmTelefones.setValueAt(telefone.getDDD().getEstado(), dtmTelefones.getRowCount() - 1, coluna++);
        }
        for (Celular celular : cidadao.getCelulares()) {
            dtmCelulares.addRow(new Object[dtmCelulares.getColumnCount()]);
            int coluna = 0;
            dtmCelulares.setValueAt(celular, dtmCelulares.getRowCount() - 1, coluna++);
            dtmCelulares.setValueAt(celular.getDDD(), dtmCelulares.getRowCount() - 1, coluna++);
            dtmCelulares.setValueAt(celular.getNumero(), dtmCelulares.getRowCount() - 1, coluna++);
            dtmCelulares.setValueAt(celular.getDDD().getEstado(), dtmCelulares.getRowCount() - 1, coluna++);
        }
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        Cidadao cidadaoEditado = new Cidadao();
        cidadaoEditado.setCodigo(this.cidadao.getCodigo());
        cidadaoEditado.setNomeCompleto(jTextFieldNomeCompleto.getText());
        cidadaoEditado.setLogradouro(jTextFieldLogradouro.getText());
        cidadaoEditado.setNumeroImovel(Integer.valueOf(jTextFieldNumero.getText()));

        Bairro bairro;
        if (jComboBoxBairro.getSelectedItem() instanceof Bairro) {
            bairro = ((Bairro) jComboBoxBairro.getSelectedItem()).getClone();
        } else {
            bairro = new Bairro();
            bairro.setNome(jComboBoxBairro.getSelectedItem().toString());
        }
        cidadaoEditado.setBairro(bairro);
 
        Cidade cidade;
        if(jComboBoxCidade.getSelectedItem() instanceof Cidade){
            cidade = ((Cidade) jComboBoxCidade.getSelectedItem()).getClone();
        }else{
            cidade = new Cidade();
            cidade.setNome((String) jComboBoxCidade.getSelectedItem());
        }
        bairro.setCidade(cidade);
        
        cidade.setEstado((Estado) jComboBoxEstadoUF.getSelectedItem());
        
        cidadaoEditado.setTelefones(this.cidadao.getTelefones());
        cidadaoEditado.setCelulares(this.cidadao.getCelulares());

        if (!this.cidadao.ehIgual(cidadaoEditado)) {
            this.cidadao = cidadaoEditado;
            listaView.getCidadaosController().atualizar(this.cidadao);
        } else {
            JOptionPane.showMessageDialog(this, "cidadao nao editado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jTextFieldNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeCompletoActionPerformed
    }//GEN-LAST:event_jTextFieldNomeCompletoActionPerformed

    private void jButtonRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverTelefoneActionPerformed
        while (jTableTelefones.getSelectedRowCount() > 0) {
            dtmTelefones.removeRow(jTableTelefones.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonRemoverTelefoneActionPerformed

    private void jButtonAdicionarTefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTefoneActionPerformed
//        Formato formato;
//        if (jComboBoxFormato.getSelectedItem() instanceof Formato) {
//            formato = (Formato) jComboBoxFormato.getSelectedItem();
//            jComboBoxFormato.removeItemAt(jComboBoxFormato.getSelectedIndex());
//        } else {
//            formato = new Formato();
//            formato.setNome(jComboBoxFormato.getSelectedItem().toString());
//            jComboBoxFormato.setSelectedIndex(0);
//        }
//
//        int quantidade = 1;
//        if (formato.getNome().equalsIgnoreCase("impresso")) {
//            String valor = JOptionPane.showInputDialog(this, "digite uma quantidade:", "Quantidade", JOptionPane.INFORMATION_MESSAGE);
//            try {
//                quantidade = Integer.valueOf(valor);
//                if (quantidade < 1) {
//                    quantidade = 1;
//                }
//            } catch (NumberFormatException ex) {
//                quantidade = 1;
//            }
//        }
//        dtm.addRow(new Object[dtm.getColumnCount()]);
//        dtm.setValueAt(formato, dtm.getRowCount() - 1, 0);
//        dtm.setValueAt(quantidade, dtm.getRowCount() - 1, 1);
//        dtm.setValueAt("", dtm.getRowCount() - 1, 2);
//        dtm.setValueAt("", dtm.getRowCount() - 1, 3);
    }//GEN-LAST:event_jButtonAdicionarTefoneActionPerformed

    private void jButtonAdicionarCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAdicionarCelularActionPerformed

    private void jButtonRemoverCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverCelularActionPerformed
        while (jTableCelulares.getSelectedRowCount() > 0) {
            dtmCelulares.removeRow(jTableCelulares.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonRemoverCelularActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarCelular;
    private javax.swing.JButton jButtonAdicionarTefone;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRemoverCelular;
    private javax.swing.JButton jButtonRemoverTelefone;
    private javax.swing.JComboBox jComboBoxBairro;
    private javax.swing.JComboBox jComboBoxCidade;
    private javax.swing.JComboBox jComboBoxEstadoUF;
    private javax.swing.JLabel jLabeCelulares;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEstadoUF;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNomeCompleto;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTelefones;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableCelulares;
    private javax.swing.JTable jTableTelefones;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNomeCompleto;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}