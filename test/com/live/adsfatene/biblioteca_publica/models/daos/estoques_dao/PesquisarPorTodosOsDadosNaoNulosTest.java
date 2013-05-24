package com.live.adsfatene.biblioteca_publica.models.daos.estoques_dao;

import com.live.adsfatene.biblioteca_publica.models.DadoMaterial;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.daos.materiais_dao.*;
import com.live.adsfatene.biblioteca_publica.models.Material;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PesquisarPorTodosOsDadosNaoNulosTest {
    
    private EstocarNovosTest estocarNovosTest;
    private Estoque estoque;
    
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
    public void testComTudoNulo() {
        estoque = new Estoque();
        Assert.assertEquals(
                estocarNovosTest.getEstoquesDAO().pesquisarPorTodosOsDadosNaoNulos(estoque).size(),
                estocarNovosTest.getEstoques().size());
    }
    
    @Test
    public void testComSomenteOsCodigosNulos() {
        estoque = estocarNovosTest.getEstoques().get(0);
        estoque.setMaterial(estocarNovosTest.getMateriais().get(0));
        Assert.assertEquals(estocarNovosTest.getEstoquesDAO().pesquisarPorTodosOsDadosNaoNulos(estoque).size(),
                1);
    }
    
    @Test
    public void testComSomenteODadoMaterial() {
        estoque = new Estoque();
        estoque.setMaterial(new Material());
        DadoMaterial dadoMaterial = new DadoMaterial();
        dadoMaterial.setCodigo(1);
        estoque.getMaterial().setDadoMaterial(dadoMaterial);
        Assert.assertEquals(estocarNovosTest.getEstoquesDAO().pesquisarPorTodosOsDadosNaoNulos(estoque).size(),
                estocarNovosTest.getEstoques().size());
    }
    
    @Test
    public void testComSomenteOFormato() {
        estoque = new Estoque();
        estoque.setMaterial(new Material());
        Formato formato = new Formato();
        formato.setCodigo(6);
        estoque.getMaterial().setFormato(formato);
        Assert.assertEquals(estocarNovosTest.getEstoquesDAO().pesquisarPorTodosOsDadosNaoNulos(estoque).size(),
                1);
    }
}