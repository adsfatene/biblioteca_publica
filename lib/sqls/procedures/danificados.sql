CREATE PROCEDURE restaurar_danificado
    @emprestimo_estoque_codigo INT
    AS
    BEGIN
        UPDATE estoques SET statu = 'Restaurado' WHERE material = 
        (
            SELECT estoque FROM emprestimos_estoques WHERE codigo = @emprestimo_estoque_codigo
        )
    END;