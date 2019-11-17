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
      System.out.println();
      int p;
      for (p = 0; p < builders.length; p++)
         System.out.println(p + " - " + builders[p].getType());
      System.out.print("\nPedido: ");
      p = Integer.parseInt(BurgerMan.input.nextLine());

      Product product = builders[p].build();
      System.out.println("Produto '" + product + "' encaminhado para preparo.");
   }

   @Override
   public String toString() {
      return "anotar pedido";
   }
}