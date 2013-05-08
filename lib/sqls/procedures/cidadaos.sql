CREATE PROCEDURE inserir_estado
 @nome VARCHAR(25),
 @uf CHAR(2)
 AS
 BEGIN
 INSERT INTO estados(nome, uf) VALUES (@nome, @uf)
 RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_cidade
 @nome VARCHAR(25),
 @estado TINYINT
 AS
 BEGIN
 INSERT INTO cidades(nome, estado) VALUES (@nome, @estado)
 RETURN SCOPE_IDENTITY()
 END;

CREATE PROCEDURE inserir_bairro
 @nome VARCHAR(25),
 @cidade INT
 AS
 BEGIN
 INSERT INTO bairros(nome, cidade) VALUES (@nome, @cidade)
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

CREATE PROCEDURE inserir_cidadao
    @nome_completo VARCHAR(100),
    @logradouro VARCHAR(30),
    @numero_imovel INT,
    @bairro INT
    AS
    BEGIN
       INSERT INTO cidadaos(nome_completo,logradouro,numero_imovel,bairro)
       VALUES (@nome_completo,@logradouro,@numero_imovel,@bairro)
       RETURN SCOPE_IDENTITY()
    END;

CREATE PROCEDURE inserir_cidadao_contato_voz
    @cidadao INT,
    @ddd TINYINT,
    @numero CHAR(8),
    @tipo CHAR(3)
    AS
    BEGIN
        INSERT INTO cidadaos_contatos_voz (cidadao,ddd,numero,tipo)
        VALUES (@cidadao,@ddd,@numero,@tipo)
    END;

CREATE PROCEDURE inserir_cidadao_com_contato
    @nome_completo VARCHAR(100),
    @logradouro VARCHAR(30),
    @numero_imovel INT,
    @bairro INT,
    @ddd TINYINT,
    @numero CHAR(8),
    @tipo CHAR(3)
    AS
    BEGIN
        INSERT INTO cidadaos(nome_completo,logradouro,numero_imovel,bairro)
	VALUES (@nome_completo,@logradouro,@numero_imovel,@bairro)
	DECLARE @codigo_cidadao INT = SCOPE_IDENTITY()
	INSERT INTO cidadaos_contatos_voz (cidadao,ddd,numero,tipo)
        VALUES (@codigo_cidadao,@ddd,@numero,@tipo)
	RETURN @codigo_cidadao
    END;