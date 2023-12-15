# API DASS21 - Júlio Silva
Esta é uma API desenvolvida em Java 17 utilizando Spring Boot 3 e PostgreSQL 14. O projeto tem como objetivo fornecer uma aplicação de demonstração para o DASS21.

## Pré-requisitos
Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- Java 17
- Maven
- PostgreSQL 14

## Como Rodar
Siga os passos abaixo para configurar e executar a API em sua máquina local:

- Clone o Projeto

- Instale as Dependências com 'maven install'

- Abra o arquivo src/main/resources/application.properties e ajuste as variáveis de conexão do banco de dados de acordo com a configuração da sua máquina. Exemplo:

spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.url=jdbc:postgresql://localhost:5432/dass21_demo

*Certifique-se de que o banco de dados PostgreSQL esteja em execução na porta correta.*

- Execute o Projeto

Rode o projeto em sua IDE de preferência.

A API estará na rota 8081: http://localhost:8081

Caminho padrão do endpoint: '/participant'
*Consulte a Documentação com Swagger para mais informações de cada endpoint: http://localhost:8081/swagger-ui/index.html*


