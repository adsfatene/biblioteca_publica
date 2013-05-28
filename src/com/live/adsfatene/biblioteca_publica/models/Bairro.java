package com.live.adsfatene.biblioteca_publica.models;

import java.util.Objects;

public class Bairro {

    private Integer codigo;
    private String nome;
    private Cidade cidade;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome;
    }

    public boolean ehIgual(Bairro bairro) {
        return codigo.equals(bairro.codigo)
                && nome.equalsIgnoreCase(bairro.nome)
                && cidade.ehIgual(bairro.cidade);
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
        final Bairro other = (Bairro) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    public Bairro getClone(){
        Bairro bairro = new Bairro();
        bairro.setCodigo(codigo);
        bairro.setNome(nome);
        return bairro;
    }
}
