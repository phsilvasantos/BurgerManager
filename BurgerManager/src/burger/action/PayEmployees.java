package burger.action;

import burger.BurgerMan;
import burger.model.Order;
import burger.model.ValueException;
import burger.model.employee.Employee;
import burger.model.employee.Supplier;
import burger.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class PayEmployees implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();
   private static double fraction, profit;

   public static boolean addOrder(Order order) {
      return orders.add(order);
   }

   @Override
   public void execute(Employee executor) throws Exception {
      HashMap<Employee, Double> paidEmployees = new HashMap<>();

      for (Order order : orders) {
         double price = 0;

         HashMap<Product, Integer> products = order.getProducts();
         for (Product product : products.keySet())
            price += products.get(product) * (product.getPrice() + profit);

         for (Employee employee : order.getEmployees())
            paidEmployees.put(employee, fraction * price);
      }

      System.out.println();
      for (Employee employee : BurgerMan.getEmployees()) {
         double payment;
         if (employee instanceof Supplier)
            payment = ((Supplier) employee).getSalary();
         else {
            Double value = paidEmployees.get(employee);
            payment = value == null ? 0 : value;
         }
         if (payment > 0)
            System.out.printf("Funcionário '%s' recebe $%.2f.", employee.getName(), payment);
      }
   }

   public static void setFraction(double fraction) throws Exception {
      if (fraction < 0 || fraction > 1)
         throw new ValueException();
      PayEmployees.fraction = fraction;
   }

   public static void setProfit(double profit) throws Exception {
      if (profit < 0)
         throw new ValueException();
      PayEmployees.profit = profit;
   }
}