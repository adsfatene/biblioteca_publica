package com.live.adsfatene.biblioteca_publica.models.daos;

import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.EmprestimoIrrecuperavel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EstoquesDAO {

    private final Conexao conexao;
    private final Map<String, String> comandos;

    public EstoquesDAO(Conexao conexao) {
        this.conexao = conexao;
        comandos = new LinkedHashMap<>();
        List<String> linhas = conexao.carregaSQL("prepareds_statements/estoques");
        for (int chave = 0, valor = 1; valor < linhas.size(); chave = valor + 1, valor = chave + 1) {
            comandos.put(linhas.get(chave), linhas.get(valor));
        }
        linhas.clear();
    }

    public Boolean estocarNovos(List<Estoque> estoques) {
        Boolean sucesso = false;
        if (estoques != null) {
            Connection connection = conexao.getConnection();
            try {
                String valorDoComandoUm = comandos.get("estocarNovos" + 1);
                String valorDoComandoDois = comandos.get("estocarNovos" + 2);
                StringBuilder query = new StringBuilder(valorDoComandoUm);
                for (int i = 0; i < estoques.size(); i++) {
                    query.append("\n").append(valorDoComandoDois);
                }
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
                query.delete(0, query.length());
                int indice = 1;
                for (Estoque estoque : estoques) {
                    preparedStatement.setInt(indice++, estoque.getMaterial().getCodigo());
                    preparedStatement.setString(indice++, estoque.getLocalLogicoFisico());
                }
                preparedStatement.execute();
                connection.commit();
                connection.setAutoCommit(true);
                sucesso = true;
            } catch (SQLException ex) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                }
                throw new RuntimeException(ex.getMessage());
            } catch (NullPointerException ex) {
                throw new RuntimeException(ex.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            } finally {
                conexao.fecharConnection();
            }
        }
        return sucesso;
    }

    public Boolean aumentar(Estoque estoque, Integer volumeAdicional) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean moverVolumeDeMaterialEstocadoParaEstoquesIrrecuperavel(EmprestimoIrrecuperavel estoqueIrrecuperavel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Estoque> pesquisarPorTodosOsDadosNaoNulos(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
