package burger.action;

import burger.model.Order;

import java.util.ArrayList;

public class MakeOrder implements Action {
   private static final ArrayList<Order> ordersToMake = new ArrayList<>();

   public static boolean addToMake(Order order) {
      return ordersToMake.add(order);
   }

   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "preparar pedido";
   }
}