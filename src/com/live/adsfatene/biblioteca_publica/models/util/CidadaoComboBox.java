package com.live.adsfatene.biblioteca_publica.models.util;

import com.live.adsfatene.biblioteca_publica.models.Bairro;
import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidade;
import com.live.adsfatene.biblioteca_publica.models.DDD;
import com.live.adsfatene.biblioteca_publica.models.Estado;
import com.live.adsfatene.biblioteca_publica.models.Logradouro;
import com.live.adsfatene.biblioteca_publica.models.Telefone;
import java.util.LinkedList;
import java.util.List;

public class CidadaoComboBox {

    private final List<Logradouro> logradouros;
    private final List<Estado> estados;
    private final List<Bairro> bairros;
    private final List<Cidade> cidadades;
    private final List<Celular> celulares;
    private final List<Telefone> telefones;
    private final List<DDD> ddds;

    public CidadaoComboBox() {
        logradouros = new LinkedList<>();
        estados = new LinkedList<>();
        bairros = new LinkedList<>();
        cidadades = new LinkedList<>();
        celulares = new LinkedList<>();
        telefones = new LinkedList<>();
        ddds = new LinkedList<>();
    }

    public List<Logradouro> getLogradouros() {
        return logradouros;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public List<Cidade> getCidadades() {
        return cidadades;
    }

    public List<Celular> getCelulares() {
        return celulares;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<DDD> getDDDs() {
        return ddds;
    }

}