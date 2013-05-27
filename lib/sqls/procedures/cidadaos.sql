CREATE PROCEDURE inserir_estado
 @nome VARCHAR(25),
 @uf CHAR(2)
 AS
 BEGIN
 INSERT INTO estados(nome, uf) VALUES (@nome, @uf)
 RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_ddd
 @numero TINYINT,
 @estado TINYINT
 AS
 BEGIN
 INSERT INTO ddds(numero, estado) VALUES (@numero, @estado)
 RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_cidade
    @cidade_nome VARCHAR(25),
    @cidade_estado_codigo TINYINT
    AS
    BEGIN
       INSERT INTO cidades(nome, estado) VALUES (@cidade_nome, @cidade_estado_codigo)
       RETURN SCOPE_IDENTITY()
    END;

CREATE PROCEDURE inserir_bairro
    @bairro_nome VARCHAR(25),
    @bairro_cidade_codigo INT
    AS
    BEGIN
        INSERT INTO bairros(nome, cidade) VALUES (@bairro_nome, @bairro_cidade_codigo)
        RETURN SCOPE_IDENTITY()
    END;

CREATE PROCEDURE inserir_cidadao
    @cidadao_nome_completo VARCHAR(100),
    @cidadao_logradouro VARCHAR(30),
    @cidadao_numero_imovel INT,
    @cidadao_bairro_codigo INT,
    @cidadao_bairro_nome VARCHAR(50),
    @cidadao_bairro_cidade_codigo INT,
    @cidadao_bairro_cidade_nome VARCHAR(25),
    @cidadao_bairro_cidade_estado_codigo TINYINT
    AS
    BEGIN
        IF @cidadao_bairro_cidade_codigo IS NULL AND @cidadao_bairro_cidade_nome IS NOT NULL
        BEGIN
            EXECUTE @cidadao_bairro_cidade_codigo = inserir_cidade @cidadao_bairro_cidade_nome, @cidadao_bairro_cidade_estado_codigo
        END
        IF @cidadao_bairro_codigo IS NULL AND @cidadao_bairro_nome IS NOT NULL
        BEGIN
            EXECUTE @cidadao_bairro_codigo = inserir_bairro @cidadao_bairro_nome, @cidadao_bairro_cidade_codigo
        END
        INSERT INTO cidadaos(nome_completo,logradouro,numero_imovel,bairro)
        VALUES (@cidadao_nome_completo,@cidadao_logradouro,@cidadao_numero_imovel,@cidadao_bairro_codigo)
        RETURN SCOPE_IDENTITY()
    END;

CREATE PROCEDURE inserir_cidadao_contato_voz
    @cidadao_contato_voz_cidadao_codigo INT,
    @cidadao_contato_voz_ddd_codigo TINYINT,
    @cidadao_contato_voz_numero CHAR(8),
    @cidadao_contato_voz_tipo CHAR(3)
    AS
    BEGIN
        INSERT INTO cidadaos_contatos_voz (cidadao,ddd,numero,tipo)
        VALUES (@cidadao_contato_voz_cidadao_codigo,@cidadao_contato_voz_ddd_codigo,@cidadao_contato_voz_numero,@cidadao_contato_voz_tipo)
    END;

CREATE PROCEDURE atualizar_cidadao
    @cidadao_codigo INT,
    @cidadao_nome_completo VARCHAR(100),
    @cidadao_logradouro VARCHAR(30),
    @cidadao_numero_imovel INT,
    @cidadao_bairro_codigo INT,
    @cidadao_bairro_nome VARCHAR(50),
    @cidadao_bairro_cidade_codigo INT,
    @cidadao_bairro_cidade_nome VARCHAR(25),
    @cidadao_bairro_cidade_estado_codigo TINYINT
    AS
    BEGIN
        IF @cidadao_bairro_cidade_codigo IS NULL
        BEGIN
            EXECUTE @cidadao_bairro_cidade_codigo = inserir_cidade @cidadao_bairro_cidade_nome, @cidadao_bairro_cidade_estado_codigo
        END
        IF @cidadao_bairro_codigo IS NULL
        BEGIN
            EXECUTE @cidadao_bairro_codigo = inserir_bairro @cidadao_bairro_nome, @cidadao_bairro_cidade_codigo
        END
        UPDATE cidadaos
        SET 
        nome_completo = @cidadao_nome_completo,
        logradouro = @cidadao_logradouro,
        numero_imovel = @cidadao_numero_imovel,
        bairro = @cidadao_bairro_codigo
        WHERE codigo = @cidadao_codigo
    END;

CREATE PROCEDURE atualizar_cidadao_contato_voz
    @cidadao_contato_voz_codigo INT,
    @cidadao_contato_voz_cidadao_codigo INT,
    @cidadao_contato_voz_ddd_codigo TINYINT,
    @cidadao_contato_voz_numero CHAR(8),
    @cidadao_contato_voz_tipo CHAR(3)
    AS
    BEGIN
        IF @cidadao_contato_voz_codigo IS NULL AND @cidadao_contato_voz_cidadao_codigo IS NULL 
        BEGIN
            DELETE FROM cidadaos_contatos_voz 
            WHERE codigo = @cidadao_contato_voz_codigo
        END
        ELSE IF @cidadao_contato_voz_codigo IS NOT NULL
        BEGIN
            UPDATE cidadaos_contatos_voz 
            SET
            ddd = @cidadao_contato_voz_ddd_codigo,
            numero = @cidadao_contato_voz_numero,
            tipo = @cidadao_contato_voz_tipo
            WHERE codigo = @cidadao_contato_voz_codigo
        END
        ELSE
        BEGIN
            EXECUTE inserir_cidadao_contato_voz
            @cidadao_contato_voz_cidadao_codigo,
            @cidadao_contato_voz_ddd_codigo,
            @cidadao_contato_voz_numero,
            @cidadao_contato_voz_tipo
        END
    END;

CREATE PROCEDURE excluir_cidadao
    @cidadao_codigo INT
    AS
    BEGIN
        DELETE FROM cidadaos
        WHERE codigo = @cidadao_codigo
    END;