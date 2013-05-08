package com.live.ads21fatene.biblioteca_publica.models;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Clairton
 */
public class Emprestimo {

    private Integer codigo;
    private Cidadao cidadao;
    private Calendar dataHoraEmprestato;
    private Calendar dataHoraDevolucaoPrevista;
    private Calendar dataHoraDevolucaoEfetiva;
    private String estadoDevolucao;
    private List<EmprestimoEstoque> emprestimosEstoques;

    public Integer getCodigo() {
        return codigo;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public Calendar getDataHoraEmprestato() {
        return dataHoraEmprestato;
    }

    public Calendar getDataHoraDevolucaoPrevista() {
        return dataHoraDevolucaoPrevista;
    }

    public Calendar getDataHoraDevolucaoEfetiva() {
        return dataHoraDevolucaoEfetiva;
    }

    public String getEstadoDevolucao() {
        return estadoDevolucao;
    }

    public List<EmprestimoEstoque> getEmprestimosEstoques() {
        return emprestimosEstoques;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public void setDataHoraEmprestato(Calendar dataHoraEmprestato) {
        this.dataHoraEmprestato = dataHoraEmprestato;
    }

    public void setDataHoraDevolucaoPrevista(Calendar dataHoraDevolucaoPrevista) {
        this.dataHoraDevolucaoPrevista = dataHoraDevolucaoPrevista;
    }

    public void setDataHoraDevolucaoEfetiva(Calendar dataHoraDevolucaoEfetiva) {
        this.dataHoraDevolucaoEfetiva = dataHoraDevolucaoEfetiva;
    }

    public void setEstadoDevolucao(String estadoDevolucao) {
        this.estadoDevolucao = estadoDevolucao;
    }

    public void setEmprestimosEstoques(List<EmprestimoEstoque> emprestimosEstoques) {
        this.emprestimosEstoques = emprestimosEstoques;
    }
}
