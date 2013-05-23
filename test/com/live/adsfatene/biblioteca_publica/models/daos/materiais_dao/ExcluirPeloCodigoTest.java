package com.live.adsfatene.biblioteca_publica.models.daos.materiais_dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcluirPeloCodigoTest {

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
        Assert.assertTrue(cadastrarNovoTest.getMateriaisDAO().excluirPeloCodigo(1));
    }

    @Test
    public void testComCodigoNulo() {
        Assert.assertFalse(cadastrarNovoTest.getMateriaisDAO().excluirPeloCodigo(null));
    }

    @Test
    public void testComCodigoNaoExistenteNoBanco() {
        Assert.assertFalse(cadastrarNovoTest.getMateriaisDAO().excluirPeloCodigo(0));
    }
}