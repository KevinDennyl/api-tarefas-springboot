# API de Tarefas - UNINTER

API RESTful para gerenciamento de tarefas desenvolvida em Spring Boot.

## 🚀 Tecnologias
- Java 17
- Spring Boot 3.4.9
- Spring Data JPA
- MySQL
- Maven

## 📋 Funcionalidades
- ✅ Criar tarefa
- ✅ Listar todas as tarefas  
- ✅ Buscar tarefa por ID
- ✅ Atualizar tarefa
- ✅ Deletar tarefa

## 🏃‍♂️ Como executar
1. Clone o repositório
2. Configure o MySQL em `application.properties`
3. Execute: `mvn spring-boot:run`
4. Acesse: `http://localhost:8082`

## 📝 Endpoints
- POST /tarefas
- GET /tarefas
- GET /tarefas/{id}
- PUT /tarefas/{id}
- DELETE /tarefas/{id}