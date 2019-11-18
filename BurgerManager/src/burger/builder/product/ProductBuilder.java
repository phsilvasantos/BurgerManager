package burger.builder.product;

import burger.builder.Builder;
import burger.model.product.Product;

import java.util.ArrayList;

public abstract class ProductBuilder implements Builder<Product> {
   private static final ArrayList<Product> productsToMake = new ArrayList<>();

   public static boolean addToMake(Product... products) {
      boolean ok = true;
      for (Product product : products)
         ok = productsToMake.add(product);

      return ok;
   }
}