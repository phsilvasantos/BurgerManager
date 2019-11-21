package burger.action;

import burger.model.Order;
import burger.model.supply.Supply;

import java.util.ArrayList;

public class MakeOrder implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();
   private static ArrayList<Supply> supplies = new ArrayList<>();

   public static boolean addOrder(Order order) {
      return orders.add(order);
   }

   public static boolean addSupply(Supply supply) {
      return supplies.add(supply);
   }

   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "preparar pedido";
   }
}