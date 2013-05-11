CREATE VIEW materiais_view AS
 SELECT 
 m.codigo AS material_codigo, 
 m.data_hora_cadastro  AS material_data_hora_cadastro, 
 m.informacao AS material_informacao, 
 m.local_logico_fisico AS material_local_logico_fisico,
 f.codigo AS material_formato_codigo, 
 f.nome AS material_formato_nome,
 d_m.codigo AS material_dado_material_codigo, 
 d_m.titulo AS material_dado_material_titulo,
 d_m.descricao AS material_dado_material_descricao,
 d_m.edicao AS material_dado_material_edicao,
 d_m.ano_publicacao AS material_dado_material_ano_publicacao,
 d_m.autor AS material_dado_material_autor,
 e.codigo AS material_dado_material_editora_codigo, 
 e.nome AS material_dado_material_editora_nome,
 c.codigo AS material_dado_material_categoria_codigo, 
 c.nome AS material_dado_material_categoria_nome,
 p.codigo AS material_dado_material_publico_codigo, 
 p.nome AS material_dado_material_publico_nome
 FROM materiais AS m
 INNER JOIN formatos AS f ON m.formato = f.codigo
 INNER JOIN dados_materiais AS d_m ON m.dado_material = d_m.codigo
 INNER JOIN editoras AS e ON d_m.editora = e.codigo
 INNER JOIN categorias AS c ON d_m.categoria = c.codigo
 INNER JOIN publicos AS p ON d_m.publico = p.codigo;

CREATE VIEW materiais_combobox_view AS
 SELECT DISTINCT(CAST(d_m.edicao AS VARCHAR)) AS valor, -1 AS codigo, 'edicao' AS tipo FROM dados_materiais AS d_m
 UNION
 SELECT DISTINCT(CAST(d_m.ano_publicacao AS VARCHAR)) AS valor, '-1' AS codigo, 'ano_publicacao' AS tipo FROM dados_materiais AS d_m
 UNION
 SELECT DISTINCT(CAST(d_m.autor AS VARCHAR)) AS valor, '-1' AS codigo, 'autor' AS tipo FROM dados_materiais AS d_m
 UNION
 SELECT nome AS valor, codigo, 'editora' AS tipo FROM editoras
 UNION
 SELECT nome AS valor, codigo, 'categoria' AS tipo FROM categorias
 UNION
 SELECT nome AS valor, codigo, 'publico' AS tipo FROM publicos
 UNION
 SELECT nome AS valor, codigo, 'formato' AS tipo FROM formatos;