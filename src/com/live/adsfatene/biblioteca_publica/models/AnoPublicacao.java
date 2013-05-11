package com.live.adsfatene.biblioteca_publica.models;

import java.util.Objects;

public class AnoPublicacao implements Comparable<AnoPublicacao> {

    private Integer ano;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.ano);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnoPublicacao other = (AnoPublicacao) obj;
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ano.toString();
    }

    @Override
    public int compareTo(AnoPublicacao categoria) {
        return ano.compareTo(categoria.ano);
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    boolean ehIgual(AnoPublicacao anoPublicacao) {
        return ano.equals(anoPublicacao.ano);
    }
}
