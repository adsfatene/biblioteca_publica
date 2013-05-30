package com.live.adsfatene.biblioteca_publica.models;

public class EmprestimoEstoque {

    private Integer codigo;
    private Emprestimo emprestimo;
    private Estoque estoque;
    private String estadoDevolucao;
    private String motivo;

    public Integer getCodigo() {
        return codigo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public String getEstadoDevolucao() {
        return estadoDevolucao;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void setEstadoDevolucao(String estadoDevolucao) {
        this.estadoDevolucao = estadoDevolucao;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
