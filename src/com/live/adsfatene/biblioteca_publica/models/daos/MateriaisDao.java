package com.live.adsfatene.biblioteca_publica.models.daos;

import com.live.adsfatene.biblioteca_publica.models.AnoPublicacao;
import com.live.adsfatene.biblioteca_publica.models.Autor;
import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.DadoMaterial;
import com.live.adsfatene.biblioteca_publica.models.Edicao;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Publico;
import com.live.adsfatene.biblioteca_publica.models.util.MaterialComboBox;
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
public class MateriaisDao {

    private final Conexao conexao;
    private final Map<String, String> comandos;

    public MateriaisDao(Conexao conexao) {
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
            String valorDoComandoUm = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 1);
            String valorDoComandoDois = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 2);
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
                    where.add("LOWER(material_dado_material_titulo) LIKE ?");
                    setCommands.add(new SetString(where.size(), "%" + dadoMaterial.getTitulo().toLowerCase() + "%"));
                }
                if (dadoMaterial.getDescricao() != null) {
                    where.add("LOWER(material_dado_material_descricao) LIKE ?");
                    setCommands.add(new SetString(where.size(), "%" + dadoMaterial.getDescricao().toLowerCase() + "%"));
                }

                Edicao edicao = dadoMaterial.getEdicao();
                if (edicao != null) {
                    if (edicao.getNumero() != null) {
                        where.add("material_dado_material_edicao = ?");
                        setCommands.add(new SetInt(where.size(), edicao.getNumero()));
                    }
                }

                AnoPublicacao anoPublicacao = dadoMaterial.getAnoPublicacao();
                if (anoPublicacao != null) {
                    if (anoPublicacao.getAno() != null) {
                        where.add("material_dado_material_ano_publicacao = ?");
                        setCommands.add(new SetInt(where.size(), anoPublicacao.getAno()));
                    }
                }

                Autor autor = dadoMaterial.getAutor();
                if (autor != null) {
                    if (autor.getNome() != null) {
                        where.add("material_dado_material_autor = ?");
                        setCommands.add(new SetString(where.size(), autor.getNome()));
                    }
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
            query.append(valorDoComandoDois);

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

                Edicao edicao = new Edicao();
                edicao.setNumero(resultSet.getInt("material_dado_material_edicao"));
                dadoMaterial.setEdicao(edicao);

                AnoPublicacao anoPublicacao = new AnoPublicacao();
                anoPublicacao.setAno(resultSet.getInt("material_dado_material_ano_publicacao"));
                dadoMaterial.setAnoPublicacao(anoPublicacao);

                Autor autor = new Autor();
                autor.setNome(resultSet.getString("material_dado_material_autor"));
                dadoMaterial.setAutor(autor);

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

            Edicao edicao = dadoMaterial.getEdicao();
            setInt(indice++, edicao.getNumero(), preparedStatement);

            AnoPublicacao anoPublicacao = dadoMaterial.getAnoPublicacao();
            setInt(indice++, anoPublicacao.getAno(), preparedStatement);

            Autor autor = dadoMaterial.getAutor();
            setString(indice++, autor.getNome(), preparedStatement);

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

    public Boolean cadastarNovos(List<Material> materiais) {
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
            DadoMaterial dadoMaterial = materiais.get(0).getDadoMaterial();
            setString(indice++, dadoMaterial.getTitulo(), preparedStatement);
            setString(indice++, dadoMaterial.getDescricao(), preparedStatement);

            Edicao edicao = dadoMaterial.getEdicao();
            setInt(indice++, edicao.getNumero(), preparedStatement);

            AnoPublicacao anoPublicacao = dadoMaterial.getAnoPublicacao();
            setInt(indice++, anoPublicacao.getAno(), preparedStatement);

            Autor autor = dadoMaterial.getAutor();
            setString(indice++, autor.getNome(), preparedStatement);


            Editora editora = dadoMaterial.getEditora();
            setInt(indice++, editora.getCodigo(), preparedStatement);
            setString(indice++, editora.getNome(), preparedStatement);

            Categoria categoria = dadoMaterial.getCategoria();
            setInt(indice++, categoria.getCodigo(), preparedStatement);
            setString(indice++, categoria.getNome(), preparedStatement);

            Publico publico = dadoMaterial.getPublico();
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

    public MaterialComboBox pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormato() {
        MaterialComboBox materialComboBox = new MaterialComboBox();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormato");
            PreparedStatement preparedStatement = connection.prepareStatement(valorDoComandoUm);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String valor = resultSet.getString("valor");
                Integer codigo = resultSet.getInt("codigo");
                String tipo = resultSet.getString("tipo");
                switch (tipo) {
                    case "edicao":
                        Edicao edicao = new Edicao();
                        edicao.setNumero(Integer.valueOf(valor));
                        materialComboBox.getEdicoes().add(edicao);
                        break;
                    case "ano_publicacao":
                        AnoPublicacao anoPublicacao = new AnoPublicacao();
                        anoPublicacao.setAno(Integer.valueOf(valor));
                        materialComboBox.getAnosPublicacoes().add(anoPublicacao);
                        break;
                    case "autor":
                        Autor autor = new Autor();
                        autor.setNome(valor);
                        materialComboBox.getAutores().add(autor);
                        break;
                    case "editora":
                        Editora editora = new Editora();
                        editora.setCodigo(codigo);
                        editora.setNome(valor);
                        materialComboBox.getEditoras().add(editora);
                        break;
                    case "categoria":
                        Categoria categoria = new Categoria();
                        categoria.setCodigo(codigo);
                        categoria.setNome(valor);
                        materialComboBox.getCategorias().add(categoria);
                        break;
                    case "publico":
                        Publico publico = new Publico();
                        publico.setCodigo(codigo);
                        publico.setNome(valor);
                        materialComboBox.getPublicos().add(publico);
                        break;
                    default:
                        Formato formato = new Formato();
                        formato.setCodigo(codigo);
                        formato.setNome(valor);
                        materialComboBox.getFormatos().add(formato);
                        break;
                }
            }
            if (materialComboBox.getEdicoes().isEmpty()) {
                Edicao edicao = new Edicao();
                edicao.setNumero(1);
                materialComboBox.getEdicoes().add(edicao);
            }
            if (materialComboBox.getAnosPublicacoes().isEmpty()) {
                AnoPublicacao anoPublicacao = new AnoPublicacao();
                anoPublicacao.setAno(Calendar.getInstance().get(Calendar.YEAR));
                materialComboBox.getAnosPublicacoes().add(anoPublicacao);
            }
            if (materialComboBox.getAutores().isEmpty()) {
                Autor autor = new Autor();
                autor.setNome("desconhecido");
                materialComboBox.getAutores().add(autor);
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
        return materialComboBox;
    }

    public boolean exluirPeloCodigo(Integer codigo) {
        boolean sucesso = false;
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
        return sucesso;
    }
}