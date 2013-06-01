concluir1;
DECLARE 
    @codigo_emprestimo INT = ?,
    @codigo_emprestimo_estoque INT,
    @estado_devolucao VARCHAR(13),
    @motivo VARCHAR(160)
    EXECUTE concluir_emprestimo @codigo_emprestimo;

concluir2;
    SET @codigo_emprestimo_estoque = ?
    SET @estado_devolucao = ?
    SET @motivo = ?
    EXECUTE concluir_emprestimo_estoque 
    @codigo_emprestimo_estoque,
    @estado_devolucao,
    @motivo;
