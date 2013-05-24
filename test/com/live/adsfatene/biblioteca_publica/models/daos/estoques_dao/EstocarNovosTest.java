package com.live.adsfatene.biblioteca_publica.models.daos.estoques_dao;

import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.daos.EstoquesDAO;
import com.live.adsfatene.biblioteca_publica.models.daos.materiais_dao.CadastrarNovoTest;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EstocarNovosTest {

    private CadastrarNovoTest cadastrarNovoTest;
    private EstoquesDAO estoquesDAO;

    @Before
    public void setUp() {
        cadastrarNovoTest = new CadastrarNovoTest();
        cadastrarNovoTest.setUp();
        cadastrarNovoTest.testComEditoraCategoriaPublicoFormatosNovos();
        estoquesDAO = new EstoquesDAO(cadastrarNovoTest.getConexao());
    }

    @After
    public void tearDown() {
        cadastrarNovoTest.tearDown();
    }

    @Test
    public void testComMateriaisExistentesNoBanco() {
        Assert.assertTrue(estoquesDAO.estocarNovos(getEstoques()));
    }

    @Test
    public void testComMateriaisNulos() {
        List<Estoque> estoques = null;
        Assert.assertFalse(estoquesDAO.estocarNovos(estoques));
    }

    @Test(expected = RuntimeException.class)
    public void testComMateriaisNaoExistentesNoBanco() {
        List<Estoque> estoques = new LinkedList<>();
        Estoque estoque;
        for (int i = cadastrarNovoTest.getMateriais().size() * -1; i <= 0; i++) {
            estoque = new Estoque();
            estoque.setMaterial(new Material());
            estoque.getMaterial().setCodigo(i);
            estoque.setLocalLogicoFisico("xyz_" + i);
            estoques.add(estoque);
        }
        Assert.assertFalse(estoquesDAO.estocarNovos(estoques));
    }

    public List<Estoque> getEstoques() {
        List<Estoque> estoques = new LinkedList<>();
        Estoque estoque;
        for (int i = 1; i <= cadastrarNovoTest.getMateriais().size(); i++) {
            estoque = new Estoque();
            estoque.setMaterial(new Material());
            estoque.getMaterial().setCodigo(i);
            estoque.setLocalLogicoFisico("xyz_" + i);
            estoques.add(estoque);
        }
        return estoques;
    }

    public EstoquesDAO getEstoquesDAO() {
        return estoquesDAO;
    }
    
    public List<Material> getMateriais(){
        return cadastrarNovoTest.getMateriais();
    }
}
