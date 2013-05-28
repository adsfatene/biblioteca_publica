package com.live.adsfatene.biblioteca_publica.models.daos.helper;

import com.live.adsfatene.biblioteca_publica.models.daos.Conexao;
import com.live.adsfatene.biblioteca_publica.models.daos.ConexaoDesenvolvimento;

/**
 *
 * @author MJ
 */
public class AplicacaoHelper {

    public static void main(String[] args) {
        Conexao conexao = new ConexaoDesenvolvimento();
        conexao.destroiBanco();
        new CidadaoHelper().gerar(conexao);
        new MaterialHelper().gerar(conexao);
        conexao.fecharConnection();
    }
}