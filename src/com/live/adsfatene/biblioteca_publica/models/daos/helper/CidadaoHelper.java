package com.live.adsfatene.biblioteca_publica.models.daos.helper;

import com.live.adsfatene.biblioteca_publica.models.Bairro;
import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Cidade;
import com.live.adsfatene.biblioteca_publica.models.DDD;
import com.live.adsfatene.biblioteca_publica.models.Estado;
import com.live.adsfatene.biblioteca_publica.models.Telefone;
import com.live.adsfatene.biblioteca_publica.models.daos.CidadaosDao;
import com.live.adsfatene.biblioteca_publica.models.daos.Conexao;
import java.util.LinkedList;

public class CidadaoHelper {

    public void gerar(Conexao conexao) {
        CidadaosDao cidadaosDao = new CidadaosDao(conexao);

        for (int i = 0; i < 100; i++) {
            Cidadao cidadao = new Cidadao();

            cidadao.setLogradouro("logradouro" + i);
            cidadao.setNomeCompleto("nome_completo" + i);
            cidadao.setNumeroImovel(1000 + i);

            Bairro bairro = new Bairro();
            bairro.setCodigo((i % 2) + 1);

            cidadao.setBairro(bairro);
            cidadao.getBairro().setCidade(new Cidade());
            cidadao.getBairro().getCidade().setEstado(new Estado());
            cidadao.setTelefones(new LinkedList<Telefone>());
            cidadao.setCelulares(new LinkedList<Celular>());


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

            cidadaosDao.cadastarNovo(cidadao);
        }
    }
}