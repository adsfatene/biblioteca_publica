package com.live.adsfatene.biblioteca_publica.models.daos.estoques_dao;

import com.live.adsfatene.biblioteca_publica.models.daos.materiais_dao.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuscarPeloCodigoTest {

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
        Assert.assertNotNull(estocarNovosTest.getEstoquesDAO().buscarPeloCodigo(1));
    }

    @Test
    public void testComCodigoNulo() {
        Assert.assertNull(estocarNovosTest.getEstoquesDAO().buscarPeloCodigo(null));
    }

    @Test
    public void testComCodigoNaoExistenteNoBanco() {
        Assert.assertNull(estocarNovosTest.getEstoquesDAO().buscarPeloCodigo(0));
    }
}