package com.live.ads21fatene.biblioteca_publica.models.daos;

import com.live.ads21fatene.biblioteca_publica.models.Categoria;
import com.live.ads21fatene.biblioteca_publica.models.DadoMaterial;
import com.live.ads21fatene.biblioteca_publica.models.Editora;
import com.live.ads21fatene.biblioteca_publica.models.Formato;
import com.live.ads21fatene.biblioteca_publica.models.Material;
import com.live.ads21fatene.biblioteca_publica.models.Publico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class MateriaisDAO {

    private final Conexao conexao;
    private final Map<String, String> comandos;

    public MateriaisDAO(Conexao conexao) {
        this.conexao = conexao;
        comandos = new LinkedHashMap<>();
        List<String> linhas = conexao.carregaSQL("prepareds_statements/materiais");
        for (int chave = 0, valor = 1; valor < linhas.size(); chave = valor + 1, valor = chave + 1) {
            comandos.put(linhas.get(chave), linhas.get(valor));
        }
        linhas.clear();
    }

    public List<Material> pesquisarPorTodosOsDadosNaoNulos(Material material) {
        List<Material> materiais = new LinkedList<>();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarPorTodosOsDadosNaoNulos");
            List<String> where = new LinkedList<>();
            List<SetCommand> setCommands = new LinkedList<>();

            if (material.getCodigo() != null) {
                where.add("material_codigo = ?");
                setCommands.add(new SetInt(where.size(), material.getCodigo()));
            }
            if (material.getDataHoraCadastro() != null) {
                where.add("material_data_hora_cadastro = ?");
                setCommands.add(new SetDate(where.size(), material.getDataHoraCadastro()));
            }
            if (material.getInformacao() != null) {
                where.add("material_informacao = ?");
                setCommands.add(new SetString(where.size(), material.getInformacao()));
            }
            if (material.getLocalLogicoFisico() != null) {
                where.add("material_local_logico_fisico = ?");
                setCommands.add(new SetString(where.size(), material.getLocalLogicoFisico()));
            }

            DadoMaterial dadoMaterial = material.getDadoMaterial();
            if (dadoMaterial != null) {
                if (dadoMaterial.getTitulo() != null) {
                    where.add("material_dado_material_titulo = ?");
                    setCommands.add(new SetString(where.size(), dadoMaterial.getTitulo()));
                }
                if (dadoMaterial.getDescricao() != null) {
                    where.add("material_dado_material_descricao = ?");
                    setCommands.add(new SetString(where.size(), dadoMaterial.getDescricao()));
                }
                if (dadoMaterial.getEdicao() != null) {
                    where.add("material_dado_material_edicao = ?");
                    setCommands.add(new SetInt(where.size(), dadoMaterial.getEdicao()));
                }
                if (dadoMaterial.getAnoPublicacao() != null) {
                    where.add("material_dado_material_ano_publicacao = ?");
                    setCommands.add(new SetInt(where.size(), dadoMaterial.getAnoPublicacao()));
                }
                if (dadoMaterial.getAutor() != null) {
                    where.add("material_dado_material_autor = ?");
                    setCommands.add(new SetString(where.size(), dadoMaterial.getAutor()));
                }

                Editora editora = dadoMaterial.getEditora();
                if (editora != null) {
                    if (editora.getCodigo() != null) {
                        where.add("material_dado_material_editora_codigo = ?");
                        setCommands.add(new SetInt(where.size(), editora.getCodigo()));
                    }
                    if (editora.getNome() != null) {
                        where.add("material_dado_material_editora_nome = ?");
                        setCommands.add(new SetString(where.size(), editora.getNome()));
                    }
                }

                Categoria categoria = dadoMaterial.getCategoria();
                if (categoria != null) {
                    if (categoria.getCodigo() != null) {
                        where.add("material_dado_material_categoria_codigo = ?");
                        setCommands.add(new SetInt(where.size(), categoria.getCodigo()));
                    }
                    if (categoria.getNome() != null) {
                        where.add("material_dado_material_categoria_nome = ?");
                        setCommands.add(new SetString(where.size(), categoria.getNome()));
                    }
                }

                Publico publico = dadoMaterial.getPublico();
                if (publico != null) {
                    if (publico.getCodigo() != null) {
                        where.add("material_dado_material_publico_codigo = ?");
                        setCommands.add(new SetInt(where.size(), publico.getCodigo()));
                    }
                    if (publico.getNome() != null) {
                        where.add("material_dado_material_publico_nome = ?");
                        setCommands.add(new SetString(where.size(), publico.getNome()));
                    }
                }
            }

            Formato formato = material.getFormato();
            if (formato != null) {
                if (formato.getCodigo() != null) {
                    where.add("material_formato_codigo = ?");
                    setCommands.add(new SetInt(where.size(), formato.getCodigo()));
                }
                if (formato.getNome() != null) {
                    where.add("material_formato_nome = ?");
                    setCommands.add(new SetString(where.size(), formato.getNome()));
                }
            }

            StringBuilder query = new StringBuilder(valorDoComandoUm);
            if (!where.isEmpty()) {
                query.append(" WHERE ").append(where.remove(0));
            }
            while (!where.isEmpty()) {
                query.append(" AND ").append(where.remove(0));
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());

            while (!setCommands.isEmpty()) {
                setCommands.remove(0).set(preparedStatement);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                material = new Material();
                material.setCodigo(resultSet.getInt("material_codigo"));
                Date date = resultSet.getDate("material_data_hora_cadastro");
                if (date != null) {
                    material.setDataHoraCadastro(Calendar.getInstance());
                    material.getDataHoraCadastro().setTime(date);
                }

                dadoMaterial = new DadoMaterial();
                dadoMaterial.setCodigo(resultSet.getInt("material_dado_material_codigo"));
                dadoMaterial.setTitulo(resultSet.getString("material_dado_material_titulo"));
                dadoMaterial.setDescricao(resultSet.getString("material_dado_material_descricao"));
                dadoMaterial.setEdicao(resultSet.getInt("material_dado_material_edicao"));
                dadoMaterial.setAnoPublicacao(resultSet.getInt("material_dado_material_ano_publicacao"));
                dadoMaterial.setAutor(resultSet.getString("material_dado_material_autor"));

                Editora editora = new Editora();
                editora.setCodigo(resultSet.getInt("material_dado_material_editora_codigo"));
                editora.setNome(resultSet.getString("material_dado_material_editora_nome"));
                dadoMaterial.setEditora(editora);

                Categoria categoria = new Categoria();
                categoria.setCodigo(resultSet.getInt("material_dado_material_categoria_codigo"));
                categoria.setNome(resultSet.getString("material_dado_material_categoria_nome"));
                dadoMaterial.setCategoria(categoria);

                Publico publico = new Publico();
                publico.setCodigo(resultSet.getInt("material_dado_material_publico_codigo"));
                publico.setNome(resultSet.getString("material_dado_material_publico_nome"));
                dadoMaterial.setPublico(publico);

                material.setDadoMaterial(dadoMaterial);

                material.setInformacao(resultSet.getString("material_informacao"));
                material.setLocalLogicoFisico(resultSet.getString("material_local_logico_fisico"));

                formato = new Formato();
                formato.setCodigo(resultSet.getInt("material_formato_codigo"));
                formato.setNome(resultSet.getString("material_formato_nome"));

                material.setFormato(formato);

                materiais.add(material);
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
        return materiais;
    }

    public Material buscarPeloCodigo(Integer codigo) {
        Material material = null;
        if (codigo != null) {
            material = new Material();
            material.setCodigo(codigo);
            List<Material> materiais = pesquisarPorTodosOsDadosNaoNulos(material);
            if (!materiais.isEmpty()) {
                material = materiais.remove(0);
            } else {
                material = null;
            }
        }
        return material;
    }

    public Boolean atualizarPorTodosOsDados(Material material) {
        Boolean sucesso = false;
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("atualizarPorTodosOsDados");
            StringBuilder query = new StringBuilder(valorDoComandoUm);
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());
            int indice = 1;
            setInt(indice++, material.getCodigo(), preparedStatement);
            setString(indice++, material.getInformacao(), preparedStatement);
            setString(indice++, material.getLocalLogicoFisico(), preparedStatement);

            Formato formato = material.getFormato();
            setInt(indice++, formato.getCodigo(), preparedStatement);
            setString(indice++, formato.getNome(), preparedStatement);

            DadoMaterial dadoMaterial = material.getDadoMaterial();
            setInt(indice++, dadoMaterial.getCodigo(), preparedStatement);
            setString(indice++, dadoMaterial.getTitulo(), preparedStatement);
            setString(indice++, dadoMaterial.getDescricao(), preparedStatement);
            setInt(indice++, dadoMaterial.getEdicao(), preparedStatement);
            setInt(indice++, dadoMaterial.getAnoPublicacao(), preparedStatement);
            setString(indice++, dadoMaterial.getAutor(), preparedStatement);

            Editora editora = dadoMaterial.getEditora();
            setInt(indice++, editora.getCodigo(), preparedStatement);
            setString(indice++, editora.getNome(), preparedStatement);

            Categoria categoria = dadoMaterial.getCategoria();
            setInt(indice++, categoria.getCodigo(), preparedStatement);
            setString(indice++, categoria.getNome(), preparedStatement);

            Publico publico = dadoMaterial.getPublico();
            setInt(indice++, publico.getCodigo(), preparedStatement);
            setString(indice++, publico.getNome(), preparedStatement);

            connection.setAutoCommit(false);
            preparedStatement.execute();
            connection.commit();
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
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            conexao.fecharConnection();
        }
        return sucesso;
    }

    public Boolean cadastarNovo(List<Material> materiais) {
        Boolean sucesso = false;
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("cadastarNovo" + 1);
            String valorDoComandoDois = comandos.get("cadastarNovo" + 2);
            StringBuilder query = new StringBuilder(valorDoComandoUm);
            for (int i = 0; i < materiais.size(); i++) {
                query.append("\n").append(valorDoComandoDois);
            }
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());
            int indice = 1;
            DadoMaterial dado_material = materiais.get(0).getDadoMaterial();
            setString(indice++, dado_material.getTitulo(), preparedStatement);
            setString(indice++, dado_material.getDescricao(), preparedStatement);
            setInt(indice++, dado_material.getEdicao(), preparedStatement);
            setInt(indice++, dado_material.getAnoPublicacao(), preparedStatement);
            setString(indice++, dado_material.getAutor(), preparedStatement);

            Editora editora = dado_material.getEditora();
            setInt(indice++, editora.getCodigo(), preparedStatement);
            setString(indice++, editora.getNome(), preparedStatement);

            Categoria categoria = dado_material.getCategoria();
            setInt(indice++, categoria.getCodigo(), preparedStatement);
            setString(indice++, categoria.getNome(), preparedStatement);

            Publico publico = dado_material.getPublico();
            setInt(indice++, publico.getCodigo(), preparedStatement);
            setString(indice++, publico.getNome(), preparedStatement);

            Formato formato;
            for (Material material : materiais) {
                formato = material.getFormato();
                setInt(indice++, formato.getCodigo(), preparedStatement);
                setString(indice++, formato.getNome(), preparedStatement);
                setString(indice++, material.getInformacao(), preparedStatement);
                setString(indice++, material.getLocalLogicoFisico(), preparedStatement);
            }
            preparedStatement.execute();
            connection.commit();
            sucesso = true;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
            }
            conexao.fecharConnection();
            throw new RuntimeException(ex.getMessage());
        } catch (NullPointerException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
            conexao.fecharConnection();
        }
        return sucesso;
    }

    private void setString(Integer posicao, String valor, PreparedStatement preparedStatement) throws SQLException {
        if (valor == null) {
            preparedStatement.setNull(posicao, Types.VARCHAR);
        } else {
            preparedStatement.setString(posicao, valor);
        }
    }

    private void setInt(Integer posicao, Integer valor, PreparedStatement preparedStatement) throws SQLException {
        if (valor == null) {
            preparedStatement.setNull(posicao, Types.INTEGER);
        } else {
            preparedStatement.setInt(posicao, valor);
        }
    }
}