package burger.model;

import burger.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
   public final String address;
   private ArrayList<Product> products;

   public Order(String address) {
      this.address = address;
      products = new ArrayList<>();
   }

   public boolean addProduct(Product product) {
      return products.add(product);
   }

   public Product[] getProducts() {
      Product[] products = new Product[this.products.size()];
      int p = 0;
      for (Product product : this.products)
         products[p++] = product;

      return products;
   }

   @Override
   public String toString() {
      String s = "Endereço: " + address;

      HashMap<String, Integer> nProducts = new HashMap<>();
      for (Product product : products) {
         String p = product.toString();
         int np = nProducts.get(p);
         nProducts.put(p, np + 1);
      }

      s += "\nProdutos:";
      for (String p : nProducts.keySet())
         s += String.format("\n  %2d %s", nProducts.get(p), p);

      return s;
   }
}