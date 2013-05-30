cadastarNovo1;
 DECLARE 
 @cidadao INT = ?,
 @data_hora_devolucao_prevista DATETIME = ?,
 @emprestimo INT,
 @estoque INT
 EXECUTE @emprestimo = inserir_emprestimo  @cidadao, @data_hora_devolucao_prevista;

cadastarNovo2;
 SET @estoque = ?
 EXECUTE inserir_emprestimo_estoque @emprestimo, @estoque;