package com.live.adsfatene.biblioteca_publica.models.daos.cidadaos_dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuscarPeloCodigoTest {

    private CadastrarNovoTest cadastrarNovoTest;

    @Before
    public void setUp() {
        cadastrarNovoTest = new CadastrarNovoTest();
        cadastrarNovoTest.setUp();
        cadastrarNovoTest.testComContatos();
    }

    @After
    public void tearDown() {
        cadastrarNovoTest.tearDown();
    }

    @Test
    public void testComCodigoExistenteNoBanco() {
        Assert.assertNotNull(cadastrarNovoTest.getCidadaosDao().buscarPeloCodigo(1));
    }

    @Test
    public void testComCodigoNulo() {
        Assert.assertNull(cadastrarNovoTest.getCidadaosDao().buscarPeloCodigo(null));
    }

    @Test
    public void testComCodigoNaoExistenteNoBanco() {
        Assert.assertNull(cadastrarNovoTest.getCidadaosDao().buscarPeloCodigo(0));
    }
}