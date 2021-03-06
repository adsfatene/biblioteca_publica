cadastarNovo1;
 DECLARE 
    @cidadao_nome_completo VARCHAR(100) = ?,
    @cidadao_logradouro VARCHAR(30) = ?,
    @cidadao_numero_imovel INT = ?,
    @cidadao_bairro_codigo INT = ?,
    @cidadao_bairro_nome VARCHAR(50) = ?,
    @cidadao_bairro_cidade_codigo INT = ?,
    @cidadao_bairro_cidade_nome VARCHAR(25) = ?,
    @cidadao_bairro_cidade_estado_codigo TINYINT = ?,
    @cidadao_contato_voz_cidadao_codigo INT,
    @cidadao_contato_voz_ddd_numero TINYINT,
    @cidadao_contato_voz_numero CHAR(8),
    @cidadao_contato_voz_tipo CHAR(3)
    EXECUTE @cidadao_contato_voz_cidadao_codigo = inserir_cidadao
    @cidadao_nome_completo,
    @cidadao_logradouro,
    @cidadao_numero_imovel,
    @cidadao_bairro_codigo,
    @cidadao_bairro_nome,
    @cidadao_bairro_cidade_codigo,
    @cidadao_bairro_cidade_nome,
    @cidadao_bairro_cidade_estado_codigo;

cadastarNovo2;
    SET @cidadao_contato_voz_ddd_numero = ?
    SET @cidadao_contato_voz_numero = ?
    SET @cidadao_contato_voz_tipo = ?
    EXECUTE inserir_cidadao_contato_voz
    @cidadao_contato_voz_cidadao_codigo,
    @cidadao_contato_voz_ddd_numero,
    @cidadao_contato_voz_numero,
    @cidadao_contato_voz_tipo;