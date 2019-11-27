package burger.action;

import burger.BurgerMan;
import burger.model.Order;
import burger.model.employee.Employee;
import burger.model.supply.Supply;

import java.util.ArrayList;
import java.util.HashMap;

public class GenerateReport implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();

   static boolean addOrder(Order order) {
      return orders.add(order);
   }

   @Override
   public void execute(Employee executor) {
      System.out.println("\nPedidos:");
      for (Order order : orders)
         System.out.println("\n" + order);

      System.out.println("\nSuprimentos em estoque:");

      HashMap<Supply, Integer> storage = MakeOrder.getStorage();
      for (Supply ingredient : storage.keySet()) {
         int nIngredient = storage.get(ingredient);
         System.out.println("  " + ingredient + ": " + nIngredient);
      }

      storage = BoxOrder.getStorage();
      for (Supply pack : storage.keySet()) {
         int nPack = storage.get(pack);
         System.out.println("  " + pack + ": " + nPack);
      }

      System.out.println("\nFuncionários:");
      for (Employee employee : BurgerMan.getEmployees())
         System.out.println("\n" + employee);
   }

   @Override
   public String toString() {
      return "emitir relatório";
   }
}