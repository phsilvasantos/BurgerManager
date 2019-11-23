package burger.action;

import burger.BurgerMan;
import burger.model.Order;
import burger.model.product.*;

public class TakeOrder implements Action {
   private Product[] products;

   public TakeOrder() {
      products = new Product[] {
         new BeefBurger(), new ChickenBurger(), new CheeseBurger(), new Soda(), new Juice()
      };
   }

   @Override
   public void execute() throws Exception {
      System.out.print("\nEndereço de entrega: ");
      String address = BurgerMan.input.nextLine();
      if (address.isEmpty())
         address = "Viagem";

      Order order = new Order(address);

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

      MakeOrder.addOrder(order);
      System.out.println("\nPedido " + order.id + " encaminhado para preparo.");
   }

   @Override
   public String toString() {
      return "anotar pedido";
   }
}