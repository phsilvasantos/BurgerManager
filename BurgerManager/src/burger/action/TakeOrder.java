package burger.action;

import burger.BurgerMan;
import burger.builder.product.CheeseBurgerBuilder;
import burger.builder.product.ProductBuilder;
import burger.model.product.Product;

public class TakeOrder implements Action {
   private ProductBuilder[] builders;

   public TakeOrder() {
      builders = new ProductBuilder[] {new CheeseBurgerBuilder()};
   }

   public void execute() throws Exception {
      System.out.println("\n0 - finalizar");
      int p;
      for (p = 1; p <= builders.length; p++)
         System.out.println(p + " - " + builders[p - 1].getType());
      System.out.println();

      int[] nProducts = new int[builders.length];
      Product[] order = new Product[16];

      for (int q = 1; q <= order.length; q++) {
         System.out.print("Produto (" + q + " de " + order.length + "): ");
         p = Integer.parseInt(BurgerMan.input.nextLine());
         if (p == 0)
            break;

         order[q - 1] = builders[p - 1].build();
         nProducts[p - 1]++;
      }

      System.out.println("\nPedido:");
      for (p = 0; p < builders.length; p++)
         System.out.printf("%2d %s\n", nProducts[p], builders[p].getType());

      ProductBuilder.addToMake(order);
      System.out.println("\nPedido encaminhado para preparo.");
   }

   @Override
   public String toString() {
      return "anotar pedido";
   }
}