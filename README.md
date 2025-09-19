# 💡 Sistema de Fretes - Banco de Dados e API

## 📦 Banco de Dados

Este projeto utiliza 
- **MySQL 8.0** com **Docker Compose** para facilitar a configuração e garantir que toda a equipa utilize o mesmo ambiente.  
A estrutura inicial da base de dados (tabelas) está definida no ficheiro `schema.sql`.
- **DynamoDB (NoSQL)** → Fretes, via **LocalStack** em Docker (simula a AWS localmente)
---

## ⚙️ Requisitos para Iniciar a Base de Dados

Antes de rodar, certifique-se de ter instalado na sua máquina uma ferramenta de gestão de contentores:

- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- ou [Rancher Desktop](https://rancherdesktop.io/) (uma excelente alternativa que se mostrou eficaz durante o desenvolvimento)
- [AWS CLI](https://docs.aws.amazon.com/cli/) instalado para interagir com o DynamoDB

---

## 🚀 Como Rodar a Base de Dados

```bash
# Clone este repositório
git clone https://github.com/FreteCheck/FreteCheck-Back-End.git

# Aceda à pasta do projeto
cd FreteCheck-Back-End

# Suba o contentor da base de dados (execute o terminal como administrador)
docker-compose up -d
```

Após executar o comando acima isso iniciará:

- MySQL na porta 3306

- LocalStack (DynamoDB) na porta 4566

---

## 🛠️ Acesso ao Banco de Dados

- **Host:** localhost
- **Porta:** 3306
- **Usuário:** freteuser
- **Senha:** fretepass
- **Database:** fretecheck

Você pode acessar usando ferramentas como:

- DBeaver
- PgAdmin
- MySQL Workbench
- ou até pelo terminal:

```bash
psql -h localhost -U freteuser -d fretecheck
```

---
## 🛠📦 Acesso ao DynamoDB (LocalStack)

Verifique se o container está rodando:

```bash
docker ps
```
Deve aparecer algo como:

localstack/localstack   ...   0.0.0.0:4566->4566/tcp

Criar tabela Frete
```bash
aws dynamodb create-table \
--table-name Frete \
--attribute-definitions AttributeName=id,AttributeType=S \
--key-schema AttributeName=id,KeyType=HASH \
--billing-mode PAY_PER_REQUEST \
--endpoint-url http://localhost:4566 \
--region us-east-1 \
--profile localstack
```
Popular com dados iniciais (fretes.json)

Rode:
```bash
aws dynamodb batch-write-item \
--request-items file://fretes.json \
--endpoint-url http://localhost:4566 \
--region us-east-1 \
--profile localstack
```

---
## 📜 Documentação da API (Swagger)

A API possui uma documentação interativa gerada com **Swagger (OpenAPI)**.  
Através dela, é possível visualizar todos os endpoints disponíveis, seus parâmetros e até mesmo testá-los diretamente pelo navegador.

➡️ Acesse: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🌐 Endpoints Disponíveis

### Usuários 👤

#### 1. Cadastro de Usuário

- **Método:** POST
- **Rota:** `/api/usuarios`
- **Descrição:** Cria um novo usuário no sistema.
- **Corpo da Requisição (Body):**

```json
{
  "nome": "Seu Nome",
  "email": "seuemail@exemplo.com",
  "senha": "suasenha"
}
```

---

#### 2. Login de Usuário

- **Método:** POST
- **Rota:** `/api/usuarios/login`
- **Descrição:** Autentica um usuário com base no email e senha.
- **Corpo da Requisição (Body):**

```json
{
  "email": "seuemail@exemplo.com",
  "senha": "suasenha"
}
```

---
#### Fretes 🚚 (NoSQL - DynamoDB)

#### 1. Listar fretes

- **Método:** GET /api/fretes


#### 2.Buscar por ID

- **Método:** GET /api/fretes/{id}


#### 3.Criar frete

- **Método:** POST /api/fretes

```json
{
"id": "4",
"origem": "Campinas",
"destino": "São Paulo",
"descricao": "Mudança pequena - R$ 300",
"valor": 300,
"status": "Disponível",
"motorista": "Pedro Santos",
"telefone": "(19) 99999-0000",
"rating": 4.2
}
```
---

## 🗂️ Estrutura do Projeto

```
FreteCheck-Back-End/
│── schema.sql              # Estrutura inicial do banco relacional
│── fretes.json             # Dados iniciais do DynamoDB
│── docker-compose.yml      # Configuração dos containers (MySQL + LocalStack)
│── README.md               # Este guia
│── src/                    # Código do backend

```

---

## 🐳 Comandos Úteis do Docker

- Parar os containers:

```bash
docker-compose down
```

- Ver logs do banco:

```bash
docker-compose logs -f
```

- Reiniciar o banco:

```bash
docker-compose restart
```

- Remover tudo (incluindo volume/dados):

```bash
docker-compose down -v
```

---

## 👨🏽‍💻 Desenvolvedores

- **Vagner Ferreira Lima Junior** - [@vagnerflj](https://github.com/vagnerflj)
- **Eliphaz Gabriel Ferra Pedroso** - [@eliphazGFP](https://github.com/eliphazGFP)
- **João Gabriel Antunes Castilho** - [@oJoao27](https://github.com/oJoao27)

---

## 👨‍🏫 Instrutores

_Adicione aqui os instrutores do projeto._
