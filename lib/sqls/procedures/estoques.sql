CREATE PROCEDURE estocar_novo
 @estoque_material_codigo INT,
 @estoque_local_logico_fisico VARCHAR(100)
 AS
 BEGIN
  INSERT INTO estoques 
  VALUES (@estoque_material_codigo, 'Novo', @estoque_local_logico_fisico)
 END;

CREATE PROCEDURE atualizar_local_logico_fisico
 @estoque_material_codigo INT,
 @estoque_local_logico_fisico VARCHAR(100)
 AS
 BEGIN
  UPDATE estoques 
  SET local_logico_fisico = @estoque_local_logico_fisico
  WHERE material = @estoque_material_codigo 
 END;

CREATE PROCEDURE remover_estoque
 @estoque_material_codigo INT
 AS
 BEGIN
  DELETE FROM
  estoques 
  WHERE
  material = @estoque_material_codigo
 END;