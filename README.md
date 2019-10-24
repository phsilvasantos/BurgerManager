# BurgerManager
Sistema de gestão de uma hamburgueria delivery. Tem como objetivo o gerenciamento tanto de pedidos
dos clientes como o pagamento dos funcionários.

Os pedidos podem ser feitos pessoalmente, no balcão de pedidos, ou à distância, por telefone, site,
etc. Existem várias opções de pedido, e cada pedido pode incluir mais de uma opção.

As opções de pedido incluem:
- **Hamburger de carne:** pão, carne bovina, molho, alface e tomate.
- **Hamburger de frango:** pão, carne de frango, molho, alface e tomate.
- **Cheeseburger:** pão, queijo, molho, alface e tomate.
- **Bebida:** refrigerante ou suco.

O preço de cada opção depende do preço dos suprimentos (ingredientes e embalagens) utilizados e da
margem de lucro desejada. Esses valores são pré-determinados, mas podem ser atualizados
posteriormente.

Os funcionários da hamburgueria são divididos em:
- **Atendentes:** responsáveis por receber e anotar os pedidos.
- **Cozinheiros:** responsáveis pelo preparo dos pedidos.
- **Embaladores:** responsáveis por embalar os pedidos para entrega.
- **Entregadores:** responsáveis por entregar os pedidos.
- **Fornecedores:** devem observar a quantidade de suprimentos em estoque e, caso estejam em falta,
devem providenciar o reabastecimento.
- **Gerente:** responsável pela admissão, demissão e remuneração dos funcionários, dentre outras
funções.

Funcionários recebem por pedidos processados e entregues com sucesso. O valor a ser pago é uma
porcentagem pré-determinada (e modificável) do valor dos pedidos.

## Funcionalidades
1. **Anotar pedido:** O atendente anota o pedido do cliente. O pedido é encaminhado para preparo.
2. **Preparar pedido:** O cozinheiro prepara o pedido e o encaminha para embalagem. Se um ou mais
ingredientes estiver em falta, o pedido não pode ser preparado. 
3. **Embalar pedido:** O embalador embala adequadamente o pedido, encaminhando-o em seguida para
entrega. Hamburguer e cheesburger são embalados em caixas e bebidas são inseridas em porta-copos.
Caso alguma embalagem esteja em falta, o pedido não pode ser embalado.
4. **Entregar pedido:** O entregador entrega o pedido na residência do cliente, caso tenha sido
feito à distância. Se o pedido foi feito presencialmente, o entregador encaminha o pedido para
o balcão de entregas.
5. **Adquirir suprimentos:** O fornecedor faz a compra (às custas da hamburgueria) dos suprimentos
que estiverem faltando no estoque.
6. **Contratar funcionário:** O gerente adiciona um funcionário. São fornecidos nome, CPF, e-mail e
o cargo na hamburgueria.
7. **Demitir funcionário:** O gerente remove um funcionário.
8. **Alterar dados de funcionário:** O funcionário altera ou adiciona dados pessoais. O gerente deve
então validar ou rejeitar os dados.
9. **Remunerar funcionários:** O gerente faz a remuneração periódica dos funcionários.
10. **Atualizar preços:** O gerente atualiza o preço dos suprimentos, bem como as porcentagens de
lucro e de remuneração.
11. **Emitir relatórios:** O gerente faz a emissão periódica de relatórios de produção, suprimentos
em estoque e/ou informações sobre funcionários.