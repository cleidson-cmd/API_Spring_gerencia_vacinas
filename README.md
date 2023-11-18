#identificações: ApiI: gerenciar Vacinas; ApiII: gerenciar Pacientes; ApiIII: gerenciar Registro de vacinação;

#configurações: Project: Maven; Laguage: Java; Spring Boot: versão 3.1.4; Packaging: Jar;

#Dependencies: Spring Web; Lombok; Validation;

Java SDK 17

#OBS: em casos de erros pode remover a pasta (.idea) no projeto fechando a IDE(InteliJ) e abrindo novamente para recriar.

API 1 Gerenciar Vacinas


.Este repositório contém um projeto API REST simples, construído com Java Spring & MongoDB. O objetivo deste repositório é gerenciar Vacinas através de CRUD Java.

Este projeto foi desenvolvido durante a disciplina de Programação para Web II do curso de Bacharelado em Sitemas de Informação da UNIME(União Metropolitana de Educação e Cultura) no 2º semestre de 2023.


VacinasSpringBoot

Crie um banco de dados MongoDB com o nome de api-vacinas-db

Rotas:

localhost:8080

localhost:8080/api/vacinas

API REST para teste

GET requisições para /api/vacinas retorna uma lista de vacinas em formato JSON

GET requisições para /api/vacinas/obter/1 retorna a vacina com o ID 1

POST requisições para /api/vacinas/cadastrar com um objeto Vacina JSON cria um novo registro de vacina no banco de dados

Exemplo de entrada JSON esperada:        
     {  "codigo": 20288,
        "nome": "IMUNIZESE",
        "fabricante": "UNIDEV",
        "lote": "001",
        "validade": "2025-11-10T00:00:00.000+00:00",
        "doses": 3,
        "intervaloEntreDoses": 5
    }
(OBS Intervalo entre doses em dias )

PUT requisições para /api/vacinas/editar/1 com um objeto Vacina JSON atualiza a vacina com ID 1

DELETE requisições para /api/remover/1 deleta a vacina com ID 1




