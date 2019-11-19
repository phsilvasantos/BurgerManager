package burger.action;

import burger.BurgerMan;
import burger.builder.product.CheeseBurgerBuilder;
import burger.builder.product.ProductBuilder;
import burger.model.Order;
import burger.model.product.Product;

public class TakeOrder implements Action {
   private ProductBuilder[] builders;

   public TakeOrder() {
      builders = new ProductBuilder[] {new CheeseBurgerBuilder()};
   }

   public void execute() throws Exception {
      System.out.println("Endereço de entrega: ");
      String address = BurgerMan.input.nextLine();
      if (address.isEmpty())
         address = "Viagem";

      Order order = new Order(address);

      System.out.println("\n0 - finalizar");
      int p;
      for (p = 1; p <= builders.length; p++)
         System.out.println(p + " - " + builders[p - 1].getType());
      System.out.println();

      while (true) {
         System.out.print("Produto: ");
         p = Integer.parseInt(BurgerMan.input.nextLine());
         if (p == 0)
            break;

         Product product = builders[p - 1].build();

         System.out.print("Quantidade: ");
         int q = Integer.parseInt(BurgerMan.input.nextLine());

         for (p = 0; p < q; p++)
            order.addProduct(product);
      }

      MakeOrder.addToMake(order);
      System.out.println("\nPedido encaminhado para preparo.");
   }

   @Override
   public String toString() {
      return "anotar pedido";
   }
}