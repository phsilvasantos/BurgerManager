package burger.action.payment;

import burger.BurgerMan;
import burger.exception.ValueException;
import burger.model.Order;
import burger.model.employee.Employee;
import burger.model.employee.Supplier;
import burger.model.food.Food;
import burger.model.supply.*;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentHandler {
   private static double fraction, profit;
   private static ArrayList<Order> orders = new ArrayList<>();
   private static ArrayList<Supplier> suppliers = new ArrayList<>();

   public static boolean addOrder(Order order) {
      return orders.add(order);
   }

   public static boolean addSupplier(Supplier supplier) {
      return suppliers.add(supplier);
   }

   static void payEmployees() throws Exception {
      HashMap<Employee, Double> paidEmployees = new HashMap<>();

      for (Order order : orders) {
         double price = 0;
         HashMap<Food, Integer> foods = order.getFoods();

         for (Food food : foods.keySet())
            price += foods.get(food) * (food.getPrice() + profit);

         for (Employee employee : order.getEmployees())
            paidEmployees.put(employee, fraction * price);
      }

      double salary = Supplier.getSalary();

      for (Supplier supplier : suppliers)
         paidEmployees.put(supplier, salary);

      if (paidEmployees.isEmpty())
         throw new Exception("Nenhum pagamento para efetuar.");

      System.out.println();

      for (Employee employee : paidEmployees.keySet()) {
         double payment = paidEmployees.get(employee);

         if (payment > 0)
            System.out.printf("Funcionário %s recebe $%.2f.\n", employee.getName(), payment);
      }

      orders.clear();
      suppliers.clear();
   }

   static void setFraction(double fraction) throws Exception {
      if (fraction < 0 || fraction > 1)
         throw new ValueException();

      PaymentHandler.fraction = fraction;
   }

   static void updatePrices() throws Exception {
      System.out.println("\nTaxa de lucro ($)\n  atual: " + PaymentHandler.profit);
      System.out.print("  novo: ");
      double profit = Double.parseDouble(BurgerMan.input.nextLine());

      if (profit < 0)
         throw new ValueException();

      PaymentHandler.profit = profit;
      System.out.print("\nPorcentagem de remuneração (%)\n  atual: ");
      System.out.println((int) (100 * PaymentHandler.fraction));
      System.out.print("  novo: ");
      double fraction = Integer.parseInt(BurgerMan.input.nextLine()) / 100.0;

      if (fraction < 0)
         throw new ValueException();
      PaymentHandler.fraction = fraction;

      Supply[] supplies = {
         Bread.me, Beef.me, Chicken.me, Cheese.me, Lettuce.me,
         Tomato.me, SodaS.me, JuiceS.me, Box.me, CupHolder.me
      };

      System.out.println("\nPreço dos suprimentos ($)");

      for (Supply supply : supplies) {
         System.out.println("\n" + supply + "\n  atual: " + supply.getPrice());
         System.out.print("  novo: ");
         supply.setPrice(Double.parseDouble(BurgerMan.input.nextLine()));
      }

      System.out.println("\nSalário do fornecedor ($)\n  atual: " + Supplier.getSalary());
      System.out.print("  novo: ");
      Supplier.setSalary(Double.parseDouble(BurgerMan.input.nextLine()));
   }
}