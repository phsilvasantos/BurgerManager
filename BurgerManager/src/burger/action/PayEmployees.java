package burger.action;

import burger.exception.ValueException;
import burger.model.Order;
import burger.model.employee.Employee;
import burger.model.employee.Supplier;
import burger.model.food.Food;

import java.util.ArrayList;
import java.util.HashMap;

public class PayEmployees implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();
   private static double fraction, profit;
   private static ArrayList<Supplier> suppliers = new ArrayList<>();

   static boolean addOrder(Order order) {
      return orders.add(order);
   }

   static boolean addSupplier(Supplier supplier) {
      return suppliers.add(supplier);
   }

   @Override
   public void execute(Employee executor) throws Exception {
      HashMap<Employee, Double> paidEmployees = new HashMap<>();

      for (Order order : orders) {
         double price = 0;

         HashMap<Food, Integer> foods = order.getFoods();
         for (Food food : foods.keySet())
            price += foods.get(food) * (food.getPrice() + profit);

         for (Employee employee : order.getEmployees())
            paidEmployees.put(employee, fraction * price);
      }

      for (Supplier supplier : suppliers)
         paidEmployees.put(supplier, supplier.getSalary());

      if (paidEmployees.isEmpty()) {
         throw new Exception("Nenhum pagamento para efetuar.");
      }

      System.out.println();
      for (Employee employee : paidEmployees.keySet()) {
         double payment = paidEmployees.get(employee);
         if (payment > 0)
            System.out.printf("Funcionário %s recebe $%.2f.", employee.getName(), payment);
      }

      orders.clear();
      suppliers.clear();
   }

   static double getFraction() {
      return fraction;
   }

   static double getProfit() {
      return profit;
   }

   static void setFraction(double fraction) throws Exception {
      if (fraction < 0 || fraction > 1)
         throw new ValueException();
      PayEmployees.fraction = fraction;
   }

   static void setProfit(double profit) throws Exception {
      if (profit < 0)
         throw new ValueException();
      PayEmployees.profit = profit;
   }

   @Override
   public String toString() {
      return "remunerar funcionários";
   }
}