#identificações: ApiI: gerenciar Vacinas; ApiII: gerenciar Pacientes; ApiIII: gerenciar Registro de vacinação;

#configurações: Project: Maven; Laguage: Java; Spring Boot: versão 3.1.4; Packaging: Jar;

#Dependencies: Spring Web; Lombok; Validation;

Java SDK 17

#OBS: em casos de erros pode remover a pasta (.idea) no projeto fechando a IDE(InteliJ) e abrindo novamente para recriar.

VacinasSpringBoot

Crie um banco de dados MongoDB com o nome de api-vacinas-db

Rotas:

localhost:8080

localhost:8080/api/vacinas

API REST para teste

GET requisições para /api/vacinas retorna uma lista de vacinas em formato JSON

GET requisições para /api/vacinas/obter/1 retorna a vacina com o ID 1

POST requisições para /api/vacinas/cadastrar com um objeto Vacina JSON cria um novo registro de vacina no banco de dados

PUT requisições para /api/vacinas/editar/1 com um objeto Vacina JSON atualiza a vacina com ID 1

DELETE requisições para /api/remover/1 deleta a vacina com ID 1




