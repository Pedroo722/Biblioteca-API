# Biblioteca API

Projeto back-end simples criado para servir como a API de um sistema mobile de gerenciamento de uma biblioteca fictícia. A aplicação foi construída utilizando **Spring Boot** e o **PostgreSQL** como banco de dados.

Membros:
- Pedro Henrique Alexandre
- Vinicius Cavalcante Pequeno
- Thiago dos Santos Araújo

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

## Estrutura dos Arquivos

- **Controllers**: Responsáveis por definir os endpoints da API.
- **Domain**: Representam a entidades da biblioteca no banco de dados, com seus respectivos atributos.
- **Repositories**: Extende a classe JpaRepository para realizar as consultas no banco.
- **Services**: Contêm a lógica de negócio para manipular e consultar os dados.

```
└── src/
    └── main/
        └── java/
            └── br/edu/ifpb/biblioteca/
                ├── BibliotecaApplication.java
                ├── config/
                │   ├── ExceptionsHandler.java
                │   └── WebConfig.java
                ├── controller/
                │   ├── AuthController.java
                │   ├── BookController.java
                │   ├── LoanController.java
                │   └── UserController.java
                ├── exceptions/
                │   ├── BookNotFoundException.java
                │   ├── InvalidCredentialsException.java
                │   ├── InvalidEmailException.java
                │   ├── JwtTokenException.java
                │   ├── LoanNotFoundException.java
                │   ├── UnauthorizedAccessException.java
                │   └── UserNotFoundException.java
                ├── model/
                │   ├── Book.java
                │   ├── Loan.java
                │   ├── Role.java
                │   └── User.java
                ├── repository/
                │   ├── BookRepository.java
                │   ├── LoanRepository.java
                │   └── UserRepository.java
                ├── service/
                │   ├── BookService.java
                │   ├── LoanService.java
                │   └── UserService.java
                └── util/
                    └── UserValidations.java
```

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

4. Acesse a API em: `http://localhost:8081/{endpoint}`.

## Endpoints

### Autenticação
- **POST** `/auth/login`: Autentica um usuário e retorna um token JWT.
- **POST** `/auth/signup`: Realiza o cadastro de um novo usuário.

### Usuários
- **GET** `/api/users/list`: Recupera todos os usuários cadastrados.
- **GET** `/api/users/{email}`: Recupera um usuário pelo email.
- **PUT** `/api/users/update/{email}`: Atualiza os dados de um usuário existente, baseado no email.
- **DELETE** `/api/users/delete/{email}`: Deleta um usuário pelo email.

### Livros
- **GET** `/api/books/list`: Recupera todos os livros cadastrados, com a opção de filtrar por autor. A resposta é paginada.
  - **Parâmetros de consulta (query parameters)**:
    - `autor`: Filtra os livros pelo autor (opcional).
    - `page`: Número da página para a paginação (padrão: 0).
    - `size`: Número de itens por página (padrão: 10).
- **GET** `/api/books/{id}`: Recupera um livro pelo seu ID.
- **POST** `/api/books/create`: Cria um novo livro com as informações fornecidas.
- **PUT** `/api/books/update/{id}`: Atualiza um livro existente, baseado no ID.
- **DELETE** `/api/books/delete/{id}`: Deleta um livro pelo seu ID.

### Empréstimos
- **GET** `/api/loans/list`: Recupera todos os empréstimos, com a opção de filtrar por nome do cliente. A resposta é paginada.
  - **Parâmetros de consulta (query parameters)**:
    - `name`: Filtra os empréstimos pelo nome do cliente (opcional).
    - `page`: Número da página para a paginação (padrão: 0).
    - `size`: Número de itens por página (padrão: 10).
- **GET** `/api/loans/{id}`: Recupera um empréstimo pelo seu ID.
- **POST** `/api/loans/create`: Cria um novo empréstimo com as informações fornecidas.
- **PUT** `/api/loans/update/{id}`: Atualiza um empréstimo existente, baseado no ID.
- **DELETE** `/api/loans/delete/{id}`: Deleta um empréstimo pelo seu ID.


## Estrutura dos Dados

### Usuário

```json
{
   "id": 1,
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
   "id": 1,
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
   "id": 1,
   "title": "string",
   "name": "string",
   "email": "string",
   "fine": "string",
   "loanDate": "2025-01-01",
   "returnDate": "2025-01-01",
   "returnDateReal": "2025-01-01",
   "status": "string"
}
```
