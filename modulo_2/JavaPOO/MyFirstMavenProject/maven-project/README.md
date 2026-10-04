# maven-project

Primeiro projeto Maven do repositório: demonstra DTO/Model com mapeamento automático via MapStruct e geração de boilerplate (getters/setters/construtores) via Lombok.

## Conteúdo

- `pom.xml` — projeto Maven (Java 21) com as dependências `mapstruct`, `mapstruct-processor`, `lombok` e `lombok-mapstruct-binding`, configurando o `maven-compiler-plugin` com os annotation processors.
- `Main.java` — cria um `UserDTO`, converte manualmente para `UserModel` e usa o `UserMapper` gerado pelo MapStruct para converter de volta a DTO.
- `dto/UserDTO.java` — DTO anotado com `@Data` (Lombok) contendo `id`, `name`, `birthdate`.
- `model/UserModel.java` — model anotado com `@Getter`, `@Setter`, `@EqualsAndHashCode`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@ToString` (Lombok), contendo `code`, `userName`, `birthdate`.
- `mapper/UserMapper.java` — interface `@Mapper` do MapStruct que mapeia `id↔code` e `name↔userName` entre `UserDTO` e `UserModel`.

## Como rodar

```bash
cd MyFirstMavenProject/maven-project
mvn compile exec:java -Dexec.mainClass=br.com.DataCanuto.Main
```
