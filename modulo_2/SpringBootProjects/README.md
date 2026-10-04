# SpringBootProjects

Repositório geral que reúne os projetos desenvolvidos durante os estudos e certificações em **Spring Boot**, incluindo exercícios de aula, laboratórios de faculdade/cursos (SENAI, DIO) e projetos de certificação.

O objetivo deste repositório é centralizar a evolução do aprendizado: dos primeiros testes com controllers simples até APIs REST completas com camadas de serviço, persistência (JPA).

## Linha do tempo dos projetos

A lista abaixo segue a ordem cronológica de criação, do primeiro contato com Spring Boot até os projetos mais recentes.

| Ordem | Projeto | Descrição rápida |
|---|---|---|
| 1 | [aula-springboot](aula-springboot) | Primeiro contato com Spring Boot: estrutura básica do projeto e primeiros models. |
| 2 | [cimatec](cimatec) | API de prontuário de pacientes (cadastro de pacientes e usuários). |
| 3 | [primeiros-passos](primeiros-passos) | Exercício introdutório com um controller simples ("Hello") e um model de usuário. |
| 4 | [my-first-web-api](my-first-web-api) | Primeira Web API "completa", com controller, repository e documentação via Swagger. |
| 5 | [aula-spring-data-jpa](aula-spring-data-jpa) | Introdução ao Spring Data JPA: entidade `User` e repositório JPA. |
| 6 | [lab-padroes-projeto-spring](lab-padroes-projeto-spring) | Laboratório da DIO sobre padrões de projeto com Spring (camadas de service/serviceImpl e integração com API externa ViaCEP). |
| 7 | [crud](crud) | CRUD de agendamento de aulas (Aluno, Professor, Aula). |
| 8 | [petshop-project](petshop-project) | CRUD para um petshop (Tutor, Animal, Endereço). |
| 9 | [apicimatec](apicimatec) | Evolução da API do Cimatec (clientes, passaportes, pedidos). |
| 10 | [cafeteria-web-api](cafeteria-web-api) | API para gestão de uma cafeteria (clientes, funcionários, produtos, pedidos e pagamentos). |

## Acesso rápido por tema

- **Primeiros passos com Spring Boot:** [aula-springboot](aula-springboot), [primeiros-passos](primeiros-passos), [my-first-web-api](my-first-web-api)
- **Persistência com JPA:** [aula-spring-data-jpa](aula-spring-data-jpa), [cimatec](cimatec)
- **CRUDs completos (Controller + Service + Repository):** [crud](crud), [petshop-project](petshop-project), [apicimatec](apicimatec), [cafeteria-web-api](cafeteria-web-api)
- **Padrões de projeto e integração externa:** [lab-padroes-projeto-spring](lab-padroes-projeto-spring)

## Como rodar um projeto

A maioria dos projetos usa Maven Wrapper. Dentro da pasta do projeto desejado:

```bash
./mvnw spring-boot:run
```

Cada pasta possui seu próprio `README.md` com detalhes específicos do projeto.
