package com.live.ads21fatene.biblioteca_publica.models.daos.materiais_dao;

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
        cadastrarNovoTest.testComEditoraCategoriaPublicoFormatosNovos();
    }

    @After
    public void tearDown() {
        cadastrarNovoTest.tearDown();
    }

    @Test
    public void testComCodigoExistenteNoBanco() {
        Assert.assertNotNull(cadastrarNovoTest.getMateriaisDAO().buscarPeloCodigo(1));
    }

    @Test
    public void testComCodigoNulo() {
        Assert.assertNull(cadastrarNovoTest.getMateriaisDAO().buscarPeloCodigo(null));
    }

    @Test
    public void testComCodigoNaoExistenteNoBanco() {
        Assert.assertNull(cadastrarNovoTest.getMateriaisDAO().buscarPeloCodigo(0));
    }
}