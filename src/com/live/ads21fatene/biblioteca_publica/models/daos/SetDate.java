package com.live.ads21fatene.biblioteca_publica.models.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class SetDate implements SetCommand {

    private Integer posicao;
    private Calendar valor;

    public SetDate(Integer posicao, Calendar valor) {
        this.posicao = posicao;
        this.valor = valor;
    }

    @Override
    public void set(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setDate(posicao, new Date(valor.getTimeInMillis()));
    }
}
