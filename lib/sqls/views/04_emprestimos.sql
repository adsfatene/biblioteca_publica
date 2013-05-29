CREATE VIEW emprestimos_view
    AS
    SELECT
    e.codigo AS emprestimo_codigo,
    e.data_hora_emprestado AS emprestimo_data_hora_emprestado,
    e.data_hora_devolucao_prevista AS emprestimo_data_hora_devolucao_prevista,
    e.data_hora_devolucao_efetiva AS emprestimo_data_hora_devolucao_efetiva,
    c_v.cidadao_codigo AS emprestimo_cidadao_codigo,
    c_v.cidadao_nome_completo AS emprestimo_cidadao_nome_completo,
    c_v.cidadao_logradouro AS emprestimo_cidadao_logradouro,
    c_v.cidadao_numero_imovel AS emprestimo_cidadao_numero_imovel,
    c_v.cidadao_data_hora_cadastro AS emprestimo_cidadao_data_hora_cadastro,
    c_v.cidadao_bairro_codigo AS emprestimo_cidadao_bairro_codigo,
    c_v.cidadao_bairro_nome AS emprestimo_cidadao_bairro_nome,
    c_v.cidadao_bairro_cidade_codigo AS emprestimo_cidadao_bairro_cidade_codigo,
    c_v.cidadao_bairro_cidade_nome AS emprestimo_cidadao_bairro_cidade_nome,
    c_v.cidadao_bairro_cidade_estado_codigo AS emprestimo_cidadao_bairro_cidade_estado_codigo,
    c_v.cidadao_bairro_cidade_estado_nome AS emprestimo_cidadao_bairro_cidade_estado_nome,
    c_v.cidadao_bairro_cidade_estado_uf AS emprestimo_cidadao_bairro_cidade_estado_uf,
    e_e.codigo AS emprestimo_emprestimo_estoque_codigo,
    e_e.estado_devolucao AS emprestimo_emprestimo_estoque_estado_devolucao,
    e_v.estoque_material_codigo AS emprestimo_estoque_material_codigo,
    e_v.estoque_material_dado_material_titulo AS emprestimo_estoque_material_dado_material_titulo,
    e_v.estoque_material_dado_material_descricao AS emprestimo_estoque_material_dado_material_descricao,
    e_v.estoque_material_dado_material_edicao AS emprestimo_estoque_material_dado_material_edicao,
    e_v.estoque_material_dado_material_ano_publicacao AS emprestimo_estoque_material_dado_material_ano_publicacao,
    e_v.estoque_material_dado_material_autor AS emprestimo_estoque_material_dado_material_autor,
    e_v.estoque_material_dado_material_editora_codigo AS emprestimo_estoque_material_dado_material_editora_codigo,
    e_v.estoque_material_dado_material_editora_nome AS emprestimo_estoque_material_dado_material_editora_nome,
    e_v.estoque_material_dado_material_categoria_codigo AS emprestimo_estoque_material_dado_material_categoria_codigo,
    e_v.estoque_material_dado_material_categoria_nome AS emprestimo_estoque_material_dado_material_categoria_nome,
    e_v.estoque_material_dado_material_publico_codigo AS emprestimo_estoque_material_dado_material_publico_codigo,
    e_v.estoque_material_dado_material_publico_nome AS emprestimo_estoque_material_dado_material_publico_nome,
    e_v.estoque_material_formato_codigo AS emprestimo_estoque_material_formato_codigo,
    e_v.estoque_material_formato_nome AS emprestimo_estoque_material_formato_nome,
    e_v.estoque_material_informacao AS emprestimo_estoque_material_informacao,
    e_v.estoque_material_data_hora_cadastro AS emprestimo_estoque_material_data_hora_cadastro,
    e_v.estoque_local_logico_fisico AS emprestimo_estoque_local_logico_fisico,
    e_v.estoque_statu AS emprestimo_estoque_statu
    FROM emprestimos AS e
    INNER JOIN cidadaos_view AS c_v ON e.cidadao = c_v.cidadao_codigo 
    INNER JOIN emprestimos_estoques AS e_e ON e.codigo = e_e.emprestimo
    INNER JOIN estoques_view AS e_v ON e_e.estoque = e_v.estoque_material_codigo;