package com.live.adsfatene.biblioteca_publica.models;

import java.util.Objects;

public class Cidade {

    private Integer codigo;
    private String nome;
    private Estado estado;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nome;
    }

    public boolean ehIgual(Cidade cidade) {
        return codigo.equals(cidade.codigo)
                && nome.equalsIgnoreCase(cidade.nome)
                && estado.ehIgual(cidade.estado);
    }

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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    public Cidade getClone() {
        Cidade cidade = new Cidade();
        cidade.setCodigo(codigo);
        cidade.setNome(nome);
        return cidade;
    }
}