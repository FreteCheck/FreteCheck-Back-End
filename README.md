# 💡 Sistema de Fretes - Banco de Dados

## 📦 Banco de Dados
Este projeto utiliza **PostgreSQL** com **Docker Compose** para facilitar a configuração e garantir que toda a equipe utilize o mesmo ambiente.  
A estrutura inicial do banco (tabelas) está definida no arquivo [`schema.sql`](./schema.sql).

---

## ⚙️ Requisitos para Iniciar o Banco

Antes de rodar, certifique-se de ter instalado na sua máquina:
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## 🚀 Como Rodar o Banco de Dados

```bash
# Clona este repositório
$ git clone https://github.com/FreteCheck/FreteCheck-Back-End.git

# Acessa a pasta do projeto
$ cd FreteCheck-Back-End

# Sobe o container do banco
$ docker-compose up -d
```

Após executar o comando acima, o banco estará rodando em segundo plano.

---

## 🛠️ Acesso ao Banco de Dados

- **Host:** `localhost`
- **Porta:** `5432`
- **Usuário:** `freteuser`
- **Senha:** `fretepass`
- **Database:** `fretecheck`

Você pode acessar usando ferramentas como **DBeaver**, **PgAdmin** ou até pelo terminal:

```bash
psql -h localhost -U freteuser -d fretecheck
```

---

## 🗂️ Estrutura do Projeto

```
FreteCheck-Back-End/
│── schema.sql              # Estrutura inicial do banco
│── docker-compose.yml      # Configuração do PostgreSQL com Docker
│── README.md               # Este guia
│── src/                    # Código do backend
```

---

## 🐳 Comandos Úteis do Docker

Parar os containers:
```bash
docker-compose down
```

Ver logs do banco:
```bash
docker-compose logs -f
```

Reiniciar o banco:
```bash
docker-compose restart
```

Remover tudo (incluindo volume/dados):
```bash
docker-compose down -v
```

---

## 👨🏽‍💻 Desenvolvedores

Os desenvolvedores deste projeto são:
+ Vagner Ferreira Lima Junior: [@vagnerflj](https://github.com/vagnerflj)
+ Eliphaz Gabriel Ferra Pedroso: [@eliphazGFP](https://github.com/eliphazGFP)
+ João Gabriel Antunes Castilho: [@oJoao27](https://github.com/oJoao27)

---

## 👨‍🏫 Instrutores
*(adicione aqui os instrutores do projeto)*  
