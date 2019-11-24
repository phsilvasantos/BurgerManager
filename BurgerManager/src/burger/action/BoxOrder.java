package burger.action;

import burger.model.Order;
import burger.model.employee.Employee;
import burger.model.product.Product;
import burger.model.supply.Supply;

import java.util.ArrayList;
import java.util.HashMap;

public class BoxOrder implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();
   private static HashMap<Supply, Integer> storage = new HashMap<>();

   public static boolean addOrder(Order order) {
      return orders.add(order);
   }

   public static int addPackage(Supply pack) {
      Integer value = storage.get(pack);
      int nPack = value == null ? 0 : value;
      storage.put(pack, nPack + 1);

      return nPack;
   }

   @Override
   public void execute(Employee executor) throws Exception {
      if (orders.isEmpty())
         throw new Exception("Nenhum pedido para embalar.");

      System.out.println("\nEmbalagens em estoque:");
      for (Supply pack : storage.keySet())
         System.out.println(pack + ": " + storage.get(pack));

      Order order = orders.remove(0);
      HashMap<Product, Integer> products = order.getProducts();
      HashMap<Supply, Integer> packs = new HashMap<>();

      for (Product product : products.keySet()) {
         int nProduct = products.get(product);
         Supply pack = product.getPackage();
         Integer value = packs.get(pack);
         int nPack = value == null ? 0 : value;
         packs.put(pack, nPack + nProduct);
      }

      boolean ok = true;
      for (Supply pack : packs.keySet()) {
         int nPack = packs.get(pack);
         Integer value = storage.get(pack);
         int nsPack = value == null ? 0 : value;
         nPack = nsPack - nPack;
         ok = ok && nPack >= 0;
         packs.put(pack, nPack);
      }

      if (ok) {
         for (Supply pack : packs.keySet())
            storage.put(pack, packs.get(pack));
         order.addEmployee(executor);
         DeliverOrder.addOrder(order);
         System.out.println("\nPedido " + order.id + " encaminhado para entrega.");
      } else {
         addOrder(order);
         System.out.println("\n<!> Pedido " + order.id + " não pode ser embalado.");
      }
   }

   @Override
   public String toString() {
      return "embalar pedido";
   }
}