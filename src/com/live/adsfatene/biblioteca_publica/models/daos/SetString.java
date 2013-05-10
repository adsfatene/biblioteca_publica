package com.live.adsfatene.biblioteca_publica.models.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetString implements SetCommand {

    private Integer posicao;
    private String valor;

    public SetString(Integer posicao, String valor) {
        this.posicao = posicao;
        this.valor = valor;
    }

    @Override
    public void set(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(posicao, valor);
    }
}
