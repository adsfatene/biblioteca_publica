package com.live.adsfatene.biblioteca_publica.models.daos.materiais_dao;

import com.live.adsfatene.biblioteca_publica.models.Material;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtualizarPorTodosOsDadosTest {

    private CadastrarNovoTest cadastrarNovoTest;
    private Material material;

    @Before
    public void setUp() {
        cadastrarNovoTest = new CadastrarNovoTest();
        cadastrarNovoTest.setUp();
        cadastrarNovoTest.testComEditoraCategoriaPublicoFormatosNovos();
        material = cadastrarNovoTest.getMateriais().get(0);
    }

    @After
    public void tearDown() {
        cadastrarNovoTest.tearDown();
    }

    @Test
    public void testComEditoraCategoriaPublicoFormatoNovos() {
        material.setCodigo(1);
        material.getFormato().setNome("formato_nova");
        material.getDadoMaterial().setCodigo(1);
        material.getDadoMaterial().getEditora().setNome("editora_novo");
        material.getDadoMaterial().getCategoria().setNome("categoria_novo");
        material.getDadoMaterial().getPublico().setNome("publico_novo");
        Assert.assertTrue(cadastrarNovoTest.getMateriaisDAO().atualizarPorTodosOsDados(material));
    }

    @Test
    public void testComEditoraCategoriaPublicoFormatoExistentes() {
        material.setCodigo(1);
        material.getFormato().setCodigo(1);
        material.getDadoMaterial().setCodigo(1);
        material.getDadoMaterial().getEditora().setCodigo(1);
        material.getDadoMaterial().getCategoria().setCodigo(1);
        material.getDadoMaterial().getPublico().setCodigo(1);
        Assert.assertTrue(cadastrarNovoTest.getMateriaisDAO().atualizarPorTodosOsDados(material));
    }
}