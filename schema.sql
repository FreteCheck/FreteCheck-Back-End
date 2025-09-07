-- Criação do banco (caso ainda não exista)
CREATE DATABASE fretecheck;

-- Conectar no banco
\c fretecheck;

-- Criar tabela usuarios
CREATE TABLE IF NOT EXISTS usuarios (
                                        id SERIAL PRIMARY KEY,
                                        nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
