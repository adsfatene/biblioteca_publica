removerPeloCodigo;
DECLARE 
 @estoque_material_codigo INT = ?
 EXECUTE 
 remover_estoque
 @estoque_material_codigo;
