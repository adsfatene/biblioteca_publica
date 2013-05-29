package com.live.adsfatene.biblioteca_publica.models;

/**
 *
 * @author Clairton
 */
public class EstoqueDanificado {

    private EmprestimoEstoque emprestimoEstoque;
    private String motivo;

    public EmprestimoEstoque getEmprestimoEstoque() {
        return emprestimoEstoque;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setEmprestimoEstoque(EmprestimoEstoque emprestimoEstoque) {
        this.emprestimoEstoque = emprestimoEstoque;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}