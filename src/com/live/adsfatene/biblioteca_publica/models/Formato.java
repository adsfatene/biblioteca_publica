package com.live.adsfatene.biblioteca_publica.models;

import java.util.Objects;

public class Formato implements Comparable<Formato> {

    private Integer codigo;
    private String nome;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final Formato other = (Formato) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Formato formato) {
        return nome.compareTo(formato.nome);
    }

    boolean ehIgual(Formato formato) {
        return codigo.equals(formato.codigo)
                && nome.equals(formato.nome);
    }
}
