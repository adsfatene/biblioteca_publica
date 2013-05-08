cadastarNovo1;
 DECLARE 
 @dado_material_titulo VARCHAR(50) = ?,
 @dado_material_descricao VARCHAR(100) = ?,
 @dado_material_edicao TINYINT = ?,
 @dado_material_ano_publicacao SMALLINT = ?,
 @dado_material_autor VARCHAR(50) = ?,
 @dado_material_editora_codigo INT = ?,
 @dado_material_editora_nome VARCHAR(100) = ?,
 @dado_material_categoria_codigo TINYINT = ?,
 @dado_material_categoria_nome VARCHAR(50) = ?,
 @dado_material_publico_codigo TINYINT = ?,
 @dado_material_publico_nome VARCHAR(50) = ?,
 @dado_material_codigo INT,
 @formato_codigo TINYINT,
 @formato_nome VARCHAR(20),
 @informacao VARCHAR(255),
 @local_logico_fisico VARCHAR(100)
 EXECUTE @dado_material_codigo = inserir_dado_material @dado_material_titulo,
 @dado_material_descricao, @dado_material_edicao, @dado_material_ano_publicacao,
 @dado_material_autor, @dado_material_editora_codigo,
 @dado_material_editora_nome, @dado_material_categoria_codigo, @dado_material_categoria_nome,
 @dado_material_publico_codigo, @dado_material_publico_nome;

cadastarNovo2;
 SET @formato_codigo = ?
 SET @formato_nome = ?
 SET @informacao = ?
 SET @local_logico_fisico = ?
 EXECUTE inserir_material @dado_material_codigo,@formato_codigo,@formato_nome, @informacao, @local_logico_fisico;