# Biblioteca API

Projeto back-end simples criado para estudo na manipulação de dados em coleções no MongoDB. A aplicação foi construída utilizando **Spring Boot** e o **MongoDB** como banco de dados, visando criar uma api para a consulta e manipulações de informações de uma coleção de livros.

Membros 
- Pedro Henrique Alexandre
- Vinicius Cavalcante Pequeno

## Tecnologias Usadas

<div align="center">

![Java 17](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot 3](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)

</div>

## Funcionalidades

- **Consulta e visualização de livros cadastrados**
- **Pesquisa de livros por título, gênero e autor**
- **Cadastro de livros**
- **Edição de livros**
- **Remoção de livros**

## Estrutura dos Arquivos

- **Controllers**: Responsáveis por definir os endpoints da API.
- **Domain**: Representam a entidade Livro no banco de dados, com seus respectivos atributos.
- **Repositories**: Implementa o MongoDBTemplate para realizar as consultas no banco.
- **Services**: Contêm a lógica de negócio para manipular e consultar os dados.

## Como Executar
### Pré-requisitos

- **Java 17** ou superior
- **Maven** 3.8.1+
- **MongoDB**

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

```json
{
   "id":"671307c32d2e95ab0382862e",
   "title":"The Great Gatsby",
   "author":"F. Scott Fitzgerald",
   "genre": "Fiction",
   "url":"https://example.com/the-great-gatsby"
}
```
