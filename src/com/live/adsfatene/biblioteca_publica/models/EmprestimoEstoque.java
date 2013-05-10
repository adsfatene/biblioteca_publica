package com.live.adsfatene.biblioteca_publica.models;

public class EmprestimoEstoque {

    private Integer codigo;
    private Emprestimo emprestimo;
    private Estoque estoque;

    public Integer getCodigo() {
        return codigo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public Estoque getEstoque() {
        return estoque;
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
}
