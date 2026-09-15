# Medusa Library API

API REST desenvolvida para praticar a construção de aplicações backend com **Java**, **Spring Boot**, **Spring Data JPA**, **Hibernate** e **PostgreSQL**.

O projeto simula o gerenciamento de uma biblioteca, permitindo cadastrar livros, autores, categorias e leitores, além de controlar empréstimos e devoluções.

> Este projeto possui finalidade educacional e foi desenvolvido para consolidar conhecimentos de desenvolvimento de APIs REST, persistência de dados e modelagem de relacionamentos.

## Objetivo

O objetivo principal é praticar a criação de uma aplicação backend organizada em camadas, aplicando regras de negócio e utilizando o JPA/Hibernate para mapear as entidades do domínio para tabelas relacionais.

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de categorias.

- Cadastro e consulta de autores.

- Cadastro, consulta, atualização e exclusão de livros.

- Cadastro e consulta de leitores.

- Registro de empréstimos.

- Registro de devoluções.

- Controle da quantidade disponível de livros.

- Relacionamento entre livros, autores e categorias.

- Associação entre leitores, livros e empréstimos.

- Paginação e ordenação de consultas.

- Validação de dados de entrada.

- Tratamento global de exceções.

- Carga inicial de dados com `import.sql`.

- Testes de requisições utilizando Postman.

- Investigação do problema de desempenho conhecido como **N+1 queries**.

## Tecnologias utilizadas

- Java 25

- Spring Boot 4

- Spring Web MVC

- Spring Data JPA

- Hibernate ORM

- PostgreSQL

- H2 Database para testes

- Maven

- Jakarta Validation

- Postman

## Conceitos praticados

| Conceito | Aplicação no projeto |
| --- | --- |
| API REST | Exposição dos recursos da biblioteca por endpoints HTTP |
| Arquitetura em camadas | Separação entre controllers, services, repositories e entities |
| Spring Data JPA | Criação de repositórios e consultas persistentes |
| Hibernate | Mapeamento das entidades para tabelas do banco |
| DTOs | Transferência controlada de dados entre API e aplicação |
| Relacionamentos JPA | Uso de `@ManyToMany`, `@ManyToOne` e `@OneToMany` |
| Transações | Controle das operações de empréstimo e devolução |
| Paginação | Consulta de grandes quantidades de livros e empréstimos |
| Validação | Verificação dos dados recebidos pela API |
| Tratamento de exceções | Respostas padronizadas para erros da aplicação |
| Regras de negócio | Controle de disponibilidade e integridade dos empréstimos |
| Performance | Análise e prevenção de consultas N+1 |

## Modelo de domínio

O projeto possui as seguintes entidades principais:

- **Book:** representa os livros disponíveis no acervo.

- **Author:** representa os autores dos livros.

- **Category:** representa as categorias dos livros.

- **Reader:** representa os leitores cadastrados.

- **Loan:** representa os empréstimos realizados.

Relacionamentos principais:

- Um livro pode possuir vários autores.

- Um autor pode estar relacionado a vários livros.

- Um livro pode pertencer a várias categorias.

- Uma categoria pode possuir vários livros.

- Um leitor pode realizar vários empréstimos.

- Um livro pode possuir vários registros de empréstimo.

## Requisitos

Para executar o projeto, é necessário ter instalado:

- Java 25 ou versão compatível com o projeto;

- Maven 3.9 ou superior;

- PostgreSQL 14 ou superior;

- Git.

O projeto também pode utilizar o banco H2 no perfil de testes.

## Configuração do PostgreSQL

Crie um banco de dados para a aplicação:

```sql
CREATE DATABASE medusa_library;
```

Configure as propriedades do banco em `src/main/resources/application.properties` ou no arquivo correspondente ao perfil utilizado:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/medusa_library
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Substitua `sua_senha` pela senha do usuário local do PostgreSQL. Evite versionar senhas reais no repositório.

## Perfil de testes com H2

Para executar a aplicação utilizando H2 em memória, configure um perfil de teste semelhante a:

```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

A aplicação deve utilizar `create` ou `create-drop` quando for necessário recriar o banco antes da carga inicial. Em um banco PostgreSQL com dados persistentes, utilize `update` com cautela.

## Executando o projeto

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
cd medusa-library
```

Execute a aplicação com Maven:

```bash
./mvnw spring-boot:run
```

No Windows, utilize:

```
mvnw.cmd spring-boot:run
```

Ou compile e execute o projeto:

```bash
./mvnw clean package
java -jar target/*.jar
```

Por padrão, a API ficará disponível em:

```
http://localhost:8080
```

## Carga inicial

O arquivo `src/main/resources/import.sql` contém dados iniciais para categorias, autores, livros, leitores e empréstimos.

A ordem dos inserts deve respeitar as dependências do banco:

1. categorias e autores;

1. livros;

1. relacionamentos entre livros, autores e categorias;

1. leitores;

1. empréstimos.

Cada comando `INSERT` deve permanecer em uma única linha para evitar problemas na execução do script pelo Hibernate.

