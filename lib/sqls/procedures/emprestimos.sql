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

CREATE PROCEDURE atualizar_emprestimo
    @codigo INT
    AS
    BEGIN
        UPDATE emprestimos SET 
        data_hora_devolucao_efetiva = GETDATE()
        WHERE codigo = @codigo
    END;

CREATE PROCEDURE atualizar_emprestimo_estoque
    @codigo INT,
    @estado_devolucao VARCHAR(13),
    @motivo VARCHAR(160)
    AS
    BEGIN
        IF @estado_devolucao IN ('Perfeito')
        BEGIN
            UPDATE estoques SET statu = 'Usado' WHERE material = 
            (
                SELECT estoque FROM emprestimos_estoques WHERE codigo = @codigo
            )
        END
        ELSE 
        BEGIN
            INSERT INTO estoques_danificados (emprestimo_estoque,motivo,tipo)
            VALUES (@codigo,@motivo,@estado_devolucao)
        END
    END;

CREATE PROCEDURE excluir_emprestimo
    @codigo INT
    AS
    BEGIN
        DELETE FROM emprestimos WHERE codigo = @codigo
    END;