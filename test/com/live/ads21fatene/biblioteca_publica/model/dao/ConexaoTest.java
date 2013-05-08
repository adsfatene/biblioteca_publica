package com.live.ads21fatene.biblioteca_publica.model.dao;

import com.live.ads21fatene.biblioteca_publica.models.daos.Conexao;
import com.live.ads21fatene.biblioteca_publica.models.daos.ConexaoProducao;
import com.live.ads21fatene.biblioteca_publica.models.daos.ConexaoDesenvolvimento;
import com.live.ads21fatene.biblioteca_publica.models.daos.ConexaoTeste;
import java.sql.SQLException;
import org.junit.Test;

public class ConexaoTest {

    private Conexao conexao;

    @Test
    public void conexaoProducao() throws SQLException {
        conexao = new ConexaoProducao();
        conexao.destroiBanco();
        conexao.getConnection().close();
    }

    @Test
    public void conexaoDesenvolvimento() throws SQLException {
        conexao = new ConexaoDesenvolvimento();
        conexao.destroiBanco();
        conexao.getConnection().close();
    }

    @Test
    public void conexaoTeste() throws SQLException {
        conexao = new ConexaoTeste();
        conexao.getConnection().close();
    }
}