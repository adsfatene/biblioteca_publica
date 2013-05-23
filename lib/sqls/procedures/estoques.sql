CREATE PROCEDURE estocar_novo
 @estoque_material_codigo INT,
 @estoque_local_logico_fisico VARCHAR(100)
 AS
 BEGIN
  INSERT INTO estoques 
  VALUES (@estoque_material_codigo, 'Novo', @estoque_local_logico_fisico)
 END;