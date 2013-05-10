package com.live.adsfatene.biblioteca_publica.models;

/**
 *
 * @author Clairton
 */
public class Estoque {

    private Material material;
    private Integer volumeEstocado;
    private String localLogicoFisico;

    public Material getMaterial() {
        return material;
    }

    public Integer getVolumeEstocado() {
        return volumeEstocado;
    }

    public String getLocalLogicoFisico() {
        return localLogicoFisico;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setVolumeEstocado(Integer volumeEstocado) {
        this.volumeEstocado = volumeEstocado;
    }

    public void setLocalLogicoFisico(String localLogicoFisico) {
        this.localLogicoFisico = localLogicoFisico;
    }
}