package burger.action;

import burger.BurgerMan;
import burger.model.Client;
import burger.model.Order;
import burger.model.employee.Employee;
import burger.model.product.*;

public class TakeOrder implements Action {
   private Product[] products;

   public TakeOrder() {
      products = new Product[] {
         new BeefBurger(), new ChickenBurger(), new CheeseBurger(), new Soda(), new Juice()
      };
   }

   @Override
   public void execute(Employee executor) throws Exception {
      Client client = new Client();

      System.out.println("\nDados do cliente:");
      System.out.print("\nNome: ");
      client.setName(BurgerMan.input.nextLine());
      
      System.out.print("CPF: ");
      client.setCPF(BurgerMan.input.nextLine());
      
      System.out.print("E-mail: ");
      client.setEmail(BurgerMan.input.nextLine());
      
      System.out.print("Endereço de entrega ('-' para viagem): ");
      client.setAddress(BurgerMan.input.nextLine());

      Order order = new Order(client);

      System.out.println("\n0 - finalizar");
      int p;
      for (p = 1; p <= products.length; p++)
         System.out.println(p + " - " + products[p - 1]);
      System.out.println();

      while (true) {
         System.out.print("Produto: ");
         p = Integer.parseInt(BurgerMan.input.nextLine());
         if (p == 0)
            break;

         Product product = products[p - 1];

         System.out.print("Quantidade: ");
         int q = Integer.parseInt(BurgerMan.input.nextLine());

         for (p = 0; p < q; p++)
            order.addProduct(product);
      }

      order.addEmployee(executor);
      MakeOrder.addOrder(order);
      System.out.println("\nPedido " + order.id + " encaminhado para preparo.");
   }

   @Override
   public String toString() {
      return "anotar pedido";
   }
}