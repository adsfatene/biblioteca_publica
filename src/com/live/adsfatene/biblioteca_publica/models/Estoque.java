package com.live.adsfatene.biblioteca_publica.models;

/**
 *
 * @author Clairton
 */
public class Estoque {

    private Material material;
    private String statu;
    private String localLogicoFisico;

    public Material getMaterial() {
        return material;
    }

    public String getStatu() {
        return statu;
    }

    public String getLocalLogicoFisico() {
        return localLogicoFisico;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public void setLocalLogicoFisico(String localLogicoFisico) {
        this.localLogicoFisico = localLogicoFisico;
    }
}