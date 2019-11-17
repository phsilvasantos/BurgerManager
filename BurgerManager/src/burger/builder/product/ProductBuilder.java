package burger.builder.product;

import burger.builder.Builder;
import burger.model.product.Product;

import java.util.ArrayList;

public abstract class ProductBuilder implements Builder<Product> {
   private static final ArrayList<Product> productsToMake = new ArrayList<>();

   protected boolean addToMake(Product product) {
      return productsToMake.add(product);
   }
}