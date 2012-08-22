CREATE DATABASE IF NOT EXISTS canaBD;

Use CanaBD;

CREATE  TABLE IF NOT EXISTS cliente (
  id_cliente INT(11) NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(100),
  cpf VARCHAR(20),
  email VARCHAR(100),
  logradouro VARCHAR(100),
  bairro VARCHAR(50),
  cidade VARCHAR(50),
  cep VARCHAR(10),
  dataNasc DATE,
  telefone VARCHAR(16),
  PRIMARY KEY (id_cliente)
);


CREATE  TABLE IF NOT EXISTS produto (
  id_produto INT(11) NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(100),
  marca VARCHAR(50),
  preco DOUBLE,
  tipo VARCHAR(50),
  url VARCHAR(100),
  PRIMARY KEY (id_produto) 
);

CREATE  TABLE IF NOT EXISTS venda (
  id_venda INT(11) NOT NULL AUTO_INCREMENT ,
  dataVenda DATE ,
  id_cliente INT(11) NOT NULL ,
  PRIMARY KEY (id_venda,id_cliente) ,
  INDEX fk_venda_cliente1 (id_cliente) ,
  CONSTRAINT fk_venda_cliente1 FOREIGN KEY (id_cliente ) REFERENCES cliente (id_cliente)
);

CREATE  TABLE IF NOT EXISTS venda_produto(
  id_venda INT(11)NOT NULL,
  id_produto INT(11) NOT NULL ,
  quantidade INT(11),
  preco DOUBLE,
  PRIMARY KEY (id_venda, id_produto) ,
  INDEX fk_venda_has_produto_produto1 (id_produto) ,
  CONSTRAINT fk_venda_has_produto_venda1 FOREIGN KEY (id_venda)REFERENCES venda (id_venda),
  CONSTRAINT fk_venda_has_produto_produto1 FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
);