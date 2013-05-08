cadastrarCidadao;
DECLARE
    @cidadaos_nome_completo VARCHAR(100) = ?,
    @cidadaos_logradouro VARCHAR(30) = ?,
    @cidadaos_numero_imovel INT = ?,
    @cidadaos_bairro INT = ?
    EXECUTE inserir_cidadao @cidadaos_nome_completo,@cidadaos_logradouro,
        @cidadaos_numero_imovel,@cidadaos_bairro;

cadastrarContatoVozCidadao;
DECLARE
    @cidadaos_contatos_voz_cidadao INT = ?,
    @cidadaos_contatos_voz_ddd TINYINT = ?,
    @cidadaos_contatos_voz_numero CHAR(8) = ?,
    @cidadaos_contatos_voz_tipo CHAR(3) = ?
    EXECUTE inserir_cidadao_contato_voz @cidadaos_contatos_voz_cidadao,
    @cidadaos_contatos_voz_ddd,@cidadaos_contatos_voz_numero,
    @cidadaos_contatos_voz_tipo;

cadatrarCidadaoComContato;
DECLARE
    @cidadaos_nome_completo VARCHAR(100) = ?,
    @cidadaos_logradouro VARCHAR(30) = ?,
    @cidadaos_numero_imovel INT = ?,
    @cidadaos_bairro INT = ?,
    @contato_voz_contatos_voz_ddd TINYINT = ?,
    @contato_voz_contatos_voz_numero CHAR(8) = ?,
    @contato_voz_contatos_voz_tipo CHAR(3) = ?
    
    EXECUTE inserir_cidadao_com_contato @cidadaos_nome_completo,@cidadaos_logradouro,
        @cidadaos_numero_imovel,@cidadaos_bairro,@contato_voz_ddd,@contato_voz_numero,
        @contato_voz_tipo;
