excluirPeloCodigo;
DECLARE 
    @cidadao_codigo INT = ?
    EXECUTE excluir_cidadao
    @cidadao_codigo;