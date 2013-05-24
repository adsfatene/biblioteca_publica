package com.live.adsfatene.biblioteca_publica.models;

import java.util.Objects;

public class Statu implements Comparable<Statu> {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Statu statu) {
        return nome.compareTo(statu.nome);
    }

    boolean ehIgual(Statu statu) {
        return nome.equals(statu.nome);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
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
        final Statu other = (Statu) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}