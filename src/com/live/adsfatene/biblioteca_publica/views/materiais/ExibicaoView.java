package com.live.adsfatene.biblioteca_publica.views.materiais;

import com.live.adsfatene.biblioteca_publica.models.Material;
import javax.swing.JOptionPane;

public class ExibicaoView extends javax.swing.JDialog {

    private final ListaView listaView;

    ExibicaoView(ListaView listaView, boolean modal) {
        super(listaView.getMateriaisController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            setLocationRelativeTo(listaView.getMateriaisController().getAplicacaoController().getAplicacaoView());
        }
        super.setVisible(flag);
    }

    public void atualizar(Material material) {
        jTextFieldCodigo.setText(material.getCodigo().toString());
        jTextFieldTitulo.setText(material.getDadoMaterial().getTitulo());
        jTextFieldDescricao.setText(material.getDadoMaterial().getDescricao());
        jTextFieldEdicao.setText(material.getDadoMaterial().getEdicao().toString());
        jTextFieldAnoPublicacao.setText(material.getDadoMaterial().getAnoPublicacao().toString());
        jTextFieldEditora.setText(material.getDadoMaterial().getEditora().getNome());
        jTextFieldCategoria.setText(material.getDadoMaterial().getCategoria().getNome());
        jTextFieldPublico.setText(material.getDadoMaterial().getPublico().getNome());
        jTextFieldFormato.setText(material.getFormato().getNome());
        jTextFieldInformacao.setText(material.getInformacao());
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
        jLabelCategoria = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabelPublico = new javax.swing.JLabel();
        jLabelEditora = new javax.swing.JLabel();
        jLabelEdicao = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelAutor = new javax.swing.JLabel();
        jLabelAnoPublicacao = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabelFormato = new javax.swing.JLabel();
        jTextFieldEdicao = new javax.swing.JTextField();
        jTextFieldAnoPublicacao = new javax.swing.JTextField();
        jTextFieldAutor = new javax.swing.JTextField();
        jTextFieldEditora = new javax.swing.JTextField();
        jTextFieldCategoria = new javax.swing.JTextField();
        jTextFieldPublico = new javax.swing.JTextField();
        jTextFieldFormato = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldInformacao = new javax.swing.JTextField();
        jLabelInformacao = new javax.swing.JLabel();

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

        jLabelCategoria.setText("Categoria");

        jTextFieldTitulo.setEditable(false);
        jTextFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloActionPerformed(evt);
            }
        });

        jLabelPublico.setText("Publico");

        jLabelEditora.setText("Editora");

        jLabelEdicao.setText("Edição");

        jLabelDescricao.setText("Descrição");

        jTextFieldDescricao.setEditable(false);

        jLabelTitulo.setText("Título");

        jLabelAutor.setText("Autor");

        jLabelAnoPublicacao.setText("Ano de Publicação");

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

        jLabelFormato.setText("Formato");

        jTextFieldEdicao.setEditable(false);

        jTextFieldAnoPublicacao.setEditable(false);
        jTextFieldAnoPublicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnoPublicacaoActionPerformed(evt);
            }
        });

        jTextFieldAutor.setEditable(false);

        jTextFieldEditora.setEditable(false);

        jTextFieldCategoria.setEditable(false);

        jTextFieldPublico.setEditable(false);

        jTextFieldFormato.setEditable(false);
        jTextFieldFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFormatoActionPerformed(evt);
            }
        });

        jLabelCodigo.setText("Codigo");

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jTextFieldInformacao.setEditable(false);

        jLabelInformacao.setText("Informação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFormato, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addGap(60, 60, 60)
                        .addComponent(jTextFieldFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEdicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelAnoPublicacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEditora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelPublico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                            .addComponent(jTextFieldEditora, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                            .addComponent(jTextFieldEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                                            .addComponent(jTextFieldDescricao)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldAnoPublicacao))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jTextFieldPublico))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabelInformacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEdicao)
                    .addComponent(jTextFieldEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAnoPublicacao)
                    .addComponent(jTextFieldAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAutor)
                    .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEditora)
                    .addComponent(jTextFieldEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPublico)
                    .addComponent(jTextFieldPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFormato)
                    .addComponent(jTextFieldFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInformacao)
                    .addComponent(jTextFieldInformacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloActionPerformed
    }//GEN-LAST:event_jTextFieldTituloActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Continuar exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            listaView.getMateriaisController().excluir(Integer.valueOf(jTextFieldCodigo.getText()));
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldAnoPublicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnoPublicacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnoPublicacaoActionPerformed

    private void jTextFieldFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFormatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFormatoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabelAnoPublicacao;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelEdicao;
    private javax.swing.JLabel jLabelEditora;
    private javax.swing.JLabel jLabelFormato;
    private javax.swing.JLabel jLabelInformacao;
    private javax.swing.JLabel jLabelPublico;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldAnoPublicacao;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldEdicao;
    private javax.swing.JTextField jTextFieldEditora;
    private javax.swing.JTextField jTextFieldFormato;
    private javax.swing.JTextField jTextFieldInformacao;
    private javax.swing.JTextField jTextFieldPublico;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}