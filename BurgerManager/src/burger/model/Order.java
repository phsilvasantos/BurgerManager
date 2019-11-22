package burger.model;

import burger.model.product.Product;

import java.util.HashMap;

public class Order {
   public final String address;
   private static int nOrder;
   public final int id;
   private HashMap<Product, Integer> products;

   public Order(String address) {
      this.address = address;
      id = nOrder++;
      products = new HashMap<>();
   }

   public int addProduct(Product product) {
      Integer value = products.get(product);
      int nProduct = value == null ? 0 : value;
      products.put(product, nProduct + 1);

      return nProduct;
   }

   public HashMap<Product, Integer> getProducts() {
      return new HashMap<>(products);
   }
}