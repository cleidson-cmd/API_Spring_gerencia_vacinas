#identificações: ApiI: gerenciar Vacinas; ApiII: gerenciar Pacientes; ApiIII: gerenciar Registro de vacinação;

#configurações: Project: Maven; Laguage: Java; Spring Boot: versão 3.1.4; Packaging: Jar;

#Dependencies: Spring Web; Lombok; Validation;

Java SDK 17

#OBS: em casos de erros pode remover a pasta (.idea) no projeto fechando a IDE(InteliJ) e abrindo novamente para recriar.

VacinasSpringBoot

Crie um banco de dados MongoDB com o nome de api-paramo-db

Rotas:

localhost:8080
localhost:8080/api/vacinas

API REST para teste

GET requisições para /api/vacinas retorna uma lista de usuários em formato JSON

GET requisições para /api/vacinas/obter/1 retorna o usuário com o ID 1

POST requisições para /api/vacinas/cadastrar com um objeto Usuario JSON cria um novo usuário

PUT requisições para /api/vacinas/editar/1 com um objeto Usuario JSON atualiza o usuário com ID 1

DELETE requisições para /api/remover/1 deleta o usuário com ID 1

DELETE requisições para /api/usuario deleta todos os usuários




