create table marcas (codigo BIGINT PRIMARY KEY, nome VARCHAR(40) NOT NULL);
create table sistemas (codigo BIGINT PRIMARY KEY,nome VARCHAR(40) NOT NULL);
create table processadores (codigo BIGINT PRIMARY KEY,nome VARCHAR(40) NOT NULL);
create table computadores (uuid CHAR(36) PRIMARY KEY,codigoMarca BIGINT NOT NULL, codigoSistema BIGINT NOT NULL,codigoProcessador BIGINT NOT NULL,usado BOOLEAN NOT NULL, tipo VARCHAR(40) NOT NULL,memoriaRam INT NOT NULL,hd INT NOT NULL,ssd INT NOT NULL,preco VARCHAR(40) NOT NULL, nota DOUBLE NOT NULL, FOREIGN KEY (codigoMarca) REFERENCES marcas(codigo), FOREIGN KEY (codigoSistema) REFERENCES sistemas(codigo), FOREIGN KEY (codigoProcessador) REFERENCES processadores(codigo));

insert into marcas (nome) values ('Acer'), ('Dell'), ('Lenovo'), ('Samsung'), ('HP'), ('Apple'), ('LG'), ('AOC'), ('Asus'), ('Avell');
insert into sistemas (nome) values ('Windows 8'), ('Windows 10'), ('Ubuntu 18'), ('Debian'), ('macOS X');
insert into processadores (nome) values ('Intel i3 2GHz'), ('Intel i5 2,5GHz'), ('Intel i5 3GHz'), ('Intel i7 3GHz'), ('Intel i9 3,5GHz');
