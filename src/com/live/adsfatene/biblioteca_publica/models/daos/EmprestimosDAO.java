package com.live.adsfatene.biblioteca_publica.models.daos;

import com.live.adsfatene.biblioteca_publica.models.AnoPublicacao;
import com.live.adsfatene.biblioteca_publica.models.Autor;
import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.DadoMaterial;
import com.live.adsfatene.biblioteca_publica.models.Edicao;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Emprestimo;
import com.live.adsfatene.biblioteca_publica.models.EmprestimoEstoque;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Publico;
import com.live.adsfatene.biblioteca_publica.models.util.EmprestimoComboBox;
import com.live.adsfatene.biblioteca_publica.models.util.MaterialComboBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Clairton
 */
public class EmprestimosDAO {

    private final Conexao conexao;
    private final Map<String, String> comandos;

    public EmprestimosDAO(Conexao conexao) {
        this.conexao = conexao;
        comandos = new LinkedHashMap<>();
        List<String> linhas = conexao.carregaSQL("prepareds_statements/emprestimos");
        for (int chave = 0, valor = 1; valor < linhas.size(); chave = valor + 1, valor = chave + 1) {
            comandos.put(linhas.get(chave), linhas.get(valor));
        }
        linhas.clear();
    }

    public List<Emprestimo> pesquisarPorTodosOsDadosNaoNulos(Emprestimo emprestimo) {
        List<Emprestimo> emprestimos = new LinkedList<>();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 1);
            String valorDoComandoDois = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 2);
            List<String> where = new LinkedList<>();
            List<SetCommand> setCommands = new LinkedList<>();

            if (emprestimo.getCodigo() != null) {
                where.add("emprestimo_codigo = ?");
                setCommands.add(new SetInt(where.size(), emprestimo.getCodigo()));
            }
            if (emprestimo.getCidadao() != null) {
                where.add("emprestimo_cidadao_codigo = ?");
                setCommands.add(new SetInt(where.size(), emprestimo.getCidadao().getCodigo()));
            }
            if (emprestimo.getEmprestimosEstoques() != null
                    && !emprestimo.getEmprestimosEstoques().isEmpty()
                    && emprestimo.getEmprestimosEstoques().get(0).getEstoque() != null) {
                where.add("emprestimo_estoque_material_dado_material_titulo ILIKE ?");
                setCommands.add(new SetString(where.size(), "%" + emprestimo.getEmprestimosEstoques().get(0).getEstoque().getMaterial().getDadoMaterial().getTitulo() + "%"));
            }
            if (emprestimo.getDataHoraEmprestato() != null
                    && emprestimo.getDataHoraDevolucaoEfetiva() == null) {
                where.add("emprestimo_data_hora_devolucao_efetiva IS NULL");
            } else if (emprestimo.getDataHoraEmprestato() == null
                    && emprestimo.getDataHoraDevolucaoEfetiva() != null) {
                where.add("emprestimo_data_hora_devolucao_efetiva IS NOT NULL");
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
                if (emprestimos.isEmpty() || !emprestimos.get(emprestimos.size() - 1).getCodigo().equals(resultSet.getInt("emprestimo_codigo"))) {
                    emprestimo = new Emprestimo();
                    emprestimo.setCodigo(resultSet.getInt("emprestimo_codigo"));
                    emprestimo.setCidadao(new Cidadao());
                    emprestimo.getCidadao().setCodigo(resultSet.getInt("emprestimo_cidadao_codigo"));
                    emprestimo.getCidadao().setNomeCompleto(resultSet.getString("emprestimo_cidadao_nome_completo"));
                    Timestamp timestamp = resultSet.getTimestamp("emprestimo_data_hora_emprestado");
                    emprestimo.setDataHoraEmprestato(Calendar.getInstance());
                    emprestimo.getDataHoraEmprestato().setTime(timestamp);
                    timestamp = resultSet.getTimestamp("emprestimo_data_hora_devolucao_prevista");
                    emprestimo.setDataHoraDevolucaoPrevista(Calendar.getInstance());
                    emprestimo.getDataHoraDevolucaoPrevista().setTime(timestamp);
                    timestamp = resultSet.getTimestamp("emprestimo_data_hora_devolucao_efetiva");
                    if (timestamp != null) {
                        emprestimo.setDataHoraDevolucaoEfetiva(Calendar.getInstance());
                        emprestimo.getDataHoraDevolucaoEfetiva().setTime(timestamp);
                    }
                    emprestimos.add(emprestimo);
                    emprestimo.setEmprestimosEstoques(new LinkedList<EmprestimoEstoque>());
                }
                EmprestimoEstoque emprestimoEstoque = new EmprestimoEstoque();
                emprestimoEstoque.setEmprestimo(emprestimo);
                emprestimoEstoque.setEstadoDevolucao(resultSet.getString("emprestimo_emprestimo_estoque_estado_devolucao"));
                emprestimoEstoque.setMotivo(resultSet.getString("emprestimo_emprestimo_estoque_motivo"));
                emprestimoEstoque.setCodigo(resultSet.getInt("emprestimo_emprestimo_estoque_codigo"));
                emprestimoEstoque.setEstoque(new Estoque());
                emprestimoEstoque.getEstoque().setMaterial(new Material());
                emprestimoEstoque.getEstoque().getMaterial().setCodigo(resultSet.getInt("emprestimo_estoque_material_codigo"));
                emprestimoEstoque.getEstoque().getMaterial().setDadoMaterial(new DadoMaterial());
                emprestimoEstoque.getEstoque().getMaterial().getDadoMaterial().setTitulo(resultSet.getString("emprestimo_estoque_material_dado_material_titulo"));
                emprestimoEstoque.getEstoque().getMaterial().setFormato(new Formato());
                emprestimoEstoque.getEstoque().getMaterial().getFormato().setNome(resultSet.getString("emprestimo_estoque_material_formato_nome"));
                emprestimoEstoque.getEstoque().setLocalLogicoFisico(resultSet.getString("emprestimo_estoque_local_logico_fisico"));

                emprestimo.getEmprestimosEstoques().add(emprestimoEstoque);
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
        return emprestimos;
    }

    public Emprestimo buscarPeloCodigo(Integer codigo) {
        Emprestimo emprestimo = null;
        if (codigo != null) {
            emprestimo = new Emprestimo();
            emprestimo.setCodigo(codigo);
            List<Emprestimo> emprestimos = pesquisarPorTodosOsDadosNaoNulos(emprestimo);
            if (!emprestimos.isEmpty()) {
                emprestimo = emprestimos.remove(0);
            } else {
                emprestimo = null;
            }
        }
        return emprestimo;
    }

    public Boolean cadastarNovo(Emprestimo emprestimo) {
        Boolean sucesso = false;
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("cadastarNovo" + 1);
            String valorDoComandoDois = comandos.get("cadastarNovo" + 2);
            StringBuilder query = new StringBuilder(valorDoComandoUm);
            for (int i = 0; i < emprestimo.getEmprestimosEstoques().size(); i++) {
                query.append("\n").append(valorDoComandoDois);
            }
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());
            int indice = 1;

            preparedStatement.setInt(indice++, emprestimo.getCidadao().getCodigo());
            preparedStatement.setTimestamp(indice++, new java.sql.Timestamp(emprestimo.getDataHoraDevolucaoPrevista().getTimeInMillis()));
            for (EmprestimoEstoque emprestimoEstoque : emprestimo.getEmprestimosEstoques()) {
                preparedStatement.setInt(indice++, emprestimoEstoque.getEstoque().getMaterial().getCodigo());
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
        return sucesso;
    }

    public Boolean concluir(Emprestimo emprestimo) {
        Boolean sucesso = false;
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("concluir" + 1);
            String valorDoComandoDois = comandos.get("concluir" + 2);
            StringBuilder query = new StringBuilder(valorDoComandoUm);
            for (int i = 0; i < emprestimo.getEmprestimosEstoques().size(); i++) {
                query.append("\n").append(valorDoComandoDois);
            }
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());
            int indice = 1;

            preparedStatement.setInt(indice++, emprestimo.getCodigo());
            for (EmprestimoEstoque emprestimoEstoque : emprestimo.getEmprestimosEstoques()) {
                preparedStatement.setInt(indice++, emprestimoEstoque.getCodigo());
                preparedStatement.setString(indice++, emprestimoEstoque.getEstadoDevolucao());
                setString(indice++, emprestimoEstoque.getMotivo(), preparedStatement);
            }

            connection.setAutoCommit(false);
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
        return sucesso;
    }

    public EmprestimoComboBox pesquisarTodosCodigoCidadaoEstoque() {
        EmprestimoComboBox emprestimoComboBox = new EmprestimoComboBox();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarTodosCodigoCidadaoEstoque");
            PreparedStatement preparedStatement = connection.prepareStatement(valorDoComandoUm);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String valor = resultSet.getString("valor");
                Integer codigo = resultSet.getInt("codigo");
                String tipo = resultSet.getString("tipo");
                switch (tipo) {
                    case "emprestimo":
                        Emprestimo emprestimo = new Emprestimo();
                        emprestimo.setCodigo(codigo);
                        emprestimoComboBox.getEmprestimos().add(emprestimo);
                        break;
                    case "cidadao":
                        Cidadao cidadao = new Cidadao();
                        cidadao.setCodigo(codigo);
                        cidadao.setNomeCompleto(valor);
                        emprestimoComboBox.getCidadaos().add(cidadao);
                        break;
                    default:
                        Estoque estoque = new Estoque();
                        estoque.setMaterial(new Material());
                        estoque.getMaterial().setCodigo(codigo);
                        estoque.getMaterial().setDadoMaterial(new DadoMaterial());
                        estoque.getMaterial().getDadoMaterial().setTitulo(valor);
                        emprestimoComboBox.getEstoques().add(estoque);
                        break;
                }
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
        return emprestimoComboBox;
    }

    private void setString(Integer posicao, String valor, PreparedStatement preparedStatement) throws SQLException {
        if (valor == null) {
            preparedStatement.setNull(posicao, Types.VARCHAR);
        } else {
            preparedStatement.setString(posicao, valor);
        }
    }

    public boolean excluirPeloCodigo(Integer codigo) {
        boolean sucesso = false;
        if (codigo != null) {
            Connection connection = conexao.getConnection();
            try {
                String valorDoComandoUm = comandos.get("excluirPeloCodigo");
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