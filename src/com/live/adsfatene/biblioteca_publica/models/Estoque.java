package com.live.adsfatene.biblioteca_publica.models;

/**
 *
 * @author Clairton
 */
public class Estoque {

    private Material material;
    private Statu statu;
    private String localLogicoFisico;

    public Material getMaterial() {
        return material;
    }

    public Statu getStatu() {
        return statu;
    }

    public String getLocalLogicoFisico() {
        return localLogicoFisico;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setStatu(Statu statu) {
        this.statu = statu;
    }

    public void setLocalLogicoFisico(String localLogicoFisico) {
        this.localLogicoFisico = localLogicoFisico;
    }

    public boolean ehIgual(Estoque estoque) {
        return material.ehIgual(estoque.material)
                && statu.ehIgual(estoque.statu)
                && localLogicoFisico.equals(estoque.localLogicoFisico);
    }
}