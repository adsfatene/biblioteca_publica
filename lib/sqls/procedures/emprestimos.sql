CREATE PROCEDURE inserir_emprestimo
    @cidadao INT,
    @data_hora_devolucao_prevista DATETIME
    AS
    BEGIN
        INSERT INTO emprestimos (cidadao, data_hora_devolucao_prevista)
        VALUES (@cidadao, @data_hora_devolucao_prevista)
        RETURN SCOPE_IDENTITY()
    END;

CREATE PROCEDURE inserir_emprestimo_estoque
    @emprestimo INT,
    @estoque INT
    AS
    BEGIN
        INSERT INTO emprestimos_estoques (emprestimo, estoque)
        VALUES (@emprestimo, @estoque)
    END;

CREATE PROCEDURE concluir_emprestimo
    @emprestimo_codigo INT
    AS
    BEGIN
        UPDATE emprestimos SET 
        data_hora_devolucao_efetiva = GETDATE()
        WHERE codigo = @emprestimo_codigo
    END;

CREATE PROCEDURE concluir_emprestimo_estoque
    @emprestimo_estoque_codigo INT,
    @estado_devolucao VARCHAR(13),
    @motivo VARCHAR(160)
    AS
    BEGIN
        IF @estado_devolucao = 'Perfeito'
        BEGIN
            UPDATE estoques SET statu = 'Usado' WHERE material = 
            (
                SELECT estoque FROM emprestimos_estoques WHERE codigo = @emprestimo_estoque_codigo
            )
        END
        ELSE
        BEGIN
            UPDATE estoques SET statu = NULL WHERE material = 
            (
                SELECT estoque FROM emprestimos_estoques WHERE codigo = @emprestimo_estoque_codigo
            )
        END
        UPDATE emprestimos_estoques 
        SET 
        estado_devolucao = @estado_devolucao, motivo = @motivo 
        WHERE codigo = @emprestimo_estoque_codigo
    END;

CREATE PROCEDURE excluir_emprestimo
    @codigo INT
    AS
    BEGIN
        DELETE FROM emprestimos WHERE codigo = @codigo
    END;