## Principais endpoints

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/categories` | Lista categorias com paginação |
| `POST` | `/categories` | Cria uma categoria |
| `GET` | `/categories/{id}` | Busca uma categoria |
| `PUT` | `/categories/{id}` | Atualiza uma categoria |
| `DELETE` | `/categories/{id}` | Exclui uma categoria |
| `GET` | `/authors` | Lista autores |
| `POST` | `/authors` | Cria um autor |
| `GET` | `/books` | Lista livros com paginação e filtros |
| `POST` | `/books` | Cria um livro |
| `GET` | `/books/{id}` | Busca um livro por ID |
| `PUT` | `/books/{id}` | Atualiza um livro |
| `DELETE` | `/books/{id}` | Exclui um livro |
| `GET` | `/readers` | Lista leitores |
| `POST` | `/readers` | Cria um leitor |
| `GET` | `/loans` | Lista empréstimos |
| `POST` | `/loans` | Registra um empréstimo |
| `PATCH` | `/loans/{id}/return` | Registra a devolução de um livro |

## Exemplo de criação de livro

```
POST /books
Content-Type: application/json
```

```json
{
  "title": "O Senhor dos Anéis",
  "description": "Uma jornada pela Terra-média para destruir o Um Anel.",
  "yearPublication": 1954,
  "totalQuantity": 4,
  "quantityAvailable": 4,
  "authorIds": [1],
  "categoryIds": [1]
}
```

## Exemplo de criação de empréstimo

```
POST /loans
Content-Type: application/json
```

```json
{
  "readerId": 1,
  "bookId": 1
}
```

Ao registrar um empréstimo, a quantidade disponível do livro deve ser reduzida. Ao registrar a devolução, a quantidade disponível deve ser aumentada novamente.

## Paginação e filtros

As consultas paginadas podem utilizar parâmetros como:

```
GET /books?page=0&size=10&sort=title,asc
```

Filtros disponíveis, conforme a implementação dos repositories e controllers:

```
GET /books?title=Senhor&page=0&size=10
GET /books?categoryId=1&page=0&size=10
GET /books?authorId=1&page=0&size=10
```

## Regras de negócio

- Apenas leitores ativos podem realizar empréstimos.

- Um livro não pode ser emprestado quando não houver exemplares disponíveis.

- A quantidade disponível não pode ser negativa.

- A quantidade disponível não pode ser maior que a quantidade total.

- Um leitor não deve possuir dois empréstimos ativos para o mesmo livro.

- Um empréstimo já devolvido não pode ser devolvido novamente.

- Livros com histórico de empréstimos não devem ser excluídos sem uma regra explícita para preservar a integridade dos dados.

- Categorias e autores inexistentes não podem ser associados a novos livros.

## Tratamento de erros

A API deve retornar respostas padronizadas para situações de erro.

Exemplo de recurso não encontrado:

```json
{
  "timestamp": "2026-09-15T18:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Livro não encontrado",
  "path": "/books/999999"
}
```

Códigos HTTP utilizados no projeto:

- `200 OK`: consulta ou atualização concluída;

- `201 Created`: recurso criado;

- `204 No Content`: operação concluída sem corpo de resposta;

- `400 Bad Request`: dados inválidos;

- `404 Not Found`: recurso não encontrado;

- `409 Conflict`: conflito de integridade ou duplicidade;

- `422 Unprocessable Entity`: regra de negócio violada.

## Testes com Postman

Uma coleção de testes pode ser importada no Postman para testar o fluxo completo da aplicação.

A ordem recomendada é:

1. criar categoria;

1. criar autor;

1. criar livro;

1. criar leitor;

1. criar empréstimo;

1. registrar devolução;

1. executar os cenários de erro.

A coleção deve utilizar variáveis para armazenar os IDs criados durante a execução.

## Problema N+1

O projeto também serve para estudar o problema de consultas N+1, que pode ocorrer quando uma lista de livros é carregada e cada relacionamento é buscado separadamente.

A investigação pode ser feita habilitando os logs SQL:

```
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Depois, compare a quantidade de consultas executadas antes e depois de utilizar uma solução como:

- `@EntityGraph`;

- `JOIN FETCH`;

- projeções;

- consultas específicas para DTOs.

Evite utilizar `FetchType.EAGER` como solução automática, pois essa configuração pode carregar dados desnecessários em outras consultas.

## Estrutura esperada

```
src/
├── main/
│   ├── java/
│   │   └── ...
│   │       ├── controllers/
│   │       ├── dto/
│   │       ├── entities/
│   │       ├── repositories/
│   │       ├── services/
│   │       └── exceptions/
│   └── resources/
│       ├── application.properties
│       └── import.sql
└── test/
    └── java/
```

## Status do projeto

Projeto em desenvolvimento para fins de estudo e prática de desenvolvimento backend com Spring Boot.

## Autor

Desenvolvido por **Erick Ribeiro** como projeto de prática em Java e Spring Boot.
