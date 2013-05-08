package com.live.ads21fatene.biblioteca_publica.models.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetInt implements SetCommand {

    private Integer posicao;
    private Integer valor;

    public SetInt(Integer posicao, Integer valor) {
        this.posicao = posicao;
        this.valor = valor;
    }

    @Override
    public void set(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(posicao, valor);
    }
}
