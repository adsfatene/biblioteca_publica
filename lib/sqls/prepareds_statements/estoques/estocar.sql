estocarNovos1;
DECLARE 
 @estoque_material_codigo INT,
 @estoque_local_logico_fisico VARCHAR(100);

estocarNovos2;
 SET @estoque_material_codigo = ?
 SET @estoque_local_logico_fisico = ?
 EXECUTE estocar_novo @estoque_material_codigo, @estoque_local_logico_fisico;