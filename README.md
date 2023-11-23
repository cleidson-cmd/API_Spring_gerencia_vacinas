# API1 - Gerenciar Vacinas

API 1 Gerenciar Vacinas

Este repositório contém um projeto API REST simples, construído com Java Spring & MongoDB.
O objetivo deste repositório é gerenciar o registro de paciente através de CRUD Java

Este projeto foi desenvolvido durante a disciplina de Programação para Web II
do curso de Bacharelado em Sitemas de Informação da UNIME(União Metropolitana de Educação e Cultura)
no 2º semestre de 2023.

API 1 deve gerenciar Vacinas, sendo que uma vacina deve ter:

• Fabricante

• Lote

• Data de Validade

• Número de doses

• Intervalo mínimo entre doses em dias

## Índice de Conteúdo

- [Instalação](#instalação)
- [Como Usar](#como-usar)
- [API Endpoints](#api-endpoints)
- [Base de Dados](#base-de-dados)

## Instalação

1. Clone o repositório:

```bash
$ git clone https://github.com/cleidson-cmd/API_Spring_gerencia_vacinas.git
```

2. Instale as dependências com o Maven

## Como Usar

1. Inicie o aplicativo com Maven
2. A API estará acessível em http://localhost:8080

## API Endpoints

A API fornece os seguintes endpoints:

```markdown
GET /api/vacinas - Listar todos os vacinas.

POST /api/pacientes - cadastra uma vacina.
(ATENNÇÃO! Se a vacina não for dose única, o intervaloEntreDoses deve ser maior que 0)
Exemplo do corpo:
{
"nome": "VACINA",
"fabricante": "PARAMO",
"lote": "001",
"validade": "2025-12-31",
"doses": 1,
"intervaloEntreDoses": 0
}

PUT /api/pacientes/{id} - editar uma vacina pelo id
{
"nome": "VACINA",
"fabricante": "PARAMO",
"lote": "001",
"validade": "2025-12-31",
"doses": 1,
"intervaloEntreDoses": 0
}

DELETE /api/vacinas/{id} - remover pelo id do paciente

```

## Base de Dados

O projeto usa o MongoDB como banco de dados.

Para instalar o MongoDB localmente [clique aqui](https://www.mongodb.com/try/download/community).

OU

Experimente um cluster gratuito e altamente disponível de 512
MB. [clique aqui](https://www.mongodb.com/cloud/atlas/register).

