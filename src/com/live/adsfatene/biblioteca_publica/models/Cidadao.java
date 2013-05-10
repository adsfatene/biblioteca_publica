package com.live.adsfatene.biblioteca_publica.models;

import java.util.List;

/**
 *
 * @author Clairton
 */
public class Cidadao {

    private Integer codigo;
    private String nomeCompleto;
    private String logradouro;
    private Integer numeroImovel;
    private Bairro bairro;
    private List<Telefone> telefones;
    private List<Celular> celulares;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumeroImovel() {
        return numeroImovel;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Celular> getCelulares() {
        return celulares;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumeroImovel(Integer numeroImovel) {
        this.numeroImovel = numeroImovel;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setCelulares(List<Celular> celulares) {
        this.celulares = celulares;
    }
}