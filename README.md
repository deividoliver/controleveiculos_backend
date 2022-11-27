# Controle de Veículos `BACKEND`

Este projeto é um backend CRUD de controle de veículos.

## Requisitos
```
* Java >=  v17.
* Banco de dados postgres.
```
## Configuração do Banco de dados
Execute os scripts de criação e configuração do banco de dados, assim como inserts das tabelas modelo e opcional do arquivo
`\.scripts.sql`

Ao final do processo você deverá ter o banco de dados `controleveiculo` configurado.

obs: Para configurar usuário e senha para conexão do banco de dados, edite o arquivo `\src\main\resources\application.properties` 
nas linhas `spring.datasource.username` e `spring.datasource.password`

## Execução
Após os processos de criação, inserções do banco de dados e configuração de conexão no projeto. Instale as bibliotecas do projeto e execute o mesmo em sua IDE.

obs: Este projeto foi desenvolvido na IDE IntelliJ

## Conexões
```
Local de conexão ao Backend: `http://localhost:8080/api/`
```