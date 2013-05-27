package com.live.adsfatene.biblioteca_publica.views.estoques;

import com.live.adsfatene.biblioteca_publica.models.AnoPublicacao;
import com.live.adsfatene.biblioteca_publica.models.Autor;
import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.DadoMaterial;
import com.live.adsfatene.biblioteca_publica.models.Edicao;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Publico;
import com.live.adsfatene.biblioteca_publica.models.Statu;

public class FiltroView extends javax.swing.JDialog {

    private final ListaView listaView;

    FiltroView(ListaView listaView, boolean modal) {
        super(listaView.getEstoquesController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            jButtonLimparActionPerformed(null);
            if (!isVisible()) {
                setLocationRelativeTo(listaView.getEstoquesController().getAplicacaoController().getAplicacaoView());
            }
        }
        listaView.getjToggleButtonFiltro().setSelected(flag);
        super.setVisible(flag);
    }

    public void atualizar() {
        jComboBoxEdicao.removeAllItems();
        jComboBoxAnoPublicacao.removeAllItems();
        jComboBoxAutor.removeAllItems();
        jComboBoxEditora.removeAllItems();
        jComboBoxCategoria.removeAllItems();
        jComboBoxPublico.removeAllItems();
        jComboBoxFormato.removeAllItems();
        jComboBoxStatu.removeAllItems();

        jComboBoxEdicao.addItem("Todos");
        for (Edicao edicao : listaView.getEstoqueComboBox().getMaterialComboBox().getEdicoes()) {
            jComboBoxEdicao.addItem(edicao);
        }

        jComboBoxAnoPublicacao.addItem("Todos");
        for (AnoPublicacao anoPublicacao : listaView.getEstoqueComboBox().getMaterialComboBox().getAnosPublicacoes()) {
            jComboBoxAnoPublicacao.addItem(anoPublicacao);
        }

        jComboBoxAutor.addItem("Todos");
        for (Autor autor : listaView.getEstoqueComboBox().getMaterialComboBox().getAutores()) {
            jComboBoxAutor.addItem(autor);
        }

        jComboBoxEditora.addItem("Todos");
        for (Editora editora : listaView.getEstoqueComboBox().getMaterialComboBox().getEditoras()) {
            jComboBoxEditora.addItem(editora);
        }

        jComboBoxCategoria.addItem("Todos");
        for (Categoria categoria : listaView.getEstoqueComboBox().getMaterialComboBox().getCategorias()) {
            jComboBoxCategoria.addItem(categoria);
        }

        jComboBoxPublico.addItem("Todos");
        for (Publico publico : listaView.getEstoqueComboBox().getMaterialComboBox().getPublicos()) {
            jComboBoxPublico.addItem(publico);
        }

        jComboBoxFormato.addItem("Todos");
        for (Formato formato : listaView.getEstoqueComboBox().getMaterialComboBox().getFormatos()) {
            jComboBoxFormato.addItem(formato);
        }

        jComboBoxStatu.addItem("Todos");
        for (Statu statu : listaView.getEstoqueComboBox().getStatus()) {
            jComboBoxStatu.addItem(statu);
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

        jComboBoxFormato = new javax.swing.JComboBox();
        jTextFieldTitulo = new javax.swing.JTextField();
        jComboBoxPublico = new javax.swing.JComboBox();
        jComboBoxCategoria = new javax.swing.JComboBox();
        jLabelCategoria = new javax.swing.JLabel();
        jLabelEditora = new javax.swing.JLabel();
        jLabelFormato = new javax.swing.JLabel();
        jLabelPublico = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jComboBoxEdicao = new javax.swing.JComboBox();
        jLabelEdicao = new javax.swing.JLabel();
        jLabelAnoPublicacao = new javax.swing.JLabel();
        jLabelAutor = new javax.swing.JLabel();
        jComboBoxEditora = new javax.swing.JComboBox();
        jComboBoxAnoPublicacao = new javax.swing.JComboBox();
        jComboBoxAutor = new javax.swing.JComboBox();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jLabelStatu = new javax.swing.JLabel();
        jComboBoxStatu = new javax.swing.JComboBox();

        setTitle("Filtro");
        setResizable(false);

        jComboBoxFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFormatoActionPerformed(evt);
            }
        });

        jTextFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloActionPerformed(evt);
            }
        });

        jLabelCategoria.setText("Categoria");

        jLabelEditora.setText("Editora");

        jLabelFormato.setText("Formato");

        jLabelPublico.setText("Publico");

        jTextFieldDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescricaoActionPerformed(evt);
            }
        });

        jLabelDescricao.setText("Descrição");

        jLabelEdicao.setText("Edição");

        jLabelAnoPublicacao.setText("Ano de Publicação");

        jLabelAutor.setText("Autor");

        jComboBoxAnoPublicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAnoPublicacaoActionPerformed(evt);
            }
        });

        jLabelTitulo.setText("Título");

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

        jLabelStatu.setText("Statu");

        jComboBoxStatu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescricao)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelEdicao)
                    .addComponent(jLabelAnoPublicacao)
                    .addComponent(jLabelAutor)
                    .addComponent(jLabelEditora)
                    .addComponent(jLabelCategoria)
                    .addComponent(jLabelPublico)
                    .addComponent(jLabelFormato)
                    .addComponent(jLabelStatu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxStatu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBoxFormato, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxPublico, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxEditora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxAutor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxAnoPublicacao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxEdicao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEdicao)
                    .addComponent(jComboBoxEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnoPublicacao)
                    .addComponent(jComboBoxAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAutor)
                    .addComponent(jComboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEditora)
                    .addComponent(jComboBoxEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoria)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPublico)
                    .addComponent(jComboBoxPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFormato)
                    .addComponent(jComboBoxFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatu)
                    .addComponent(jComboBoxStatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTituloActionPerformed
    }//GEN-LAST:event_jTextFieldTituloActionPerformed

    private void jComboBoxAnoPublicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAnoPublicacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAnoPublicacaoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldTitulo.setText(null);
        jTextFieldDescricao.setText(null);
        jComboBoxEdicao.setSelectedIndex(0);
        jComboBoxAnoPublicacao.setSelectedIndex(0);
        jComboBoxAutor.setSelectedIndex(0);
        jComboBoxEditora.setSelectedIndex(0);
        jComboBoxCategoria.setSelectedIndex(0);
        jComboBoxPublico.setSelectedIndex(0);
        jComboBoxFormato.setSelectedIndex(0);
        jComboBoxStatu.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jComboBoxFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFormatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFormatoActionPerformed
    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        Estoque estoque = new Estoque();
        Material material = new Material();
        DadoMaterial dadoMaterial = new DadoMaterial();
        if (!jTextFieldTitulo.getText().isEmpty()) {
            dadoMaterial.setTitulo(jTextFieldTitulo.getText());
        }
        if (!jTextFieldDescricao.getText().isEmpty()) {
            dadoMaterial.setDescricao(jTextFieldDescricao.getText());
        }
        if (jComboBoxEdicao.getSelectedIndex() > 0) {
            dadoMaterial.setEdicao((Edicao) jComboBoxEdicao.getSelectedItem());
        }
        if (jComboBoxAnoPublicacao.getSelectedIndex() > 0) {
            dadoMaterial.setAnoPublicacao((AnoPublicacao) jComboBoxAnoPublicacao.getSelectedItem());
        }
        if (jComboBoxEditora.getSelectedIndex() > 0) {
            dadoMaterial.setEditora((Editora) jComboBoxEditora.getSelectedItem());
        }
        if (jComboBoxCategoria.getSelectedIndex() > 0) {
            dadoMaterial.setCategoria((Categoria) jComboBoxCategoria.getSelectedItem());
        }
        if (jComboBoxPublico.getSelectedIndex() > 0) {
            dadoMaterial.setPublico((Publico) jComboBoxPublico.getSelectedItem());
        }
        material.setDadoMaterial(dadoMaterial);
        if (jComboBoxFormato.getSelectedIndex() > 0) {
            material.setFormato((Formato) jComboBoxFormato.getSelectedItem());
        }
        estoque.setMaterial(material);
        if (jComboBoxStatu.getSelectedIndex() > 0) {
            estoque.setStatu((Statu) jComboBoxStatu.getSelectedItem());
        }
        listaView.getEstoquesController().filtrar(estoque);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescricaoActionPerformed

    private void jComboBoxStatuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStatuActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox jComboBoxAnoPublicacao;
    private javax.swing.JComboBox jComboBoxAutor;
    private javax.swing.JComboBox jComboBoxCategoria;
    private javax.swing.JComboBox jComboBoxEdicao;
    private javax.swing.JComboBox jComboBoxEditora;
    private javax.swing.JComboBox jComboBoxFormato;
    private javax.swing.JComboBox jComboBoxPublico;
    private javax.swing.JComboBox jComboBoxStatu;
    private javax.swing.JLabel jLabelAnoPublicacao;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelEdicao;
    private javax.swing.JLabel jLabelEditora;
    private javax.swing.JLabel jLabelFormato;
    private javax.swing.JLabel jLabelPublico;
    private javax.swing.JLabel jLabelStatu;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
