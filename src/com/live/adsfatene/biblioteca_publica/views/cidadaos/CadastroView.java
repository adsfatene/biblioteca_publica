package com.live.adsfatene.biblioteca_publica.views.cidadaos;

import com.live.adsfatene.biblioteca_publica.models.Bairro;
import javax.swing.table.DefaultTableModel;
import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Cidade;
import com.live.adsfatene.biblioteca_publica.models.DDD;
import com.live.adsfatene.biblioteca_publica.models.Estado;
import com.live.adsfatene.biblioteca_publica.models.Telefone;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class CadastroView extends javax.swing.JDialog {

    private final ListaView listaView;
    private final DefaultTableModel dtmCelulares;
    private final DefaultTableModel dtmTelefones;
    private LinkedList<Telefone> telefones = new LinkedList<Telefone>();
    private LinkedList<Celular> celulares = new LinkedList<Celular>();

    CadastroView(ListaView listaView, boolean modal) {
        super(listaView.getCidadaosController().getAplicacaoController().getAplicacaoView(), modal);
        initComponents();
        this.listaView = listaView;
        dtmCelulares = (DefaultTableModel) jTableCelulares.getModel();
        dtmTelefones = (DefaultTableModel) jTableTelefones.getModel();
        jComboBoxBairro.setEditable(true);
        jComboBoxCidade.setEditable(true);
    }

    @Override
    public void setVisible(boolean flag) {
        if (flag) {
            jButtonLimparActionPerformed(null);
            setLocationRelativeTo(listaView.getCidadaosController().getAplicacaoController().getAplicacaoView());
        }
        listaView.getjToggleButtonCadastro().setSelected(flag);
        super.setVisible(flag);
    }

    public void atualizar() {
        jComboBoxBairro.removeAllItems();
        jComboBoxCidade.removeAllItems();
        jComboBoxEstadoUF.removeAllItems();

        jTextFieldLogradouro.setText(null);
        jTextFieldNomeCompleto.setText(null);
        jTextFieldNumero.setText(null);

        for (Estado estado : listaView.getCidadaoComboBox().getEstados()) {
            jComboBoxEstadoUF.addItem(estado);
        }
        jComboBoxEstadoUF.setSelectedIndex(5);
    }
    
    public void atualizarCidades(){

        jComboBoxCidade.removeAllItems();
        
        Object obj = jComboBoxEstadoUF.getSelectedItem();
        Estado estado = (Estado) obj;
        if(estado != null){
            for (Cidade cidade : listaView.getCidadaoComboBox().getCidades()) {
                if(cidade.getEstado().getCodigo() == estado.getCodigo()){
                    jComboBoxCidade.addItem(cidade);
                }
            }
        }
    }

    public void atualizarBairros(){
        jComboBoxBairro.removeAllItems();
        
        Object obj = jComboBoxCidade.getSelectedItem();
        Cidade cidade = (Cidade) obj;
        if(cidade != null){
            for (Bairro bairro : listaView.getCidadaoComboBox().getBairros()) {
                if(bairro.getCidade().getCodigo() == cidade.getCodigo()){
                    jComboBoxBairro.addItem(bairro);
                }
            }
        
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
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonRemoverTelefone = new javax.swing.JButton();
        jButtonAdicionarTefone = new javax.swing.JButton();
        jComboBoxBairro = new javax.swing.JComboBox();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelLogradouro = new javax.swing.JLabel();
        jLabelNomeCompleto = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableCelulares = new javax.swing.JTable();
        jComboBoxEstadoUF = new javax.swing.JComboBox();
        jComboBoxCidade = new javax.swing.JComboBox();
        jButtonAdicionarCelular = new javax.swing.JButton();
        jButtonRemoverCelular = new javax.swing.JButton();
        jTextFieldNomeCompleto = new javax.swing.JTextField();
        jLabeCelulares = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstadoUF = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabelTelefones = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTelefones = new javax.swing.JTable();

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

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

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

        jComboBoxBairro.setEditable(true);

        jLabelLogradouro.setText("Logradouro");

        jLabelNomeCompleto.setText("Nome Completo");

        jLabelBairro.setText("Bairro");

        jTableCelulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DDD", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableCelulares);

        jComboBoxEstadoUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoUFActionPerformed(evt);
            }
        });

        jComboBoxCidade.setEditable(true);
        jComboBoxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCidadeActionPerformed(evt);
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
                "DDD", "Número"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableTelefones);

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
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelNomeCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelEstadoUF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxCidade, 0, 304, Short.MAX_VALUE)
                                    .addComponent(jComboBoxEstadoUF, 0, 304, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAdicionarTefone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBoxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jTextFieldNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefones)
                    .addComponent(jButtonAdicionarTefone)
                    .addComponent(jButtonRemoverTelefone))
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
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldNomeCompleto.setText("");
        jTextFieldLogradouro.setText("");
        jTextFieldNumero.setText("");
        jComboBoxEstadoUF.setSelectedIndex(5);
        //jComboBoxCidade.setSelectedIndex(0);
        //jComboBoxBairro.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jTextFieldNomeCompleto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "nome completo obrigatorio", "aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            Cidadao cidadao = new Cidadao();
            cidadao.setNomeCompleto(jTextFieldNomeCompleto.getText());
            cidadao.setLogradouro(jTextFieldLogradouro.getText());
            try{
            cidadao.setNumeroImovel(Integer.valueOf(jTextFieldNumero.getText()));
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "O Nº do imovél não é válido!", "Endereço", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Bairro bairro;
            if (jComboBoxBairro.getSelectedItem() instanceof Bairro) {
                bairro = ((Bairro) jComboBoxBairro.getSelectedItem()).getClone();
            } else {
                bairro = new Bairro();
                bairro.setNome(jComboBoxBairro.getSelectedItem().toString());
            }
            

            Cidade cidade;
            if (jComboBoxCidade.getSelectedItem() instanceof Cidade) {
                cidade = ((Cidade) jComboBoxCidade.getSelectedItem()).getClone();
            } else {
                cidade = new Cidade();
                cidade.setNome((String) jComboBoxCidade.getSelectedItem());
            }
            bairro.setCidade(cidade);

            cidade.setEstado((Estado) jComboBoxEstadoUF.getSelectedItem());

            cidadao.setBairro(bairro);
            
            if(jTableTelefones.getRowCount() > 0){
                telefones.clear();
                for(int i = 0; i < jTableTelefones.getRowCount(); i++){
                    int coluna = 0;
                    DDD ddd = (DDD)jTableTelefones.getValueAt(i, coluna++);
                    String numero = (String)jTableTelefones.getValueAt(i, coluna++);
                    if(numero.equals("")){
                        JOptionPane.showMessageDialog(this, "Preencha o campo Número do Telefone!", "Telefone", JOptionPane.ERROR_MESSAGE);
                        telefones.clear();
                        return;
                    } else {
                        Telefone telefone = new Telefone();
                        telefone.setDDD(ddd);
                        telefone.setNumero(numero);
                        telefone.setTipo("Tel");
                        telefones.add(telefone);
            
                    }
                }
            }
            
            if(jTableCelulares.getRowCount() > 0){
                celulares.clear();
                for(int i = 0; i < jTableCelulares.getRowCount(); i++){
                    DDD ddd = (DDD)jTableCelulares.getValueAt(i, 0);
                    String numero = (String)jTableCelulares.getValueAt(i, 1);
                    if(numero.equals("")){
                        JOptionPane.showMessageDialog(this, "Preencha o campo Número do Celular!", "Telefone", JOptionPane.ERROR_MESSAGE);
                        celulares.clear();
                        return;
                    } else {
                        Celular celular = new Celular();
                        celular.setDDD(ddd);
                        celular.setNumero(numero);
                        celular.setTipo("Cel");
                        celulares.add(celular);
                    }
                }
            }
            
            
            cidadao.setTelefones(telefones);
            cidadao.setCelulares(celulares);

            listaView.getCidadaosController().salvar(cidadao);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverTelefoneActionPerformed
        while (jTableTelefones.getSelectedRowCount() > 0) {
            dtmTelefones.removeRow(jTableTelefones.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonRemoverTelefoneActionPerformed

    private void jButtonAdicionarTefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTefoneActionPerformed
        
        String ddd_txt = JOptionPane.showInputDialog(this, "digite o ddd:", "DDD", JOptionPane.INFORMATION_MESSAGE);
        boolean invalido = true;
        for(DDD ddd : listaView.getCidadaoComboBox().getDDDs()){
            if(ddd_txt.equals(ddd.getNumero().toString())){
                dtmTelefones.addRow(new Object[dtmTelefones.getColumnCount()]);
                dtmTelefones.setValueAt(ddd, dtmTelefones.getRowCount() - 1, 0);
                dtmTelefones.setValueAt("", dtmTelefones.getRowCount() - 1, 1);
                invalido = false;
                break;
            }
        }
        if(invalido){
            String mensagem = "O ddd " + ddd_txt + " não é válido!";
            JOptionPane.showMessageDialog(this, mensagem, "DDD Inválido", JOptionPane.ERROR_MESSAGE);
        }
        
          
    }//GEN-LAST:event_jButtonAdicionarTefoneActionPerformed

    private void jButtonAdicionarCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarCelularActionPerformed

        String ddd_txt = JOptionPane.showInputDialog(this, "digite o ddd:", "DDD", JOptionPane.INFORMATION_MESSAGE);
        boolean invalido = true;
        for(DDD ddd : listaView.getCidadaoComboBox().getDDDs()){
            if(ddd_txt.equals(ddd.getNumero().toString())){
                dtmCelulares.addRow(new Object[dtmCelulares.getColumnCount()]);
                dtmCelulares.setValueAt(ddd, dtmCelulares.getRowCount() - 1, 0);
                dtmCelulares.setValueAt("", dtmCelulares.getRowCount() - 1, 1);
                invalido = false;
                break;
            }
        }
        if(invalido){
            String mensagem = "O ddd " + ddd_txt + " não é válido!";
            JOptionPane.showMessageDialog(this, mensagem, "DDD Inválido", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonAdicionarCelularActionPerformed

    private void jButtonRemoverCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverCelularActionPerformed
        while (jTableCelulares.getSelectedRowCount() > 0) {
            dtmCelulares.removeRow(jTableCelulares.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonRemoverCelularActionPerformed

    private void jTextFieldNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeCompletoActionPerformed
    }//GEN-LAST:event_jTextFieldNomeCompletoActionPerformed

    private void jComboBoxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCidadeActionPerformed

        atualizarBairros();
        
    }//GEN-LAST:event_jComboBoxCidadeActionPerformed

    private void jComboBoxEstadoUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoUFActionPerformed
        
        atualizarCidades();
        
    }//GEN-LAST:event_jComboBoxEstadoUFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarCelular;
    private javax.swing.JButton jButtonAdicionarTefone;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRemoverCelular;
    private javax.swing.JButton jButtonRemoverTelefone;
    private javax.swing.JButton jButtonSalvar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableCelulares;
    private javax.swing.JTable jTableTelefones;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNomeCompleto;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}
