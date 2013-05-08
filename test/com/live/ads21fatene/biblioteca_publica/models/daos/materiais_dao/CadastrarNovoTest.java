package com.live.ads21fatene.biblioteca_publica.models.daos.materiais_dao;

import com.live.ads21fatene.biblioteca_publica.models.Categoria;
import com.live.ads21fatene.biblioteca_publica.models.DadoMaterial;
import com.live.ads21fatene.biblioteca_publica.models.Editora;
import com.live.ads21fatene.biblioteca_publica.models.Formato;
import com.live.ads21fatene.biblioteca_publica.models.Material;
import com.live.ads21fatene.biblioteca_publica.models.Publico;
import com.live.ads21fatene.biblioteca_publica.models.daos.Conexao;
import com.live.ads21fatene.biblioteca_publica.models.daos.ConexaoTeste;
import com.live.ads21fatene.biblioteca_publica.models.daos.MateriaisDAO;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CadastrarNovoTest {

    private Conexao conexao;
    private MateriaisDAO materiaisDAO;
    private Material material;
    private DadoMaterial dadoMaterial;
    private Editora editora;
    private Categoria categoria;
    private Publico publico;
    private Formato formato;
    private List<Material> materiais;

    @Before
    public void setUp() {
        conexao = new ConexaoTeste();
        materiaisDAO = new MateriaisDAO(conexao);
        materiais = new LinkedList<>();
    }

    @After
    public void tearDown() {
        materiais.clear();
        conexao.fecharConnection();
    }

    @Test
    public void testComEditoraCategoriaPublicoFormatosNovos() {
        for (int i = 0; i < 10; i++) {
            preparaNovoMaterial();
            dadoMaterial.setTitulo("titulo");
            dadoMaterial.setDescricao("descricao");
            dadoMaterial.setEdicao(1);
            dadoMaterial.setAnoPublicacao(2013);
            dadoMaterial.setAutor("autor");
            editora.setNome("editora");
            categoria.setNome("categoria");
            publico.setNome("publico");
            formato.setNome("formato" + i);
            material.setInformacao("informacao" + i);
            material.setLocalLogicoFisico("localizacao" + i);
            materiais.add(material);
        }
        Assert.assertTrue(materiaisDAO.cadastarNovo(materiais));
    }

    private void preparaNovoMaterial() {
        material = new Material();
        editora = new Editora();
        categoria = new Categoria();
        publico = new Publico();

        dadoMaterial = new DadoMaterial();
        dadoMaterial.setEditora(editora);
        dadoMaterial.setCategoria(categoria);
        dadoMaterial.setPublico(publico);

        material.setDadoMaterial(dadoMaterial);

        formato = new Formato();
        material.setFormato(formato);
    }

    public MateriaisDAO getMateriaisDAO() {
        return materiaisDAO;
    }

    public List<Material> getMateriais() {
        return materiais;
    }
}