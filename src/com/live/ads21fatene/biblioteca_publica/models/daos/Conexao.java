package com.live.ads21fatene.biblioteca_publica.models.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Conexao {

    private String banco;
    private Connection connection;
    private final String host = "jdbc:sqlserver://localhost:1433";
    private final String user = "usuario";
    private final String password = "senha";
    private final List<String> preparaBanco;

    public Conexao() {
        banco = "biblioteca_publica_" + this.getClass().getSimpleName().toLowerCase().substring("conexao".length());
        preparaBanco = new LinkedList<>();
        preparaBanco.add("CREATE DATABASE " + banco);
        preparaBanco.add("USE " + banco);
        preparaBanco.addAll(carregaSQL("data_base"));
        preparaBanco.addAll(carregaSQL("views"));
        preparaBanco.addAll(carregaSQL("procedures"));
        preparaBanco.addAll(carregaSQL("dados_iniciais"));
    }

    public final List<String> carregaSQL(String nome) {
        List<String> sqls = new LinkedList<>();
        try {
            List<BufferedReader> brs = carregaArquivos("lib/sqls/" + nome);
            StringBuilder sb = new StringBuilder();
            while (!brs.isEmpty()) {
                BufferedReader br = brs.remove(0);
                while (br.ready()) {
                    sb.append(br.readLine());
                }
                br.close();
            }
            String[] sql = sb.toString().split(";");
            sb.delete(0, sb.length());
            sqls.addAll(Arrays.asList(Arrays.copyOf(sql, sql.length)));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return sqls;
    }

    private final List<BufferedReader> carregaArquivos(String nomeDiretorio) throws FileNotFoundException {
        List<BufferedReader> arquivos = new LinkedList<>();
        for (File f : new File(nomeDiretorio).listFiles()) {
            arquivos.add(
                    new BufferedReader(
                    new FileReader(f)));
        }
        return arquivos;
    }

    public final Connection getConnection() {
        abrirConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute("USE " + banco);
        } catch (SQLException ex) {
            for (String comando : preparaBanco) {
                try {
                    stmt.execute(comando);
                } catch (SQLException ex1) {
                    throw new RuntimeException(ex1.getMessage() + ": " + comando);
                }
            }
        }
        return connection;
    }

    private void abrirConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(host, user, password);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public final void destroiBanco() {
        abrirConnection();
        try {
            connection.createStatement().execute("USE master");
            connection.createStatement().execute("DROP DATABASE " + banco);
        } catch (SQLException ex) {
        }
        fecharConnection();
    }

    public void fecharConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }
}