restaurar;
DECLARE 
    @emprestimo_estoque_codigo INT = ?
    EXECUTE restaurar_danificado @emprestimo_estoque_codigo;