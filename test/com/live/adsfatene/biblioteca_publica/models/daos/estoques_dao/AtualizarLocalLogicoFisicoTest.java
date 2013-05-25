package com.live.adsfatene.biblioteca_publica.models.daos.estoques_dao;

import com.live.adsfatene.biblioteca_publica.models.Estoque;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtualizarLocalLogicoFisicoTest {

    private EstocarNovosTest estocarNovoTest;
    private Estoque estoque;

    @Before
    public void setUp() {
        estocarNovoTest = new EstocarNovosTest();
        estocarNovoTest.setUp();
        estocarNovoTest.testComMateriaisExistentesNoBanco();
        estoque = estocarNovoTest.getEstoques().get(0);
    }

    @After
    public void tearDown() {
        estocarNovoTest.tearDown();
    }

    @Test
    public void testComEstoqueExistente() {
        estoque.setLocalLogicoFisico("local_logico_fisico_novo");
        Assert.assertTrue(estocarNovoTest.getEstoquesDAO().atualizarLocalLogicoFisico(estoque));
    }

    @Test
    public void testComEstoqueNaoExistente() {
        estoque.getMaterial().setCodigo(0);
        estoque.setLocalLogicoFisico("local_logico_fisico_novo");
        Assert.assertFalse(estocarNovoTest.getEstoquesDAO().atualizarLocalLogicoFisico(estoque));
    }
}