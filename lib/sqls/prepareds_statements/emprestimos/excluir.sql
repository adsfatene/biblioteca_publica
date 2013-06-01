excluirPeloCodigo;
DECLARE 
 @emprestimo_codigo INT = ?
 EXECUTE 
 excluir_emprestimo
 @emprestimo_codigo;
