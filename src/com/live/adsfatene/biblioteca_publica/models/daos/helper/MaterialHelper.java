package com.live.adsfatene.biblioteca_publica.models.daos.helper;

import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.DadoMaterial;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Publico;
import com.live.adsfatene.biblioteca_publica.models.daos.Conexao;
import com.live.adsfatene.biblioteca_publica.models.daos.ConexaoDesenvolvimento;
import com.live.adsfatene.biblioteca_publica.models.daos.MateriaisDao;
import java.util.LinkedList;
import java.util.List;

public class MaterialHelper {

    public static void main(String[] args) {
        List<Material> materials = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            Material material = new Material();
            material.setInformacao("informacao");
            material.setLocalLogicoFisico("localLogicoFisico");

            DadoMaterial dadoMaterial = new DadoMaterial();
            dadoMaterial.setAnoPublicacao(2013);
            dadoMaterial.setAutor("autor");
            dadoMaterial.setTitulo("titulo");
            dadoMaterial.setDescricao("descricao");
            dadoMaterial.setEdicao(1);

            Categoria categoria = new Categoria();
            categoria.setNome("categoria");

            Publico publico = new Publico();
            publico.setNome("publico");

            Editora editora = new Editora();
            editora.setNome("editora");

            dadoMaterial.setEditora(editora);
            dadoMaterial.setCategoria(categoria);
            dadoMaterial.setPublico(publico);

            material.setDadoMaterial(dadoMaterial);

            Formato formato = new Formato();
            formato.setNome("formato" + i);

            material.setFormato(formato);

            materials.add(material);
        }
        Conexao conexao = new ConexaoDesenvolvimento();
        conexao.destroiBanco();
        MateriaisDao materiaisDao = new MateriaisDao(conexao);
        materiaisDao.cadastarNovos(materials);
        conexao.fecharConnection();
    }
}