package com.live.adsfatene.biblioteca_publica.models.daos.cidadaos_dao;

import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Telefone;
import java.util.LinkedList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtualizarPorTodosOsDadosTest {

    private CadastrarNovoTest cadastrarNovoTest;
    private Cidadao cidadao;

    @Before
    public void setUp() {
        cadastrarNovoTest = new CadastrarNovoTest();
        cadastrarNovoTest.setUp();
        cadastrarNovoTest.testComContatos();
        cidadao = cadastrarNovoTest.getCidadaos().get(0);
    }

    @After
    public void tearDown() {
        cadastrarNovoTest.tearDown();
    }

    @Test
    public void testComLogradouroNomeCompletoNumeroImovelBairroCidadeTelefoneCelularNovos() {
        cidadao.setCodigo(1);
        cidadao.setLogradouro("logradouro_novo");
        cidadao.setNomeCompleto("nome_novo");
        cidadao.setNumeroImovel(9999);
        Telefone telefone = cidadao.getTelefones().get(0);
        telefone.setNumero("11111111");
        telefone.setCidadao(cidadao);
        Celular celular = cidadao.getCelulares().get(0);
        celular.setNumero("22222222");
        celular.setCidadao(cidadao);
        cidadao.getBairro().setNome("bairro_novo");
        cidadao.getBairro().getCidade().setNome("cidade_nova");
        Assert.assertTrue(cadastrarNovoTest.getCidadaosDao().atualizarPorTodosOsDados(cidadao));
    }

    @Test
    public void testComBairroCidadeEstadoExistentes() {
        cidadao.setCodigo(1);
        cidadao.getBairro().getCidade().getEstado().setCodigo(1);
        cidadao.getBairro().getCidade().setCodigo(1);
        cidadao.getBairro().setNome("bairro_novo");
        cidadao.setTelefones(new LinkedList<Telefone>());
        cidadao.setCelulares(new LinkedList<Celular>());
        Assert.assertTrue(cadastrarNovoTest.getCidadaosDao().atualizarPorTodosOsDados(cidadao));
    }
}