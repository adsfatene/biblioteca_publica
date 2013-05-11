package com.live.adsfatene.biblioteca_publica.models;

import java.util.Objects;

public class Edicao implements Comparable<Edicao> {

    private Integer numero;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.numero);
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
        final Edicao other = (Edicao) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numero.toString();
    }

    @Override
    public int compareTo(Edicao categoria) {
        return numero.compareTo(categoria.numero);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    boolean ehIgual(Edicao edicao) {
        return numero.equals(edicao.numero);
    }
}