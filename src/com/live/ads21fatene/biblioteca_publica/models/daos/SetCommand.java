package com.live.ads21fatene.biblioteca_publica.models.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SetCommand {

    void set(PreparedStatement preparedStatement) throws SQLException;
}