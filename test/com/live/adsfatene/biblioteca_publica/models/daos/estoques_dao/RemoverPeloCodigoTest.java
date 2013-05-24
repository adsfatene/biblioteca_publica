package com.live.adsfatene.biblioteca_publica.models.daos.estoques_dao;

import com.live.adsfatene.biblioteca_publica.models.daos.materiais_dao.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoverPeloCodigoTest {

    private EstocarNovosTest estocarNovosTest;

    @Before
    public void setUp() {
        estocarNovosTest = new EstocarNovosTest();
        estocarNovosTest.setUp();
        estocarNovosTest.testComMateriaisExistentesNoBanco();
    }

    @After
    public void tearDown() {
        estocarNovosTest.tearDown();
    }

    @Test
    public void testComCodigoExistenteNoBanco() {
        Assert.assertTrue(estocarNovosTest.getEstoquesDAO().removerPeloCodigo(1));
    }

    @Test
    public void testComCodigoNulo() {
        Assert.assertFalse(estocarNovosTest.getEstoquesDAO().removerPeloCodigo(null));
    }

    @Test
    public void testComCodigoNaoExistenteNoBanco() {
        Assert.assertFalse(estocarNovosTest.getEstoquesDAO().removerPeloCodigo(0));
    }
}