package com.live.adsfatene.biblioteca_publica.models.daos;

import com.live.adsfatene.biblioteca_publica.models.AnoPublicacao;
import com.live.adsfatene.biblioteca_publica.models.Autor;
import com.live.adsfatene.biblioteca_publica.models.Categoria;
import com.live.adsfatene.biblioteca_publica.models.DadoMaterial;
import com.live.adsfatene.biblioteca_publica.models.Edicao;
import com.live.adsfatene.biblioteca_publica.models.Editora;
import com.live.adsfatene.biblioteca_publica.models.Estoque;
import com.live.adsfatene.biblioteca_publica.models.Formato;
import com.live.adsfatene.biblioteca_publica.models.Material;
import com.live.adsfatene.biblioteca_publica.models.Publico;
import com.live.adsfatene.biblioteca_publica.models.Statu;
import com.live.adsfatene.biblioteca_publica.models.util.EstoqueComboBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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

    public Boolean atualizarLocalLogicoFisico(Estoque estoque) {
        Boolean sucesso = false;
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("atualizarLocalLogicoFisico");
            StringBuilder query = new StringBuilder(valorDoComandoUm);
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());
            int indice = 1;
            preparedStatement.setInt(indice++, estoque.getMaterial().getCodigo());
            preparedStatement.setString(indice++, estoque.getLocalLogicoFisico());

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

    public List<Estoque> pesquisarPorTodosOsDadosNaoNulos(Estoque estoque) {
        List<Estoque> estoques = new LinkedList<>();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 1);
            String valorDoComandoDois = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 2);
            List<String> where = new LinkedList<>();
            List<SetCommand> setCommands = new LinkedList<>();

            Material material = estoque.getMaterial();
            if (material != null) {
                if (material.getCodigo() != null) {
                    where.add("estoque_material_codigo = ?");
                    setCommands.add(new SetInt(where.size(), material.getCodigo()));
                }
                if (material.getDataHoraCadastro() != null) {
                    where.add("estoque_material_data_hora_cadastro = ?");
                    setCommands.add(new SetDate(where.size(), material.getDataHoraCadastro()));
                }
                if (material.getInformacao() != null) {
                    where.add("estoque_material_informacao = ?");
                    setCommands.add(new SetString(where.size(), material.getInformacao()));
                }
                DadoMaterial dadoMaterial = material.getDadoMaterial();
                if (dadoMaterial != null) {
                    if (dadoMaterial.getTitulo() != null) {
                        where.add("LOWER(estoque_material_dado_material_titulo) LIKE ?");
                        setCommands.add(new SetString(where.size(), "%" + dadoMaterial.getTitulo().toLowerCase() + "%"));
                    }
                    if (dadoMaterial.getDescricao() != null) {
                        where.add("LOWER(estoque_material_dado_material_descricao) LIKE ?");
                        setCommands.add(new SetString(where.size(), "%" + dadoMaterial.getDescricao().toLowerCase() + "%"));
                    }

                    Edicao edicao = dadoMaterial.getEdicao();
                    if (edicao != null) {
                        if (edicao.getNumero() != null) {
                            where.add("estoque_material_dado_material_edicao = ?");
                            setCommands.add(new SetInt(where.size(), edicao.getNumero()));
                        }
                    }

                    AnoPublicacao anoPublicacao = dadoMaterial.getAnoPublicacao();
                    if (anoPublicacao != null) {
                        if (anoPublicacao.getAno() != null) {
                            where.add("estoque_material_dado_material_ano_publicacao = ?");
                            setCommands.add(new SetInt(where.size(), anoPublicacao.getAno()));
                        }
                    }

                    Autor autor = dadoMaterial.getAutor();
                    if (autor != null) {
                        if (autor.getNome() != null) {
                            where.add("estoque_material_dado_material_autor = ?");
                            setCommands.add(new SetString(where.size(), autor.getNome()));
                        }
                    }

                    Editora editora = dadoMaterial.getEditora();
                    if (editora != null) {
                        if (editora.getCodigo() != null) {
                            where.add("estoque_material_dado_material_editora_codigo = ?");
                            setCommands.add(new SetInt(where.size(), editora.getCodigo()));
                        }
                        if (editora.getNome() != null) {
                            where.add("estoque_material_dado_material_editora_nome = ?");
                            setCommands.add(new SetString(where.size(), editora.getNome()));
                        }
                    }

                    Categoria categoria = dadoMaterial.getCategoria();
                    if (categoria != null) {
                        if (categoria.getCodigo() != null) {
                            where.add("estoque_material_dado_material_categoria_codigo = ?");
                            setCommands.add(new SetInt(where.size(), categoria.getCodigo()));
                        }
                        if (categoria.getNome() != null) {
                            where.add("estoque_material_dado_material_categoria_nome = ?");
                            setCommands.add(new SetString(where.size(), categoria.getNome()));
                        }
                    }

                    Publico publico = dadoMaterial.getPublico();
                    if (publico != null) {
                        if (publico.getCodigo() != null) {
                            where.add("estoque_material_dado_material_publico_codigo = ?");
                            setCommands.add(new SetInt(where.size(), publico.getCodigo()));
                        }
                        if (publico.getNome() != null) {
                            where.add("estoque_material_dado_material_publico_nome = ?");
                            setCommands.add(new SetString(where.size(), publico.getNome()));
                        }
                    }
                }
                Formato formato = material.getFormato();
                if (formato != null) {
                    if (formato.getCodigo() != null) {
                        where.add("estoque_material_formato_codigo = ?");
                        setCommands.add(new SetInt(where.size(), formato.getCodigo()));
                    }
                    if (formato.getNome() != null) {
                        where.add("estoque_material_formato_nome = ?");
                        setCommands.add(new SetString(where.size(), formato.getNome()));
                    }
                }
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
                material = new Material();
                material.setCodigo(resultSet.getInt("estoque_material_codigo"));
                Date date = resultSet.getDate("estoque_material_data_hora_cadastro");
                if (date != null) {
                    material.setDataHoraCadastro(Calendar.getInstance());
                    material.getDataHoraCadastro().setTime(date);
                }

                DadoMaterial dadoMaterial = new DadoMaterial();
                dadoMaterial.setCodigo(resultSet.getInt("estoque_material_dado_material_codigo"));
                dadoMaterial.setTitulo(resultSet.getString("estoque_material_dado_material_titulo"));
                dadoMaterial.setDescricao(resultSet.getString("estoque_material_dado_material_descricao"));

                Edicao edicao = new Edicao();
                edicao.setNumero(resultSet.getInt("estoque_material_dado_material_edicao"));
                dadoMaterial.setEdicao(edicao);

                AnoPublicacao anoPublicacao = new AnoPublicacao();
                anoPublicacao.setAno(resultSet.getInt("estoque_material_dado_material_ano_publicacao"));
                dadoMaterial.setAnoPublicacao(anoPublicacao);

                Autor autor = new Autor();
                autor.setNome(resultSet.getString("estoque_material_dado_material_autor"));
                dadoMaterial.setAutor(autor);

                Editora editora = new Editora();
                editora.setCodigo(resultSet.getInt("estoque_material_dado_material_editora_codigo"));
                editora.setNome(resultSet.getString("estoque_material_dado_material_editora_nome"));
                dadoMaterial.setEditora(editora);

                Categoria categoria = new Categoria();
                categoria.setCodigo(resultSet.getInt("estoque_material_dado_material_categoria_codigo"));
                categoria.setNome(resultSet.getString("estoque_material_dado_material_categoria_nome"));
                dadoMaterial.setCategoria(categoria);

                Publico publico = new Publico();
                publico.setCodigo(resultSet.getInt("estoque_material_dado_material_publico_codigo"));
                publico.setNome(resultSet.getString("estoque_material_dado_material_publico_nome"));
                dadoMaterial.setPublico(publico);

                material.setDadoMaterial(dadoMaterial);

                material.setInformacao(resultSet.getString("estoque_material_informacao"));

                Formato formato = new Formato();
                formato.setCodigo(resultSet.getInt("estoque_material_formato_codigo"));
                formato.setNome(resultSet.getString("estoque_material_formato_nome"));

                material.setFormato(formato);
                estoque = new Estoque();
                estoque.setMaterial(material);
                estoque.setStatu(resultSet.getString("estoque_statu"));
                estoque.setLocalLogicoFisico(resultSet.getString("estoque_local_logico_fisico"));
                estoques.add(estoque);
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
        return estoques;
    }

    public Estoque buscarPeloCodigo(Integer codigo) {
        Estoque estoque = null;
        if (codigo != null) {
            estoque = new Estoque();
            estoque.setMaterial(new Material());
            estoque.getMaterial().setCodigo(codigo);
            List<Estoque> estoques = pesquisarPorTodosOsDadosNaoNulos(estoque);
            if (!estoques.isEmpty()) {
                estoque = estoques.remove(0);
            } else {
                estoque = null;
            }
        }
        return estoque;
    }

    public boolean removerPeloCodigo(Integer codigo) {
        boolean sucesso = false;
        if (codigo != null) {
            Connection connection = conexao.getConnection();
            try {
                String valorDoComandoUm = comandos.get("removerPeloCodigo");
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

    public EstoqueComboBox pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormatoStatu(MateriaisDao materiaisDao) {
        EstoqueComboBox estoqueComboBox = new EstoqueComboBox(materiaisDao.pesquisarTodosEdicaoAnoPublicaoAutorEditoraCategoriaPublicoFormato());
        Statu statu = new Statu();
        statu.setNome("Novo");
        estoqueComboBox.getStatus().add(statu);
        statu = new Statu();
        statu.setNome("Usuado");
        estoqueComboBox.getStatus().add(statu);
        statu = new Statu();
        statu.setNome("Restaurado");
        estoqueComboBox.getStatus().add(statu);
        return estoqueComboBox;
    }
}
