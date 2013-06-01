package com.live.adsfatene.biblioteca_publica.models.daos;

import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.EmprestimoEstoque;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Clairton
 */
public class DanificadosDAO {

    private final Conexao conexao;
    private final Map<String, String> comandos;

    public DanificadosDAO(Conexao conexao) {
        this.conexao = conexao;
        comandos = new LinkedHashMap<>();
        List<String> linhas = conexao.carregaSQL("prepareds_statements/danificados");
        for (int chave = 0, valor = 1; valor < linhas.size(); chave = valor + 1, valor = chave + 1) {
            comandos.put(linhas.get(chave), linhas.get(valor));
        }
        linhas.clear();
    }

    public List<EmprestimoEstoque> pesquisarPorTodosOsDadosNaoNulos(EmprestimoEstoque emprestimoEstoque) {
        List<EmprestimoEstoque> emprestimosEstoques = new LinkedList<>();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 1);
            String valorDoComandoDois = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 2);
            List<String> where = new LinkedList<>();
            List<SetCommand> setCommands = new LinkedList<>();

            if (emprestimoEstoque.getCodigo() != null) {
                where.add("emprestimo_emprestimo_estoque_codigo = ?");
                setCommands.add(new SetInt(where.size(), emprestimoEstoque.getCodigo()));
            }
            if (emprestimoEstoque.getEstadoDevolucao() != null) {
                where.add("LOWER(emprestimo_emprestimo_estoque) = ? ");
                setCommands.add(new SetString(where.size(), "%" + emprestimoEstoque.getEstadoDevolucao().toLowerCase() + "%"));
            }

            StringBuilder query = new StringBuilder(valorDoComandoUm);
            if (!where.isEmpty()) {
                query.append(" WHERE ").append(where.remove(0));
                while (!where.isEmpty()) {
                    query.append(" AND ").append(where.remove(0));
                }
            }
            query.append(valorDoComandoDois);

            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());

            while (!setCommands.isEmpty()) {
                setCommands.remove(0).set(preparedStatement);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setCodigo(resultSet.getInt("emprestimo_codigo"));
                emprestimoEstoque = new EmprestimoEstoque();
                emprestimoEstoque.setEmprestimo(emprestimo);
                emprestimoEstoque.setEstadoDevolucao(resultSet.getString("emprestimo_emprestimo_estoque_estado_devolucao"));
                emprestimoEstoque.setMotivo(resultSet.getString("emprestimo_emprestimo_estoque_motivo"));
                emprestimoEstoque.setCodigo(resultSet.getInt("emprestimo_emprestimo_estoque_codigo"));
                emprestimoEstoque.setEstoque(new Estoque());
                emprestimoEstoque.getEstoque().setMaterial(new Material());
                emprestimoEstoque.getEstoque().getMaterial().setCodigo(resultSet.getInt("emprestimo_estoque_material_codigo"));
                emprestimosEstoques.add(emprestimoEstoque);
            }
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
            }
            throw new RuntimeException(ex.getMessage());
        } catch (NullPointerException ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            conexao.fecharConnection();
        }
        return emprestimosEstoques;
    }

    public EmprestimoEstoque buscarPeloCodigo(Integer codigo) {
        EmprestimoEstoque emprestimoEstoque = null;
        if (codigo != null) {
            emprestimoEstoque = new EmprestimoEstoque();
            emprestimoEstoque.setCodigo(codigo);
            List<EmprestimoEstoque> emprestimosEstoques = pesquisarPorTodosOsDadosNaoNulos(emprestimoEstoque);
            if (!emprestimosEstoques.isEmpty()) {
                emprestimoEstoque = emprestimosEstoques.remove(0);
            } else {
                emprestimoEstoque = null;
            }
        }
        return emprestimoEstoque;
    }

    public Boolean restaurar(Integer codigo) {
       boolean sucesso = false;
        if (codigo != null) {
            Connection connection = conexao.getConnection();
            try {
                String valorDoComandoUm = comandos.get("restaurar");
                PreparedStatement preparedStatement = connection.prepareStatement(valorDoComandoUm);
                preparedStatement.setInt(1, codigo);
                connection.setAutoCommit(false);
                sucesso = preparedStatement.executeUpdate() == 1;
                connection.commit();
                connection.setAutoCommit(true);
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
}
