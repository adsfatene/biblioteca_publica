package com.live.adsfatene.biblioteca_publica.models.daos.cidadaos_dao;

import com.live.adsfatene.biblioteca_publica.models.Bairro;
import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Cidade;
import com.live.adsfatene.biblioteca_publica.models.DDD;
import com.live.adsfatene.biblioteca_publica.models.Estado;
import com.live.adsfatene.biblioteca_publica.models.Telefone;
import com.live.adsfatene.biblioteca_publica.models.daos.CidadaosDao;
import com.live.adsfatene.biblioteca_publica.models.daos.Conexao;
import com.live.adsfatene.biblioteca_publica.models.daos.ConexaoTeste;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CadastrarNovoTest {

    private Conexao conexao;
    private CidadaosDao cidadaosDao;
    private Cidadao cidadao;
    private Estado estado;
    private Cidade cidade;
    private Bairro bairro;
    private List<Telefone> telefones;
    private List<Celular> celulares;
    private List<Cidadao> cidadaos;

    @Before
    public void setUp() {
        conexao = new ConexaoTeste();
        cidadaosDao = new CidadaosDao(conexao);
        cidadaos = new LinkedList<>();
    }

    @After
    public void tearDown() {
        cidadaos.clear();
        conexao.fecharConnection();
    }

    @Test
    public void testSemContatos() {
        for (int i = 0; i < 10; i++) {
            preparaNovoMaterial();
            estado.setCodigo(i + 1);
            cidade.setNome("cidade" + i);
            bairro.setNome("bairro" + i);
            cidadao.setNomeCompleto("nome" + i);
            cidadao.setNumeroImovel(i + 1000);
            cidadao.setLogradouro("logradouro" + i);
            cidadaos.add(cidadao);
            Assert.assertTrue(cidadaosDao.cadastarNovo(cidadao));
        }
    }

    @Test
    public void testComContatos() {
        for (int i = 0; i < 10; i++) {
            preparaNovoMaterial();
            estado.setCodigo(i + 1);
            cidade.setNome("cidade" + i);
            bairro.setNome("bairro" + i);
            cidadao.setNomeCompleto("nome" + i);
            cidadao.setNumeroImovel(i + 1000);
            cidadao.setLogradouro("logradouro" + i);
            Telefone telefone = new Telefone();
            Celular celular = new Celular();
            DDD ddd = new DDD();
            if (i % 2 == 0) {
                ddd.setNumero(88);
            } else {
                ddd.setNumero(85);
            }
            celular.setDDD(ddd);
            telefone.setDDD(ddd);
            celular.setNumero(String.format("%08d", i));
            telefone.setNumero(String.format("%08d", i));
            cidadao.getTelefones().add(telefone);
            cidadao.getCelulares().add(celular);
            cidadaos.add(cidadao);
            Assert.assertTrue(cidadaosDao.cadastarNovo(cidadao));
        }
    }

    private void preparaNovoMaterial() {
        cidadao = new Cidadao();
        estado = new Estado();
        cidade = new Cidade();
        bairro = new Bairro();
        telefones = new LinkedList<>();
        celulares = new LinkedList<>();

        cidadao.setBairro(bairro);
        bairro.setCidade(cidade);
        cidade.setEstado(estado);
        cidadao.setTelefones(telefones);
        cidadao.setCelulares(celulares);
    }

    public Conexao getConexao() {
        return conexao;
    }

    public CidadaosDao getCidadaosDao() {
        return cidadaosDao;
    }

    public List<Cidadao> getCidadaos() {
        return cidadaos;
    }
}