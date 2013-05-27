

DECLARE @nome VARCHAR(100) = 'desconhecido' EXECUTE inserir_editora @nome;

DECLARE @nome VARCHAR(50) = 'desconhecido' EXECUTE inserir_categoria @nome;

DECLARE @nome VARCHAR(20) = 'impresso' EXECUTE inserir_formato @nome;
DECLARE @nome VARCHAR(20) = 'pdf' EXECUTE inserir_formato @nome;
DECLARE @nome VARCHAR(20) = 'ppt' EXECUTE inserir_formato @nome;
DECLARE @nome VARCHAR(20) = 'mp3' EXECUTE inserir_formato @nome;
DECLARE @nome VARCHAR(20) = 'mp4' EXECUTE inserir_formato @nome;

DECLARE @nome VARCHAR(50) = 'indefinido' EXECUTE inserir_publico @nome;
DECLARE @nome VARCHAR(50) = 'infantil' EXECUTE inserir_publico @nome;
DECLARE @nome VARCHAR(50) = 'jovem' EXECUTE inserir_publico @nome;
DECLARE @nome VARCHAR(50) = 'adulto' EXECUTE inserir_publico @nome;