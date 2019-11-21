package burger.model;

import burger.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
   public final String address;
   private ArrayList<Product> products;
   private HashMap<String, Integer> nProducts;

   public Order(String address) {
      this.address = address;
      products = new ArrayList<>();
      nProducts = new HashMap<>();
   }

   public boolean addProduct(Product product) {
      boolean ok = products.add(product);

      String p = product.toString();
      Integer np = nProducts.get(p);
      if (np == null)
         np = new Integer(0);
      nProducts.put(p, np + 1);

      return ok;
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
      String s = "Endereço: " + address + "\nProdutos:";
      for (String p : nProducts.keySet())
         s += String.format("\n  %2d %s", nProducts.get(p), p);

      return s;
   }
}