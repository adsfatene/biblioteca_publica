package com.live.adsfatene.biblioteca_publica.models.daos.materiais_dao;

import com.live.adsfatene.biblioteca_publica.models.Material;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PesquisarPorTodosOsDadosNaoNulosTest {

    private CadastrarNovoTest cadastarNovoTest;
    private Material material;

    @Before
    public void setUp() {
        cadastarNovoTest = new CadastrarNovoTest();
        cadastarNovoTest.setUp();
        cadastarNovoTest.testComEditoraCategoriaPublicoFormatosNovos();
    }

    @After
    public void tearDown() {
        cadastarNovoTest.tearDown();
    }

    @Test
    public void testComTudoNulo() {
        material = new Material();
        Assert.assertEquals(
                cadastarNovoTest.getMateriaisDAO().pesquisarPorTodosOsDadosNaoNulos(material).size(),
                cadastarNovoTest.getMateriais().size());
    }

    @Test
    public void testComSomenteOsCodigosNulos() {
        material = cadastarNovoTest.getMateriais().get(0);
        Assert.assertEquals(cadastarNovoTest.getMateriaisDAO().pesquisarPorTodosOsDadosNaoNulos(material).size(),
                1);
    }

    @Test
    public void testComSomenteODadoMaterial() {
        material = new Material();
        material.setDadoMaterial(cadastarNovoTest.getMateriais().get(0).getDadoMaterial());
        Assert.assertEquals(cadastarNovoTest.getMateriaisDAO().pesquisarPorTodosOsDadosNaoNulos(material).size(),
                cadastarNovoTest.getMateriais().size());
    }

    @Test
    public void testComSomenteOFormato() {
        material = new Material();
        material.setFormato(cadastarNovoTest.getMateriais().get(0).getFormato());
        Assert.assertEquals(cadastarNovoTest.getMateriaisDAO().pesquisarPorTodosOsDadosNaoNulos(material).size(),
                1);
    }
}