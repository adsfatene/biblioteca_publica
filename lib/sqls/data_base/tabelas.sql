CREATE TABLE editoras
(
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE categorias
(
codigo TINYINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE formatos
(
codigo TINYINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(20) NOT NULL UNIQUE,
CHECK (nome NOT IN ('geral', 'todos', 'qualquer', 'desconhecido'))
);

CREATE TABLE publicos
(
codigo TINYINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE dados_materiais
(
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
titulo VARCHAR(50) NOT NULL,
descricao VARCHAR(100),
edicao TINYINT,
editora INT NOT NULL DEFAULT 1,
ano_publicacao SMALLINT,
autor VARCHAR(50),
categoria TINYINT NOT NULL DEFAULT 1,
publico TINYINT NOT NULL DEFAULT 1,
UNIQUE (titulo, editora),
FOREIGN KEY (editora) REFERENCES editoras(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (categoria) REFERENCES categorias(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (publico) REFERENCES publicos(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE materiais
(
codigo INT NOT NULL IDENTITY PRIMARY KEY,
dado_material INT NOT NULL,
formato TINYINT NOT NULL DEFAULT 1,
data_hora_cadastro DATETIME NOT NULL DEFAULT GETDATE(),
informacao VARCHAR(255),
UNIQUE (codigo, dado_material, formato),
FOREIGN KEY (dado_material) REFERENCES dados_materiais(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (formato) REFERENCES formatos(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE estoques
(
material INT NOT NULL PRIMARY KEY,
statu VARCHAR(10) NOT NULL CHECK (statu IN ('Novo', 'Emprestando',  'Usado', 'Danificado', 'Restaurado')),
local_logico_fisico VARCHAR(100) NOT NULL,
FOREIGN KEY (material) REFERENCES materiais(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE estados
(
codigo TINYINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(25) NOT NULL UNIQUE,
uf CHAR(2) NOT NULL UNIQUE 
);

CREATE TABLE cidades
(
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(25) NOT NULL,
estado TINYINT NOT NULL,
UNIQUE(nome, estado),
FOREIGN KEY (estado) REFERENCES estados(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE bairros
(
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
cidade INT NOT NULL,
UNIQUE(nome, cidade),
FOREIGN KEY (cidade) REFERENCES cidades(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE cidadaos
(
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome_completo VARCHAR(100) NOT NULL,
logradouro VARCHAR(30) NOT NULL,
numero_imovel INT,
bairro INT NOT NULL,
data_hora_cadastro DATETIME NOT NULL DEFAULT GETDATE(),
FOREIGN KEY (bairro) REFERENCES bairros(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE ddds
(
numero TINYINT NOT NULL CHECK(numero <= 99) PRIMARY KEY,
estado TINYINT NOT NULL,
FOREIGN KEY (estado) REFERENCES estados(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE cidadaos_contatos_voz
(
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
cidadao INT NOT NULL,
ddd TINYINT NOT NULL,
numero CHAR(8) NOT NULL,
tipo CHAR(3) NOT NULL DEFAULT 'Tel' CHECK (tipo IN ('Tel', 'Cel')),
UNIQUE (cidadao, ddd, numero, tipo),
FOREIGN KEY (cidadao) REFERENCES cidadaos(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (ddd) REFERENCES ddds(numero) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE emprestimos
(
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
cidadao INT NOT NULL,
data_hora_emprestado DATETIME NOT NULL DEFAULT GETDATE(),
data_hora_devolucao_prevista DATETIME,
data_hora_devolucao_efetiva DATETIME,
CHECK 
((data_hora_devolucao_prevista IS NULL) OR (data_hora_emprestado <= data_hora_devolucao_prevista)),
CHECK
((data_hora_devolucao_efetiva IS NULL) OR (data_hora_devolucao_prevista IS NOT NULL AND data_hora_emprestado <= data_hora_devolucao_efetiva)),
FOREIGN KEY (cidadao) REFERENCES cidadaos(codigo) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE emprestimos_estoques (
codigo INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
emprestimo INT NOT NULL,
estoque INT NOT NULL,
estado_devolucao VARCHAR(13) CHECK (estado_devolucao IN ('Perfeito', 'Avariado', 'Irrecuperavel')),
motivo VARCHAR (160),
UNIQUE (emprestimo,estoque),
FOREIGN KEY(emprestimo) REFERENCES emprestimos(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(estoque) REFERENCES estoques(material) ON DELETE NO ACTION ON UPDATE NO ACTION
);