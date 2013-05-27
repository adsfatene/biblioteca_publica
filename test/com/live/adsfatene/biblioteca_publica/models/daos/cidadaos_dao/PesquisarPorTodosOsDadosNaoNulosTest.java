package com.live.adsfatene.biblioteca_publica.models.daos.cidadaos_dao;

import com.live.adsfatene.biblioteca_publica.models.Bairro;
import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Cidade;
import com.live.adsfatene.biblioteca_publica.models.Estado;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PesquisarPorTodosOsDadosNaoNulosTest {

    private CadastrarNovoTest cadastarNovoTest;
    private Cidadao cidadao;

    @Before
    public void setUp() {
        cadastarNovoTest = new CadastrarNovoTest();
        cadastarNovoTest.setUp();
        cadastarNovoTest.testComContatos();
    }

    @After
    public void tearDown() {
        cadastarNovoTest.tearDown();
    }

    @Test
    public void testComTudoNulo() {
        cidadao = new Cidadao();
        Assert.assertEquals(
                cadastarNovoTest.getCidadaosDao().pesquisarPorTodosOsDadosNaoNulos(cidadao).size(),
                cadastarNovoTest.getCidadaos().size());
    }
    @Test
    public void testComSomenteOsCodigosNulos() {
        cidadao = cadastarNovoTest.getCidadaos().get(0);
        cidadao.setCelulares(new LinkedList<Celular>());
        Assert.assertEquals(cadastarNovoTest.getCidadaosDao().pesquisarPorTodosOsDadosNaoNulos(cidadao).size(),
                1);
    }
        @Test
    public void testComSomenteOBairro() {
        cidadao = new Cidadao();
        cidadao.setBairro(new Bairro());
        cidadao.getBairro().setCodigo(3);
        Assert.assertEquals(cadastarNovoTest.getCidadaosDao().pesquisarPorTodosOsDadosNaoNulos(cidadao).size(),
                1);
    }
    @Test
    public void testComSomenteACidade() {
        cidadao = new Cidadao();
        cidadao.setBairro(new Bairro());
        cidadao.getBairro().setCidade(new Cidade());
        cidadao.getBairro().getCidade().setCodigo(3);
        Assert.assertEquals(cadastarNovoTest.getCidadaosDao().pesquisarPorTodosOsDadosNaoNulos(cidadao).size(),
                1);
    }

    @Test
    public void testComSomenteOEstado() {
        cidadao = new Cidadao();
        cidadao.setBairro(new Bairro());
        cidadao.getBairro().setCidade(new Cidade());
        cidadao.getBairro().getCidade().setEstado(new Estado());
        cidadao.getBairro().getCidade().getEstado().setCodigo(1);
        Assert.assertEquals(cadastarNovoTest.getCidadaosDao().pesquisarPorTodosOsDadosNaoNulos(cidadao).size(),
                1);
    }
}