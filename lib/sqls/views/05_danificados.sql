CREATE VIEW danificados_view
    AS
    SELECT
    DISTINCT(e.codigo) AS emprestimo_codigo,
    c_v.cidadao_codigo AS emprestimo_cidadao_codigo,
    c_v.cidadao_nome_completo AS emprestimo_cidadao_nome_completo,
    e_e.codigo AS emprestimo_emprestimo_estoque_codigo,
    e_e.estado_devolucao AS emprestimo_emprestimo_estoque_estado_devolucao,
    e_e.motivo AS emprestimo_emprestimo_estoque_motivo,
    e_v.estoque_material_codigo AS emprestimo_estoque_material_codigo,
    e_v.estoque_material_dado_material_titulo AS emprestimo_estoque_material_dado_material_titulo,
    e_v.estoque_material_formato_codigo AS emprestimo_estoque_material_formato_codigo,
    e_v.estoque_material_formato_nome AS emprestimo_estoque_material_formato_nome,
    e.data_hora_devolucao_efetiva AS emprestimo_data_hora_devolucao_efetiva
    FROM emprestimos AS e
    INNER JOIN cidadaos_view AS c_v ON e.cidadao = c_v.cidadao_codigo 
    INNER JOIN emprestimos_estoques AS e_e ON e.codigo = e_e.emprestimo
    INNER JOIN estoques_view AS e_v ON e_e.estoque = e_v.estoque_material_codigo
    WHERE e_e.estado_devolucao IN ('Avariado', 'Irrecuperavel') 
    AND e_v.estoque_statu IS NULL;