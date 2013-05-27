CREATE VIEW cidadaos_view AS
    SELECT 
    cddao.codigo AS cidadao_codigo, 
    cddao.nome_completo AS cidadao_nome_completo, 
    cddao.logradouro AS cidadao_logradouro, 
    cddao.numero_imovel AS cidadao_numero_imovel, 
    b.codigo AS cidadao_bairro_codigo, 
    b.nome AS cidadao_bairro_nome, 
    cdde.codigo AS cidadao_bairro_cidade_codigo, 
    cdde.nome AS cidadao_bairro_cidade_nome, 
    e.codigo AS cidadao_bairro_cidade_estado_codigo, 
    e.nome AS cidadao_bairro_cidade_estado_nome, 
    e.uf AS cidadao_bairro_cidade_estado_uf,
    cddao.data_hora_cadastro AS cidadao_data_hora_cadastro,
    ccv.cidadao_contato_voz_codigo,
    ccv.cidadao_contato_voz_cidadao_codigo,
    ccv.cidadao_contato_voz_numero,
    ccv.cidadao_contato_voz_tipo,
    ccv.cidadao_contato_voz_ddd_numero,
    ccv.cidadao_contato_voz_ddd_estado_codigo,
    ccv.cidadao_contato_voz_ddd_estado_nome,
    ccv.cidadao_contato_voz_ddd_estado_uf
    FROM cidadaos AS cddao 
    INNER JOIN bairros AS b ON cddao.bairro = b.codigo
    INNER JOIN cidades AS cdde ON b.cidade = cdde.codigo
    INNER JOIN estados AS e ON cdde.estado = e.codigo
    LEFT OUTER JOIN
    (
            SELECT 
            ccv.codigo AS cidadao_contato_voz_codigo,
            ccv.cidadao AS cidadao_contato_voz_cidadao_codigo,
            ccv.numero AS cidadao_contato_voz_numero,
            ccv.tipo AS cidadao_contato_voz_tipo,
            ddd.numero AS cidadao_contato_voz_ddd_numero,
            e.codigo AS cidadao_contato_voz_ddd_estado_codigo,
            e.nome AS cidadao_contato_voz_ddd_estado_nome,
            e.uf AS cidadao_contato_voz_ddd_estado_uf
            FROM cidadaos_contatos_voz AS ccv
            INNER JOIN ddds AS ddd ON ccv.ddd = ddd.numero
            INNER JOIN estados AS e ON ddd.estado = e.codigo
    ) AS ccv ON cddao.codigo = ccv.cidadao_contato_voz_cidadao_codigo;

CREATE VIEW cidadaos_combobox_view AS
    SELECT DISTINCT(logradouro) AS valor1, '' AS valor2, -1 AS codigo, 'logradouro' AS tipo, -1 AS FK FROM cidadaos
    UNION
    SELECT nome AS valor1, uf AS valor2, codigo, 'estado' AS tipo, -1 AS FK FROM estados
    UNION
    SELECT nome AS valor1, '' AS valor2, codigo, 'bairro' AS tipo, cidade AS FK FROM bairros
    UNION
    SELECT nome AS valor1, '' AS valor2, codigo, 'cidade' AS tipo, estado AS FK FROM cidades
    UNION
    SELECT numero AS valor1, '' AS valor2, codigo, 'celular' AS tipo, ddd AS FK FROM cidadaos_contatos_voz WHERE LOWER(tipo) = 'cel'
    UNION
    SELECT numero AS valor1, '' AS valor2, codigo, 'telefone' AS tipo, ddd AS FK FROM cidadaos_contatos_voz WHERE LOWER(tipo) = 'tel'
    UNION
    SELECT CAST(numero AS VARCHAR) AS valor1, '' AS valor2, -1 codigo, 'ddd' AS tipo, estado AS FK FROM ddds;