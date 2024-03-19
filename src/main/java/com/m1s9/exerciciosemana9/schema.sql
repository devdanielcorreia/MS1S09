
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Criação da tabela Livro
CREATE TABLE IF NOT EXISTS Livro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(60) NOT NULL,
    autor VARCHAR(60) NOT NULL,
    anoPublicacao INT NOT NULL
);

-- Criação da tabela Membro
CREATE TABLE IF NOT EXISTS Membro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    endereco VARCHAR(60) NOT NULL,
    telefone VARCHAR(60) NOT NULL
);

-- Criação da tabela Visitante
CREATE TABLE IF NOT EXISTS Visitante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    telefone VARCHAR(60) NOT NULL
);

-- Criação da tabela Emprestimo
CREATE TABLE IF NOT EXISTS Emprestimo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_livro BIGINT NOT NULL,
    id_membro BIGINT NOT NULL,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE NOT NULL,
    FOREIGN KEY (id_livro) REFERENCES Livro(id),
    FOREIGN KEY (id_membro) REFERENCES Membro(id)
);

-- Criação da tabela Bibliotecario
CREATE TABLE IF NOT EXISTS Bibliotecario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL UNIQUE,
    senha VARCHAR(60) NOT NULL
);
