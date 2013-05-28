package com.live.adsfatene.biblioteca_publica.models.daos;

import com.live.adsfatene.biblioteca_publica.models.Bairro;
import com.live.adsfatene.biblioteca_publica.models.Celular;
import com.live.adsfatene.biblioteca_publica.models.Cidadao;
import com.live.adsfatene.biblioteca_publica.models.Cidade;
import com.live.adsfatene.biblioteca_publica.models.DDD;
import com.live.adsfatene.biblioteca_publica.models.Estado;
import com.live.adsfatene.biblioteca_publica.models.Logradouro;
import com.live.adsfatene.biblioteca_publica.models.Telefone;
import com.live.adsfatene.biblioteca_publica.models.util.CidadaoComboBox;
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
public class CidadaosDao {

    private final Conexao conexao;
    private final Map<String, String> comandos;

    public CidadaosDao(Conexao conexao) {
        this.conexao = conexao;
        comandos = new LinkedHashMap<>();
        List<String> linhas = conexao.carregaSQL("prepareds_statements/cidadaos");
        for (int chave = 0, valor = 1; valor < linhas.size(); chave = valor + 1, valor = chave + 1) {
            comandos.put(linhas.get(chave), linhas.get(valor));
        }
        linhas.clear();
    }

    public List<Cidadao> pesquisarPorTodosOsDadosNaoNulos(Cidadao cidadao) {
        List<Cidadao> cidadaos = new LinkedList<>();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 1);
            String valorDoComandoDois = comandos.get("pesquisarPorTodosOsDadosNaoNulos" + 2);
            List<String> where = new LinkedList<>();
            List<SetCommand> setCommands = new LinkedList<>();

            if (cidadao.getCodigo() != null) {
                where.add("cidadao_codigo = ?");
                setCommands.add(new SetInt(where.size(), cidadao.getCodigo()));
            }
            if (cidadao.getNomeCompleto() != null) {
                where.add("LOWER(cidadao_nome_completo) LIKE ?");
                setCommands.add(new SetString(where.size(), "%" + cidadao.getNomeCompleto() + "%"));
            }
            if (cidadao.getLogradouro() != null) {
                where.add("LOWER(cidadao_logradouro) LIKE ?");
                setCommands.add(new SetString(where.size(), "%" + cidadao.getLogradouro() + "%"));
            }
            if (cidadao.getNumeroImovel() != null) {
                where.add("cidadao_numero_imovel = ?");
                setCommands.add(new SetInt(where.size(), cidadao.getNumeroImovel()));
            }

            Bairro bairro = cidadao.getBairro();
            if (bairro != null) {
                if (bairro.getCodigo() != null) {
                    where.add("cidadao_bairro_codigo = ?");
                    setCommands.add(new SetInt(where.size(), bairro.getCodigo()));
                }
                if (bairro.getNome() != null) {
                    where.add("LOWER(cidadao_bairro_nome) LIKE ?");
                    setCommands.add(new SetString(where.size(), "%" + bairro.getNome() + "%"));
                }
                Cidade cidade = bairro.getCidade();
                if (cidade != null) {
                    if (cidade.getCodigo() != null) {
                        where.add("cidadao_bairro_cidade_codigo = ?");
                        setCommands.add(new SetInt(where.size(), cidade.getCodigo()));
                    }
                    if (cidade.getNome() != null) {
                        where.add("LOWER(cidadao_bairro_cidade_nome) LIKE ?");
                        setCommands.add(new SetString(where.size(), "%" + cidade.getNome() + "%"));
                    }
                    Estado estado = cidade.getEstado();
                    if (estado != null) {
                        if (estado.getCodigo() != null) {
                            where.add("cidadao_bairro_cidade_estado_codigo = ?");
                            setCommands.add(new SetInt(where.size(), estado.getCodigo()));
                        }
                        if (estado.getNome() != null) {
                            where.add("LOWER(cidadao_bairro_cidade_estado_nome) LIKE ?");
                            setCommands.add(new SetString(where.size(), "%" + estado.getNome() + "%"));
                        }
                    }
                }
            }

