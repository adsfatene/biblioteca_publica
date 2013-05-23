CREATE VIEW estoques_view AS
 SELECT 
 m_v.material_codigo AS estoque_material_codigo, 
 m_v.material_data_hora_cadastro AS estoque_material_data_hora_cadastro, 
 m_v.material_informacao AS estoque_material_informacao, 
 m_v.material_formato_codigo AS estoque_material_formato_codigo, 
 m_v.material_formato_nome AS estoque_material_formato_nome,
 m_v.material_dado_material_codigo AS estoque_material_dado_material_codigo, 
 m_v.material_dado_material_titulo AS estoque_material_dado_material_titulo,
 m_v.material_dado_material_descricao AS estoque_material_dado_material_descricao,
 m_v.material_dado_material_edicao AS estoque_material_dado_material_edicao,
 m_v.material_dado_material_ano_publicacao AS estoque_material_dado_material_ano_publicacao,
 m_v.material_dado_material_autor AS estoque_material_dado_material_autor,
 m_v.material_dado_material_editora_codigo AS estoque_material_dado_material_editora_codigo, 
 m_v.material_dado_material_editora_nome AS estoque_material_dado_material_editora_nome,
 m_v.material_dado_material_categoria_codigo AS estoque_material_dado_material_categoria_codigo, 
 m_v.material_dado_material_categoria_nome AS estoque_material_dado_material_categoria_nome,
 m_v.material_dado_material_publico_codigo AS estoque_material_dado_material_publico_codigo, 
 m_v.material_dado_material_publico_nome AS estoque_material_dado_material_publico_nome,
 e.local_logico_fisico AS estoque_local_logico_fisico,
 e.statu AS estoque_statu
 FROM materiais_view AS m_v
 INNER JOIN estoques e ON m_v.material_codigo = e.material;