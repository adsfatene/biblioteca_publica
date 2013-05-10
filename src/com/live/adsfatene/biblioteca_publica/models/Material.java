package com.live.adsfatene.biblioteca_publica.models;

import java.util.Calendar;

/**
 *
 * @author Clairton
 */
public class Material {

    private Integer codigo;
    private DadoMaterial dadoMaterial;
    private Formato formato;
    private Calendar dataHoraCadastro;
    private String informacao;
    private String localLogicoFisico;

    public Integer getCodigo() {
        return codigo;
    }

    public DadoMaterial getDadoMaterial() {
        return dadoMaterial;
    }

    public Formato getFormato() {
        return formato;
    }

    public Calendar getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public String getInformacao() {
        return informacao;
    }

    public String getLocalLogicoFisico() {
        return localLogicoFisico;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setDadoMaterial(DadoMaterial dadoMaterial) {
        this.dadoMaterial = dadoMaterial;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public void setDataHoraCadastro(Calendar dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public void setLocalLogicoFisico(String localLogicoFisico) {
        this.localLogicoFisico = localLogicoFisico;
    }

    @Override
    public String toString() {
        return String.format("material_codigo: %d\nmaterial_informacao: %s\nmaterial_local_logico_fisico: %s"
                + "\nmaterial_formato_codigo: %d\nmaterial_formato_nome: %s"
                + "\nmaterial_dado_material_codigo: %d"
                + "\nmaterial_dado_material_titulo: %s"
                + "\nmaterial_dado_material_descricao: %s"
                + "\nmaterial_dado_material_edicao: %d"
                + "\nmaterial_dado_material_ano_publicacao: %d"
                + "\nmaterial_dado_material_autor: %s"
                + "\nmaterial_dado_material_editora_codigo: %d"
                + "\nmaterial_dado_material_editora_nome: %s"
                + "\nmaterial_dado_material_categoria_codigo: %d"
                + "\nmaterial_dado_material_categoria_nome: %s"
                + "\nmaterial_dado_material_publico_codigo: %d"
                + "\nmaterial_dado_material_publico_nome: %s"
                ,codigo,informacao,localLogicoFisico,formato.getCodigo(), formato.getNome(),
                dadoMaterial.getCodigo(), dadoMaterial.getTitulo(), dadoMaterial.getDescricao(),
                dadoMaterial.getEdicao(), dadoMaterial.getAnoPublicacao(), dadoMaterial.getAutor(),
                dadoMaterial.getEditora().getCodigo(), dadoMaterial.getEditora().getNome(),
                dadoMaterial.getCategoria().getCodigo(), dadoMaterial.getCategoria().getNome(),
                dadoMaterial.getPublico().getCodigo(), dadoMaterial.getPublico().getNome()
                );
    }
}