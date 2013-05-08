DECLARE @nome VARCHAR(25) = 'Acre', @uf CHAR(2) = 'AC', @codigo_estado TINYINT, 
    @ddd TINYINT = 68
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Alagoas' , @uf CHAR(2) = 'AL', @codigo_estado TINYINT, 
    @ddd TINYINT = 82
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Amapá' , @uf CHAR(2) = 'AP', @codigo_estado TINYINT, 
    @ddd TINYINT = 96
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Amazonas' , @uf CHAR(2) = 'AM', @codigo_estado TINYINT, 
    @ddd TINYINT = 92, @ddd2 TINYINT = 97
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Bahia' , @uf CHAR(2) = 'BA', @codigo_estado TINYINT, 
    @ddd TINYINT = 71, @ddd2 TINYINT = 73, @ddd3 TINYINT = 74, @ddd4 TINYINT = 75, @ddd5 TINYINT = 77
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado
    EXECUTE inserir_ddd @ddd4, @codigo_estado
    EXECUTE inserir_ddd @ddd5, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Ceará' , @uf CHAR(2) = 'CE', @codigo_estado TINYINT, 
    @ddd TINYINT = 85, @ddd2 TINYINT = 88
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Distrito Federal' , @uf CHAR(2) = 'DF', @codigo_estado TINYINT, 
    @ddd TINYINT = 61
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Espírito Santo' , @uf CHAR(2) = 'ES', @codigo_estado TINYINT,
    @ddd TINYINT = 27, @ddd2 TINYINT = 28
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Goiás' , @uf CHAR(2) = 'GO', @codigo_estado TINYINT,
    @ddd TINYINT = 61, @ddd2 TINYINT = 62, @ddd3 TINYINT = 64
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Maranhão' , @uf CHAR(2) = 'MA', @codigo_estado TINYINT,
    @ddd TINYINT = 98, @ddd2 TINYINT = 99
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Mato Grosso' , @uf CHAR(2) = 'MT', @codigo_estado TINYINT,
    @ddd TINYINT = 65, @ddd2 TINYINT = 66
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Mago Grosso do Sul' , @uf CHAR(2) = 'MS', @codigo_estado TINYINT, 
    @ddd TINYINT = 67
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Minas Gerais' , @uf CHAR(2) = 'MG', @codigo_estado TINYINT, 
    @ddd TINYINT = 31, @ddd2 TINYINT = 32, @ddd3 TINYINT = 33, @ddd4 TINYINT = 34, 
    @ddd5 TINYINT = 35, @ddd6 TINYINT = 37, @ddd7 TINYINT = 38
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado
    EXECUTE inserir_ddd @ddd4, @codigo_estado
    EXECUTE inserir_ddd @ddd5, @codigo_estado
    EXECUTE inserir_ddd @ddd6, @codigo_estado
    EXECUTE inserir_ddd @ddd7, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Paraná' , @uf CHAR(2) = 'PR', @codigo_estado TINYINT, 
    @ddd TINYINT = 41, @ddd2 TINYINT = 42, @ddd3 TINYINT = 43, @ddd4 TINYINT = 44, 
    @ddd5 TINYINT = 45, @ddd6 TINYINT = 46
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado
    EXECUTE inserir_ddd @ddd4, @codigo_estado
    EXECUTE inserir_ddd @ddd5, @codigo_estado
    EXECUTE inserir_ddd @ddd6, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Paraíba' , @uf CHAR(2) = 'PB', @codigo_estado TINYINT,
    @ddd TINYINT = 83
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Pará' , @uf CHAR(2) = 'PA', @codigo_estado TINYINT,
    @ddd TINYINT = 91, @ddd2 TINYINT = 93, @ddd3 TINYINT = 94
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Pernambuco' , @uf CHAR(2) = 'PE', @codigo_estado TINYINT,
    @ddd TINYINT = 81, @ddd2 TINYINT = 87
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Piauí' , @uf CHAR(2) = 'PI', @codigo_estado TINYINT,
    @ddd TINYINT = 86, @ddd2 TINYINT = 89
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Rio de Janeiro' , @uf CHAR(2) = 'RJ', @codigo_estado TINYINT,
    @ddd TINYINT = 21, @ddd2 TINYINT = 22, @ddd3 TINYINT = 24
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Rio Grande do Norte' , @uf CHAR(2) = 'RN', @codigo_estado TINYINT,
    @ddd TINYINT = 84
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Rio Grande do Sul' , @uf CHAR(2) = 'RS', @codigo_estado TINYINT,
    @ddd TINYINT = 51, @ddd2 TINYINT = 53, @ddd3 TINYINT = 54, @ddd4 TINYINT = 55
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado
    EXECUTE inserir_ddd @ddd4, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Rondonia' , @uf CHAR(2) = 'RO', @codigo_estado TINYINT,
    @ddd TINYINT = 69
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Roraima' , @uf CHAR(2) = 'RR', @codigo_estado TINYINT,
    @ddd TINYINT = 95
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Santa Catarina' , @uf CHAR(2) = 'SC', @codigo_estado TINYINT,
    @ddd TINYINT = 47, @ddd2 TINYINT = 48, @ddd3 TINYINT = 49
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Sergipe' , @uf CHAR(2) = 'SE', @codigo_estado TINYINT,
    @ddd TINYINT = 79
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'São Paulo' , @uf CHAR(2) = 'SP', @codigo_estado TINYINT,
    @ddd TINYINT = 11, @ddd2 TINYINT = 12, @ddd3 TINYINT = 13, @ddd4 TINYINT = 14,
    @ddd5 TINYINT = 15, @ddd6 TINYINT = 16, @ddd7 TINYINT = 17, @ddd8 TINYINT = 18,
    @ddd9 TINYINT = 19
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado
    EXECUTE inserir_ddd @ddd2, @codigo_estado
    EXECUTE inserir_ddd @ddd3, @codigo_estado
    EXECUTE inserir_ddd @ddd4, @codigo_estado
    EXECUTE inserir_ddd @ddd5, @codigo_estado
    EXECUTE inserir_ddd @ddd6, @codigo_estado
    EXECUTE inserir_ddd @ddd7, @codigo_estado
    EXECUTE inserir_ddd @ddd8, @codigo_estado
    EXECUTE inserir_ddd @ddd9, @codigo_estado;
DECLARE @nome VARCHAR(25) = 'Tocantins' , @uf CHAR(2) = 'TO', @codigo_estado TINYINT,
    @ddd TINYINT = 63
    EXECUTE @codigo_estado = inserir_estado @nome, @uf 
    EXECUTE inserir_ddd @ddd, @codigo_estado;

DECLARE @nome VARCHAR(25) = 'Fortaleza', @estado TINYINT = 6 EXECUTE inserir_cidade @nome, @estado;
DECLARE @nome VARCHAR(25) = 'Caucaia', @estado TINYINT = 6 EXECUTE inserir_cidade @nome, @estado;

DECLARE @nome VARCHAR(50) = 'Damas', @cidade INT = 1 EXECUTE inserir_bairro @nome, @cidade;
DECLARE @nome VARCHAR(50) = 'Centro', @cidade INT = 1 EXECUTE inserir_bairro @nome, @cidade;

