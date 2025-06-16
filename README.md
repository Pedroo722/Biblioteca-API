# Biblioteca API

Projeto back-end simples criado para servir como a API de um sistema mobile de gerenciamento de uma biblioteca fictícia. A aplicação foi construída utilizando **Spring Boot** e o **PostgreSQL** como banco de dados.

Membros 
- Pedro Henrique Alexandre
- Vinicius Cavalcante Pequeno
- Thiago dos Santos Araújo

# Estrutura dos Arquivos

- **Controllers**: Responsáveis por definir os endpoints da API.
- **Domain**: Representam a entidade Livro no banco de dados, com seus respectivos atributos.
- **Repositories**: Implementa o MongoDBTemplate para realizar as consultas no banco.
- **Services**: Contêm a lógica de negócio para manipular e consultar os dados.

## Tecnologias Usadas

<div align="center">

![Java 17](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot 3](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

</div>

## Funcionalidades

- **Cadastro e Autenticação de Usuários**
- **Pesquisa de Usuários por email**
- **Consulta e visualização de livros cadastrados**
- **Pesquisa de livros por título, gênero e autor**
- **Cadastro de livros**
- **Edição de livros**
- **Remoção de livros**
- **Cadastro de Emprestimos**
- **Finalização de Emprestimos**
- **Cancelamento de Emprestimos**

## Como Executar
### Pré-requisitos

- **Java 17** ou superior
- **Maven** 3.8.1+
- **PostgreSQL**

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/Pedroo722/Biblioteca-API.git
   cd seu-repositorio
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em: `http://localhost:8080/{endpoint}`.

## Endpoints

A API fornece os seguintes endpoints para a manipulação de dados da coleção livros.

### Livro
- **GET** `/api/livros/info/all`: Recupera todos os livros.
- **GET** `/api/livros/info/title/{titulo}`: Recupera um livro pelo titulo.
- **GET** `/api/livros/info/genre/{genero}`: Recupera todos os livros pelo gênero.
- **GET** `/api/livros/info/author/{autor}`: Recupera todos os livros pelo autor.
- **POST** `/api/livros/create`: Cria um novo livro.
- **PUT** `/api/livros/title/{titulo}`: Atualiza um livro existente com base no título.
- **DELETE** `/api/livros/delete/title/{titulo}`: Remove um livro pelo titulo.

## Estrutura dos Dados
### Usuário

```json
{
   "id": number,
   "name": "string",
   "phone": "string",
   "email": "string",
   "password": "string",
   "address": "string"
}
```

### Livro

```json
{
   "id": number,
   "titulo": "string",
   "autor": "string",
   "status": "string",
   "editora": "string",
   "isbn": "string",
   "ano": "string",
   "sinopse": "string"
}
```

### Emprestimo

```json
{
   "id": number,
   "title": "string",
   "name": "string",
   "email": "string",
   "fine": "string",
   "loanDate": LocalDate,
   "returnDate": LocalDate,
   "returnDateReal": LocalDate,
   "status": "string"
}
```