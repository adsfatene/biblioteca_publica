excluirPeloCodigo;
DECLARE 
 @material_codigo INT = ?
 EXECUTE 
 excluir_material
 @material_codigo;
