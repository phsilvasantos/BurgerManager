package burger.action;

import burger.model.Order;
import burger.model.employee.Employee;

import java.util.ArrayList;

public class PayEmployees implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();

   public static boolean addOrder(Order order) {
      return orders.add(order);
   }

   @Override
   public void execute(Employee executor) throws Exception {
      System.out.println("Em desenvolvimento.");
   }
}