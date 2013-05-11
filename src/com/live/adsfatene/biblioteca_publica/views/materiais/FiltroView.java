package com.live.adsfatene.biblioteca_publica.views.materiais;

import com.live.adsfatene.biblioteca_publica.models.AnoPublicacao;
import com.live.adsfatene.biblioteca_publica.models.Autor;
import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.DadoMaterial;
import com.live.adsfatene.biblioteca_publica.models.Edicao;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Publico;

public class FiltroView extends javax.swing.JDialog {

    private final ListaView listaView;

    FiltroView(ListaView listaView, boolean modal) {
        super(listaView.getMateriaisController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            jButtonLimparActionPerformed(null);
            setLocationRelativeTo(this.listaView);
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

        jComboBoxEdicao.addItem("Todos");
        for (Edicao edicao : listaView.getMaterialComboBox().getEdicoes()) {
            jComboBoxEdicao.addItem(edicao);
        }

        jComboBoxAnoPublicacao.addItem("Todos");
        for (AnoPublicacao anoPublicacao : listaView.getMaterialComboBox().getAnosPublicacoes()) {
            jComboBoxAnoPublicacao.addItem(anoPublicacao);
        }

        jComboBoxAutor.addItem("Todos");
        for (Autor autor : listaView.getMaterialComboBox().getAutores()) {
            jComboBoxAutor.addItem(autor);
        }

        jComboBoxEditora.addItem("Todos");
        for (Editora editora : listaView.getMaterialComboBox().getEditoras()) {
            jComboBoxEditora.addItem(editora);
        }

        jComboBoxCategoria.addItem("Todos");
        for (Categoria categoria : listaView.getMaterialComboBox().getCategorias()) {
            jComboBoxCategoria.addItem(categoria);
        }

        jComboBoxPublico.addItem("Todos");
        for (Publico publico : listaView.getMaterialComboBox().getPublicos()) {
            jComboBoxPublico.addItem(publico);
        }

        jComboBoxFormato.addItem("Todos");
        for (Formato formato : listaView.getMaterialComboBox().getFormatos()) {
            jComboBoxFormato.addItem(formato);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                    .addComponent(jLabelFormato))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                    .addComponent(jTextFieldTitulo))
                .addGap(0, 20, Short.MAX_VALUE))
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
                    .addComponent(jButtonPesquisar)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonLimpar))
                .addContainerGap(24, Short.MAX_VALUE))
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
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jComboBoxFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFormatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFormatoActionPerformed
    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
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

        listaView.getMateriaisController().filtrar(material);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescricaoActionPerformed

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
    private javax.swing.JLabel jLabelAnoPublicacao;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelEdicao;
    private javax.swing.JLabel jLabelEditora;
    private javax.swing.JLabel jLabelFormato;
    private javax.swing.JLabel jLabelPublico;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
