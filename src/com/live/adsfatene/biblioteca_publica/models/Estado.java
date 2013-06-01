package com.live.adsfatene.biblioteca_publica.models;

import java.util.Objects;

public class Estado {

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    private Integer codigo;
    private String nome;
    private String uf;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return uf;
    }

    boolean ehIgual(Estado estado) {
        return codigo.equals(estado.codigo)
                && nome.equalsIgnoreCase(estado.nome)
                && uf.equalsIgnoreCase(estado.uf);
    }
}