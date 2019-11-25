package burger.action;

import burger.model.Order;
import burger.model.employee.Employee;
import burger.model.food.Food;
import burger.model.supply.Supply;

import java.util.ArrayList;
import java.util.HashMap;

public class MakeOrder implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();
   private static HashMap<Supply, Integer> storage = new HashMap<>();

   public static boolean addOrder(Order order) {
      return orders.add(order);
   }

   public static int addIngredient(Supply ingredient) {
      Integer value = storage.get(ingredient);
      int nIngredient = value == null ? 0 : value;
      storage.put(ingredient, nIngredient + 1);

      return nIngredient;
   }

   @Override
   public void execute(Employee executor) throws Exception {
      if (orders.isEmpty())
         throw new Exception("Nenhum pedido para preparar.");

      System.out.println("\nIngredientes em estoque:");
      for (Supply ingredient : storage.keySet())
         System.out.println(ingredient + ": " + storage.get(ingredient));

      Order order = orders.remove(0);
      HashMap<Food, Integer> foods = order.getFoods();
      HashMap<Supply, Integer> ingredients = new HashMap<>();

      for (Food food : foods.keySet()) {
         int nFood = foods.get(food);
         for (Supply ingredient : food.getIngredients()) {
            Integer value = ingredients.get(ingredient);
            int nIngredient = value == null ? 0 : value;
            ingredients.put(ingredient, nIngredient + nFood);
         }
      }

      boolean ok = true;
      for (Supply ingredient : ingredients.keySet()) {
         int nIngredient = ingredients.get(ingredient);
         Integer value = storage.get(ingredient);
         int nsIngredient = value == null ? 0 : value;
         nIngredient = nsIngredient - nIngredient;
         ok = ok && nIngredient >= 0;
         ingredients.put(ingredient, nIngredient);
      }

      if (ok) {
         for (Supply ingredient : ingredients.keySet())
            storage.put(ingredient, ingredients.get(ingredient));
         order.addEmployee(executor);
         BoxOrder.addOrder(order);
         System.out.println("\nPedido " + order.id + " encaminhado para embalagem.");
      } else {
         addOrder(order);
         System.out.println("\n<!> Pedido " + order.id + " não pode ser preparado.");
      }
   }

   @Override
   public String toString() {
      return "preparar pedido";
   }
}