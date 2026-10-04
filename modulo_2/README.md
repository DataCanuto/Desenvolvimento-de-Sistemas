# Módulo 2 — Banco de Dados, Java POO e Spring Boot

Segundo módulo do curso de Desenvolvimento de Sistemas (SENAI CIMATEC), de fevereiro a agosto
de 2026. Foco no back-end: modelagem e consultas em banco de dados relacional, Programação
Orientada a Objetos com Java e construção de APIs REST com Spring Boot.

| Pasta | Período |
|---|---|
| [`banco-de-dados/`](banco-de-dados) | fev/2026 – abr/2026 |
| [`JavaPOO/`](JavaPOO) | mar/2026 – ago/2026 |
| [`SpringBootProjects/`](SpringBootProjects) | mai/2026 – ago/2026 |

## 1. Banco de Dados (`banco-de-dados/`)

Scripts SQL (SQL Server Express) da introdução a banco de dados:

- **Aulas:** introdução, empréstimo de livros e loja de vendas
- **Exercícios de modelagem:** pet shop, escola e aula de música
- **`ecommerceDB/`:** banco de um e-commerce dividido em criação das tabelas, carga, consultas
  (`ecommerceQuerys.sql`) e views (`ecommerceVW.sql`)

## 2. Java POO (`JavaPOO/`)

Projetos que demonstram os pilares da Orientação a Objetos e recursos do Java 21:

| Pasta | Tema |
|---|---|
| `Encapsulamento` | Proteção de estado e acesso por métodos |
| `Heranças` | Reaproveitamento por herança |
| `Polimorfismo` | Mesmo método, comportamentos diferentes |
| `SobrecargaMetodos` | Sobrecarga de métodos (ex.: SafeBank v3) |
| `Interfaces` | Contratos entre classes |
| `Records` | Tipos de dados imutáveis |
| `CollectionsAPI` | Listas, conjuntos e mapas |
| `StreamAPI` | Processamento de coleções com streams |
| `TratamentoErro` | Exceções |
| `MyFirstMavenProject` | Primeiro projeto com Maven |
| `JavaSwingProjects` | Interfaces gráficas com Swing (calculadora, cadastro de pessoas) |
| `Sudoku` | Jogo de Sudoku em Java |

## 3. Spring Boot (`SpringBootProjects/`)

Evolução de controllers simples até APIs REST com camadas e persistência:

| Ordem | Projeto | Descrição |
|---|---|---|
| 1 | `aula-springboot` | Primeiro contato: estrutura do projeto e primeiros models |
| 2 | `cimatec` | API de prontuário de pacientes |
| 3 | `primeiros-passos` | Controller simples e model de usuário |
| 4 | `my-first-web-api` | Web API com controller, repository e Swagger |
| 5 | `aula-spring-data-jpa` | Introdução ao Spring Data JPA |
| 6 | `lab-padroes-projeto-spring` | Padrões de projeto e integração com a API ViaCEP (laboratório DIO) |
| 7 | `crud` | CRUD de agendamento de aulas (aluno, professor, aula) |
| 8 | `petshop-project` | CRUD de pet shop (tutor, animal, endereço) |
| 9 | `apicimatec` | Evolução da API (clientes, passaportes, pedidos) |
| 10 | `cafeteria-web-api` | Gestão de cafeteria (clientes, funcionários, produtos, pedidos e pagamentos) |

Detalhes e instruções de execução estão no [README do SpringBootProjects](SpringBootProjects/README.md).

## Competências desenvolvidas

- Modelagem relacional, DDL/DML, consultas e views em SQL Server
- Pilares da POO e recursos modernos do Java (records, streams, collections, exceções)
- Build com Maven
- APIs REST com Spring Boot em camadas (controller, service, repository)
- Persistência com Spring Data JPA, documentação com Swagger e integração com API externa

---

[← Voltar ao repositório principal](../README.md)
