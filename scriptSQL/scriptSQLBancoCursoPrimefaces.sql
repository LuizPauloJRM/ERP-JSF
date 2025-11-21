create database cursojsfprimefaces;
CREATE USER 'minierp_user'@'localhost' IDENTIFIED BY 'minierp_password';
GRANT ALL PRIVILEGES ON cursojsfprimefaces.* TO 'minierp_user'@'localhost';
FLUSH PRIVILEGES;
use cursojsfprimefaces;
show tables;
select * from empresa;
CREATE DATABASE curso_jsf_primefaces;
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '';
CREATE DATABASE cursojsfprimefaces;
DROP DATABASE cursojsfprimefaces;
use cursojsfprimefaces;
insert into ramo_atividade (id, descricao) values (1, 'Distribuição de alimentos');
insert into ramo_atividade (id, descricao) values (2, 'Telecomunicações');
insert into ramo_atividade (id, descricao) values (3, 'Vestuário');
insert into ramo_atividade (id, descricao) values (4, 'Lavanderia');
insert into ramo_atividade (id, descricao) values (5, 'Gráfica');
insert into ramo_atividade (id, descricao) values (6, 'Mecânica');
insert into ramo_atividade (id, descricao) values (7, 'Turismo');
insert into ramo_atividade (id, descricao) values (8, 'Saúde');
insert into ramo_atividade (id, descricao) values (9, 'Educação');
insert into ramo_atividade (id, descricao) values (10, 'Lazer');

insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id)
values (1, '70.311.193/0001-87', 'Mercado do João', 'João Mercado e Distribuidor de Alimentos Ltda', 'LTDA', '2009-03-02', 1);

insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id)
values (2, '52.822.994/0001-25', 'Fale Mais', 'Fale Mais Telecom S.A.', 'SA', '1997-12-10', 2);

insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id)
values (3, '41.952.519/0001-57', 'Maria de Souza da Silva', 'Maria de Souza da Silva', 'MEI', '2014-10-15', 3);

insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id)
values (4, '16.134.777/0001-89', 'Gomes Inovação', 'José Fernando Gomes EIRELI ME', 'EIRELI', '2009-03-02', 4);
CREATE DATABASE erp_funcionarios;
use erp_funcionarios;
show tables;
show databases;
create database banco;
use banco;
show tables;
insert into clientes (nome) values ('FACEBOOK');
CREATE TABLE clientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    PRIMARY KEY(id)
);
desc clientes;
SELECT nome FROM clientes;
CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    data_nascimento DATE,
    data_contratacao DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    cargo VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    telefone VARCHAR(20),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
insert into funcionarios (sobrenome) values ('LUIZ');
SELECT * FROM funcionario;
CREATE DATABASE hospitalia CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use hospitalia;
show tables;
desc paciente;
desc funcionarios;
SELECT * FROM paciente;
SELECT * FROM empresa;
SELECT * FROM funcionario;
SELECT * FROM ramo_atividade;