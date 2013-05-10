package com.live.adsfatene.biblioteca_publica.models.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SetCommand {

    void set(PreparedStatement preparedStatement) throws SQLException;
}