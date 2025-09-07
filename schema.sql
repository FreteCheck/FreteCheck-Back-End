CREATE TABLE IF NOT EXISTS usuarios (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nome VARCHAR(100) NOT NULL,
                                        email VARCHAR(150) UNIQUE NOT NULL,
                                        senha VARCHAR(255) NOT NULL,
                                        data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- pode adicionar mais comandos CREATE TABLE aqui no futuro.
-- Exemplo:
-- CREATE TABLE IF NOT EXISTS produtos (
--     ...
-- );

