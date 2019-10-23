# BurgerManager
Sistema de gestão de uma hamburgueria delivery. Tem como objetivo o gerenciamento tanto de pedidos
dos clientes como o pagamento dos funcionários.

Os pedidos podem ser feitos pessoalmente, na hamburgueria, ou à distância, por telefone, site, etc.
As opções de pedido incluem:
- **Hamburger de carne:** pão, carne bovina, molho, alface e tomate.
- **Hamburger de frango:** pão, carne de frango, molho, alface e tomate.
- **Cheeseburger:** pão, queijo, molho, alface e tomate.
- **Bebida:** refrigerante ou suco.
Os pedidos podem incluir mais de uma opção.

Os funcionários da hamburgueria são divididos em:
- **Atendentes:** responsáveis por receber e anotar os pedidos.
- **Cozinheiros:** responsáveis pelo preparo dos pedidos.
- **Embaladores:** responsáveis por embalar os pedidos para entrega.
- **Entregadores:** responsáveis por entregar os pedidos.
- **Fornecedores:** devem observar a quantidade de suprimentos (ingredientes, embalagens, etc.) em
estoque e, caso estejam em falta, devem providenciar o reabastecimento.
- **Gerente:** responsável pela admissão, demissão e remuneração dos funcionários, dentre outras
funções.

## Funcionalidades
1. **Anotar pedido:** O atendente anota o pedido do cliente. O pedido é encaminhado para preparo.
2. **Preparar pedido:** O cozinheiro prepara o pedido e o encaminha para embalagem. Se um ou mais
ingredientes estiver em falta, o pedido não pode ser preparado. 
3. **Embalar pedido:** O embalador embala adequadamente o pedido, encaminhando-o em seguida para
entrega. Hamburguer e cheesburger são embalados em caixas e bebidas são inseridas em porta-copos.
Caso alguma embalagem esteja em falta, o pedido não pode ser embalado.
4. **Entregar pedido:** O entregador entrega o pedido na residência do cliente, caso tenha sido
feito à distância. Se o pedido foi feito presencialmente, o entregador encaminha o pedido para
o balcão de entregas da hamburgueria.
5. **Adquirir suprimentos:** O fornecedor faz a compra (às custas da hamburgueria) dos suprimentos
que estiverem faltando no estoque.
6. **Contratar funcionário:** O gerente adiciona um funcionário. São fornecidos nome, CPF, e-mail e
o cargo na hamburgueria.
7. **Demitir funcionário:** O gerente remove um funcionário.
8. **Alterar dados de funcionário:** O funcionário altera ou adiciona dados pessoais. O gerente deve
então validar ou rejeitar os dados.
9. **Remunerar funcionários:** Funcionários recebem por pedidos processados e entregues com sucesso.
O gerente faz a remuneração periódica dos funcionários.
10. **Emitir relatórios:**
