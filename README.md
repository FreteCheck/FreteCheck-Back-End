# 💡 Sistema de Fretes - Banco de Dados

## 📦 Banco de Dados

Este projeto utiliza **MySQL 8.0** com **Docker Compose** para facilitar a configuração e garantir que toda a equipa utilize o mesmo ambiente.  
A estrutura inicial da base de dados (tabelas) está definida no ficheiro `schema.sql`.

---

## ⚙️ Requisitos para Iniciar a Base de Dados

Antes de rodar, certifique-se de ter instalado na sua máquina uma ferramenta de gestão de contentores:

- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- ou [Rancher Desktop](https://rancherdesktop.io/) (uma excelente alternativa que se mostrou eficaz durante o desenvolvimento)

---

## 🚀 Como Rodar a Base de Dados

```bash
# Clone este repositório
git clone https://github.com/FreteCheck/FreteCheck-Back-End.git

# Aceda à pasta do projeto
cd FreteCheck-Back-End

# Suba o contentor da base de dados (execute o terminal como administrador)
docker-compose up -d


Após executar o comando acima, o banco estará rodando em segundo plano.

---

## 🛠️ Acesso ao Banco de Dados

- **Host:** `localhost`
- **Porta:** `3306`
- **Usuário:** `freteuser`
- **Senha:** `fretepass`
- **Database:** `fretecheck`

Você pode acessar usando ferramentas como **DBeaver**, **PgAdmin**, **MySQL Workbench** ou até pelo terminal:

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
