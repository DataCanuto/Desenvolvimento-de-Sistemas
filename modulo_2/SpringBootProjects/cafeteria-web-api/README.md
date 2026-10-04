# cafeteria-web-api

API para gestão de uma cafeteria, cobrindo clientes, funcionários, gerentes, produtos, pedidos, itens de pedido e pagamentos.

## Conteúdo

- `controller/`: ClienteController, FuncionarioController, GerenteController, ItemPedidoController, PagamentoController, PedidoController, ProdutoController
- `model/`: Cliente, Funcionario, Gerente, ItemPedido, Pagamento, Pedido, Produto
- `repository/`: repositórios JPA correspondentes a cada entidade

## Como rodar

```bash
./mvnw spring-boot:run
```
