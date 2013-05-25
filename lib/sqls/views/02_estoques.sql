CREATE VIEW estoques_view AS
 SELECT 
 m.codigo AS estoque_material_codigo, 
 m.data_hora_cadastro  AS estoque_material_data_hora_cadastro, 
 m.informacao AS estoque_material_informacao, 
 f.codigo AS estoque_material_formato_codigo, 
 f.nome AS estoque_material_formato_nome,
 d_m.codigo AS estoque_material_dado_material_codigo, 
 d_m.titulo AS estoque_material_dado_material_titulo,
 d_m.descricao AS estoque_material_dado_material_descricao,
 d_m.edicao AS estoque_material_dado_material_edicao,
 d_m.ano_publicacao AS estoque_material_dado_material_ano_publicacao,
 d_m.autor AS estoque_material_dado_material_autor,
 e.codigo AS estoque_material_dado_material_editora_codigo, 
 e.nome AS estoque_material_dado_material_editora_nome,
 c.codigo AS estoque_material_dado_material_categoria_codigo, 
 c.nome AS estoque_material_dado_material_categoria_nome,
 p.codigo AS estoque_material_dado_material_publico_codigo, 
 p.nome AS estoque_material_dado_material_publico_nome,
 est.local_logico_fisico AS estoque_local_logico_fisico,
 est.statu AS estoque_statu
 FROM materiais AS m
 INNER JOIN estoques AS est ON m.codigo = est.material
 INNER JOIN formatos AS f ON m.formato = f.codigo
 INNER JOIN dados_materiais AS d_m ON m.dado_material = d_m.codigo
 INNER JOIN editoras AS e ON d_m.editora = e.codigo
 INNER JOIN categorias AS c ON d_m.categoria = c.codigo
 INNER JOIN publicos AS p ON d_m.publico = p.codigo;

CREATE VIEW estoques_combobox_view AS
 SELECT DISTINCT(CAST(estoque_material_dado_material_edicao AS VARCHAR)) AS valor, -1 AS codigo, 'edicao' AS tipo FROM estoques_view
 UNION
 SELECT DISTINCT(CAST(estoque_material_dado_material_ano_publicacao AS VARCHAR)) AS valor, -1 AS codigo, 'ano_publicacao' AS tipo FROM estoques_view
 UNION
 SELECT DISTINCT(CAST(estoque_material_dado_material_autor AS VARCHAR)) AS valor, -1 AS codigo, 'autor' AS tipo FROM estoques_view
 UNION
 SELECT DISTINCT(CAST(estoque_material_dado_material_editora_nome AS VARCHAR)) AS valor, estoque_material_dado_material_editora_codigo, 'editora' AS tipo FROM estoques_view
 UNION
 SELECT DISTINCT(CAST(estoque_material_dado_material_categoria_nome AS VARCHAR)) AS valor, estoque_material_dado_material_categoria_codigo, 'categoria' AS tipo FROM estoques_view
 UNION
 SELECT DISTINCT(CAST(estoque_material_dado_material_publico_nome AS VARCHAR)) AS valor, estoque_material_dado_material_publico_codigo, 'publico' AS tipo FROM estoques_view
 UNION
 SELECT DISTINCT(CAST(estoque_material_formato_nome AS VARCHAR)) AS valor, estoque_material_formato_codigo, 'formato' AS tipo FROM estoques_view
 UNION
 SELECT DISTINCT(CAST(estoque_statu AS VARCHAR)) AS valor, -1 AS codigo, 'statu' AS tipo FROM estoques_view;