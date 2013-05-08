CREATE PROCEDURE inserir_editora
 @nome VARCHAR(100)
 AS
 BEGIN
  INSERT INTO editoras (nome) VALUES (@nome)
  RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_categoria
 @nome VARCHAR(50)
 AS
 BEGIN
 INSERT INTO categorias(nome) VALUES (@nome)
 RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_publico
 @nome VARCHAR(50)
 AS
 BEGIN
 INSERT INTO publicos(nome) VALUES (@nome)
 RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_formato
 @nome VARCHAR(20)
 AS
 BEGIN
 INSERT INTO formatos(nome) VALUES (@nome)
 RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_dado_material
 @titulo VARCHAR(50),
 @descricao VARCHAR(100),
 @edicao TINYINT,
 @ano_publicacao SMALLINT,
 @autor VARCHAR(50),
 @editora_codigo INT,
 @editora_nome VARCHAR(100),
 @categoria_codigo TINYINT,
 @categoria_nome VARCHAR(50),
 @publico_codigo TINYINT,
 @publico_nome VARCHAR(50)
 AS
 BEGIN
  IF @editora_codigo IS NULL
  BEGIN
   EXECUTE @editora_codigo = inserir_editora @editora_nome
  END
  IF @categoria_codigo IS NULL
  BEGIN
   EXECUTE @categoria_codigo = inserir_categoria @categoria_nome
  END
  IF @publico_codigo IS NULL
  BEGIN
   EXECUTE @publico_codigo = inserir_publico @publico_nome
  END
  INSERT INTO dados_materiais (titulo,descricao,edicao,ano_publicacao,autor,editora,categoria,publico)
  VALUES (@titulo,@descricao,@edicao,@ano_publicacao,@autor,@editora_codigo,@categoria_codigo,@publico_codigo)
  RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_material
 @dado_material_codigo INT,
 @formato_codigo TINYINT,
 @formato_nome VARCHAR(20),
 @informacao VARCHAR(255),
 @local_logico_fisico VARCHAR(100)
 AS
 BEGIN
  IF @formato_codigo IS NULL
  BEGIN
   EXECUTE @formato_codigo = inserir_formato @formato_nome
  END
  INSERT INTO materiais (dado_material,formato,informacao,local_logico_fisico)
  VALUES (@dado_material_codigo,@formato_codigo,@informacao,@local_logico_fisico)
 END;

CREATE PROCEDURE atualizar_dado_material
 @dado_material_codigo INT,
 @dado_material_titulo VARCHAR(50),
 @dado_material_descricao VARCHAR(100),
 @dado_material_edicao TINYINT,
 @dado_material_ano_publicacao SMALLINT,
 @dado_material_autor VARCHAR(50),
 @dado_material_editora_codigo INT,
 @dado_material_editora_nome VARCHAR(100),
 @dado_material_categoria_codigo TINYINT,
 @dado_material_categoria_nome VARCHAR(50),
 @dado_material_publico_codigo TINYINT,
 @dado_material_publico_nome VARCHAR(50)
 AS
 BEGIN
  IF @dado_material_editora_codigo IS NULL
  BEGIN
   EXECUTE @dado_material_editora_codigo = inserir_editora @dado_material_editora_nome
  END
  IF @dado_material_categoria_codigo IS NULL
  BEGIN
   EXECUTE @dado_material_categoria_codigo = inserir_categoria @dado_material_categoria_nome
  END
  IF @dado_material_publico_codigo IS NULL
  BEGIN
   EXECUTE @dado_material_publico_codigo = inserir_publico @dado_material_publico_nome
  END
  UPDATE 
  dados_materiais 
  SET 
  titulo = @dado_material_titulo, descricao = @dado_material_descricao, 
  edicao = @dado_material_edicao, ano_publicacao = @dado_material_ano_publicacao,
  autor = @dado_material_autor, editora = @dado_material_editora_codigo,
  categoria = @dado_material_categoria_codigo, publico = @dado_material_publico_codigo
  WHERE 
  codigo = @dado_material_codigo
 END;

CREATE PROCEDURE atualizar_material
 @material_codigo INT,
 @material_informacao VARCHAR(255),
 @material_local_logico_fisico VARCHAR(100),
 @material_formato_codigo TINYINT,
 @material_formato_nome VARCHAR(20),
 @material_dado_material_codigo INT,
 @material_dado_material_titulo VARCHAR(50),
 @material_dado_material_descricao VARCHAR(100),
 @material_dado_material_edicao TINYINT,
 @material_dado_material_ano_publicacao SMALLINT,
 @material_dado_material_autor VARCHAR(50),
 @material_dado_material_editora_codigo INT,
 @material_dado_material_editora_nome VARCHAR(100),
 @material_dado_material_categoria_codigo TINYINT,
 @material_dado_material_categoria_nome VARCHAR(50),
 @material_dado_material_publico_codigo TINYINT,
 @material_dado_material_publico_nome VARCHAR(50)
 AS
 BEGIN
  IF @material_formato_codigo IS NULL
  BEGIN
   EXECUTE @material_formato_codigo = inserir_formato @material_formato_nome
  END
  UPDATE 
  materiais 
  SET formato = @material_formato_codigo, informacao = @material_informacao,
  local_logico_fisico = @material_local_logico_fisico
  WHERE
  codigo = @material_codigo
  EXECUTE atualizar_dado_material 
  @material_dado_material_codigo, @material_dado_material_titulo,
  @material_dado_material_descricao, @material_dado_material_edicao,
  @material_dado_material_ano_publicacao, @material_dado_material_autor,
  @material_dado_material_editora_codigo, @material_dado_material_editora_nome,
  @material_dado_material_categoria_codigo, @material_dado_material_categoria_nome,
  @material_dado_material_publico_codigo, @material_dado_material_publico_nome
 END