            List<Telefone> telefones = cidadao.getTelefones();
            if (telefones != null) {
                for (Telefone telefone : telefones) {
                    DDD ddd = telefone.getDDD();
                    if (ddd != null) {
                        where.add("(cidadao_contato_voz_ddd_numero = ? AND cidadao_contato_voz_tipo LIKE 'tel')");
                        setCommands.add(new SetInt(where.size(), ddd.getNumero()));
                    }
                    if (telefone.getCodigo() != null) {
                        where.add("cidadao_contato_voz_codigo = ?");
                        setCommands.add(new SetInt(where.size(), telefone.getCodigo()));
                    }
                }
            }
            List<Celular> celulares = cidadao.getCelulares();
            if (celulares != null) {
                for (Celular celular : celulares) {
                    DDD ddd = celular.getDDD();
                    if (ddd != null) {
                        where.add("(cidadao_contato_voz_ddd_numero = ? AND cidadao_contato_voz_tipo LIKE 'cel')");
                        setCommands.add(new SetInt(where.size(), ddd.getNumero()));
                    }
                    if (celular.getCodigo() != null) {
                        where.add("cidadao_contato_voz_codigo = ?");
                        setCommands.add(new SetInt(where.size(), celular.getCodigo()));
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
                if (cidadaos.isEmpty() || !cidadaos.get(cidadaos.size() - 1).getCodigo().equals(resultSet.getInt("cidadao_codigo"))) {
                    cidadao = new Cidadao();
                    cidadao.setCodigo(resultSet.getInt("cidadao_codigo"));
                    cidadao.setNomeCompleto(resultSet.getString("cidadao_nome_completo"));
                    cidadao.setLogradouro(resultSet.getString("cidadao_logradouro"));
                    cidadao.setNumeroImovel(resultSet.getInt("cidadao_numero_imovel"));

                    bairro = new Bairro();
                    bairro.setCodigo(resultSet.getInt("cidadao_bairro_codigo"));
                    bairro.setNome(resultSet.getString("cidadao_bairro_nome"));
                    cidadao.setBairro(bairro);

                    Cidade cidade = new Cidade();
                    cidade.setCodigo(resultSet.getInt("cidadao_bairro_cidade_codigo"));
                    cidade.setNome(resultSet.getString("cidadao_bairro_cidade_nome"));
                    bairro.setCidade(cidade);

                    Estado estado = new Estado();
                    estado.setCodigo(resultSet.getInt("cidadao_bairro_cidade_estado_codigo"));
                    estado.setNome(resultSet.getString("cidadao_bairro_cidade_estado_nome"));
                    estado.setUf(resultSet.getString("cidadao_bairro_cidade_estado_uf"));
                    cidade.setEstado(estado);

                    Date date = resultSet.getDate("cidadao_data_hora_cadastro");
                    if (date != null) {
                        cidadao.setDataHoraCadastro(Calendar.getInstance());
                        cidadao.getDataHoraCadastro().setTime(date);
                    }
                    cidadao.setTelefones(new LinkedList<Telefone>());
                    cidadao.setCelulares(new LinkedList<Celular>());

                    cidadaos.add(cidadao);
                }

                Estado estado = new Estado();
                estado.setCodigo(resultSet.getInt("cidadao_contato_voz_ddd_estado_codigo"));
                estado.setNome(resultSet.getString("cidadao_contato_voz_ddd_estado_nome"));
                estado.setUf(resultSet.getString("cidadao_contato_voz_ddd_estado_uf"));
                DDD ddd = new DDD();
                ddd.setNumero(resultSet.getInt("cidadao_contato_voz_ddd_numero"));
                ddd.setEstado(estado);
                if (resultSet.getString("cidadao_contato_voz_tipo").equalsIgnoreCase("tel")) {
                    Telefone telefone = new Telefone();
                    telefone.setCodigo(resultSet.getInt("cidadao_contato_voz_codigo"));
                    telefone.setNumero(resultSet.getString("cidadao_contato_voz_numero"));
                    telefone.setDDD(ddd);
                    cidadao.getTelefones().add(telefone);
                } else {
                    Celular celular = new Celular();
                    celular.setCodigo(resultSet.getInt("cidadao_contato_voz_codigo"));
                    celular.setNumero(resultSet.getString("cidadao_contato_voz_numero"));
                    celular.setDDD(ddd);
                    cidadao.getCelulares().add(celular);
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
        return cidadaos;
    }

    public Cidadao buscarPeloCodigo(Integer codigo) {
        Cidadao cidadao = null;
        if (codigo != null) {
            cidadao = new Cidadao();
            cidadao.setCodigo(codigo);
            List<Cidadao> cidadaos = pesquisarPorTodosOsDadosNaoNulos(cidadao);
            if (!cidadaos.isEmpty()) {
                cidadao = cidadaos.remove(0);
            } else {
                cidadao = null;
            }
        }
        return cidadao;
    }

    public Boolean atualizarPorTodosOsDados(Cidadao cidadao) {
        Boolean sucesso = false;
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("atualizarPorTodosOsDados" + 1);
            String valorDoComandoDois = comandos.get("atualizarPorTodosOsDados" + 2);
            StringBuilder query = new StringBuilder(valorDoComandoUm);
            for (int i = 0; i < cidadao.getTelefones().size() + cidadao.getCelulares().size(); i++) {
                query.append("\n").append(valorDoComandoDois);
            }
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());
            int indice = 1;

            setInt(indice++, cidadao.getCodigo(), preparedStatement);
            setString(indice++, cidadao.getNomeCompleto(), preparedStatement);
            setString(indice++, cidadao.getLogradouro(), preparedStatement);
            setInt(indice++, cidadao.getNumeroImovel(), preparedStatement);
            setInt(indice++, cidadao.getBairro().getCodigo(), preparedStatement);
            setString(indice++, cidadao.getBairro().getNome(), preparedStatement);
            setInt(indice++, cidadao.getBairro().getCidade().getCodigo(), preparedStatement);
            setString(indice++, cidadao.getBairro().getCidade().getNome(), preparedStatement);
            setInt(indice++, cidadao.getBairro().getCidade().getEstado().getCodigo(), preparedStatement);
            for (Telefone telefone : cidadao.getTelefones()) {
                setInt(indice++, telefone.getCodigo(), preparedStatement);
                setInt(indice++, telefone.getCidadao().getCodigo(), preparedStatement);
                setInt(indice++, telefone.getDDD().getNumero(), preparedStatement);
                setString(indice++, telefone.getNumero(), preparedStatement);
                setString(indice++, "Tel", preparedStatement);
            }
            for (Celular celular : cidadao.getCelulares()) {
                setInt(indice++, celular.getCodigo(), preparedStatement);
                setInt(indice++, celular.getCidadao().getCodigo(), preparedStatement);
                setInt(indice++, celular.getDDD().getNumero(), preparedStatement);
                setString(indice++, celular.getNumero(), preparedStatement);
                setString(indice++, "Cel", preparedStatement);
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

    public Boolean cadastarNovo(Cidadao cidadao) {
        Boolean sucesso = false;
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("cadastarNovo" + 1);
            String valorDoComandoDois = comandos.get("cadastarNovo" + 2);
            StringBuilder query = new StringBuilder(valorDoComandoUm);
            for (int i = 0; i < cidadao.getTelefones().size() + cidadao.getCelulares().size(); i++) {
                query.append("\n").append(valorDoComandoDois);
            }
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            query.delete(0, query.length());
            int indice = 1;

            setString(indice++, cidadao.getNomeCompleto(), preparedStatement);
            setString(indice++, cidadao.getLogradouro(), preparedStatement);
            setInt(indice++, cidadao.getNumeroImovel(), preparedStatement);
            setInt(indice++, cidadao.getBairro().getCodigo(), preparedStatement);
            setString(indice++, cidadao.getBairro().getNome(), preparedStatement);
            setInt(indice++, cidadao.getBairro().getCidade().getCodigo(), preparedStatement);
            setString(indice++, cidadao.getBairro().getCidade().getNome(), preparedStatement);
            setInt(indice++, cidadao.getBairro().getCidade().getEstado().getCodigo(), preparedStatement);
            for (Telefone telefone : cidadao.getTelefones()) {
                setInt(indice++, telefone.getDDD().getNumero(), preparedStatement);
                setString(indice++, telefone.getNumero(), preparedStatement);
                setString(indice++, "Tel", preparedStatement);
            }
            for (Celular celular : cidadao.getCelulares()) {
                setInt(indice++, celular.getDDD().getNumero(), preparedStatement);
                setString(indice++, celular.getNumero(), preparedStatement);
                setString(indice++, "Cel", preparedStatement);
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

    public CidadaoComboBox pesquisarTodosLogradouroEstadoBairroCidadeTelefoneCelularDDD() {
        CidadaoComboBox cidadaoComboBox = new CidadaoComboBox();
        Connection connection = conexao.getConnection();
        try {
            String valorDoComandoUm = comandos.get("pesquisarTodosLogradouroEstadoBairroCidadeTelefoneCelularDDD");
            PreparedStatement preparedStatement = connection.prepareStatement(valorDoComandoUm);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String valor1 = resultSet.getString("valor1");
                String valor2 = resultSet.getString("valor2");
                Integer codigo = resultSet.getInt("codigo");
                String tipo = resultSet.getString("tipo");
                Integer fk = resultSet.getInt("fk");
                switch (tipo) {
                    case "logradouro":
                        Logradouro logradouro = new Logradouro();
                        logradouro.setNome(valor1);
                        cidadaoComboBox.getLogradouros().add(logradouro);
                        break;
                    case "estado":
                        Estado estado = new Estado();
                        estado.setCodigo(codigo);
                        estado.setNome(valor1);
                        estado.setUf(valor2);
                        cidadaoComboBox.getEstados().add(estado);
                        break;
                    case "bairro":
                        Bairro bairro = new Bairro();
                        bairro.setCodigo(codigo);
                        bairro.setNome(valor1);
                        Cidade cidade = new Cidade();
                        cidade.setCodigo(fk);
                        bairro.setCidade(cidade);
                        cidadaoComboBox.getBairros().add(bairro);
                        break;
                    case "cidade":
                        cidade = new Cidade();
                        cidade.setCodigo(codigo);
                        cidade.setNome(valor1);
                        estado = new Estado();
                        estado.setCodigo(fk);
                        cidade.setEstado(estado);
                        cidadaoComboBox.getCidades().add(cidade);
                        break;
                    case "telefone":
                        Telefone telefone = new Telefone();
                        telefone.setCodigo(codigo);
                        telefone.setNumero(valor1);
                        DDD ddd = new DDD();
                        ddd.setNumero(fk);
                        telefone.setDDD(ddd);
                        cidadaoComboBox.getTelefones().add(telefone);
                        break;
                    case "celular":
                        Celular celular = new Celular();
                        celular.setCodigo(codigo);
                        celular.setNumero(valor1);
                        ddd = new DDD();
                        ddd.setNumero(fk);
                        celular.setDDD(ddd);
                        cidadaoComboBox.getCelulares().add(celular);
                        break;
                    default:
                        ddd = new DDD();
                        ddd.setNumero(Integer.valueOf(valor1));
                        estado = new Estado();
                        estado.setCodigo(fk);
                        ddd.setEstado(estado);
                        cidadaoComboBox.getDDDs().add(ddd);
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
        return cidadaoComboBox;
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
