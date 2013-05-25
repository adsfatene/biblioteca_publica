atualizarLocalLogicoFisico;
DECLARE 
 @estoque_material_codigo INT = ?,
 @estoque_local_logico_fisico VARCHAR(100) = ?
 EXECUTE 
 atualizar_local_logico_fisico
 @estoque_material_codigo, @estoque_local_logico_fisico;
