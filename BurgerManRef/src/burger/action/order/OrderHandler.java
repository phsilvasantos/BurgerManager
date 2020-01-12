package burger.action.order;

import burger.BurgerMan;
import burger.action.payment.PaymentHandler;
import burger.model.Client;
import burger.model.Order;
import burger.model.employee.Boxer;
import burger.model.employee.Cashier;
import burger.model.employee.Cook;
import burger.model.employee.Deliverer;
import burger.model.employee.Supplier;
import burger.model.food.*;
import burger.model.supply.*;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderHandler {
   private static ArrayList<Order>
      boxedOrders = new ArrayList<>(),
      deliveredOrders = new ArrayList<>(),
      madeOrders = new ArrayList<>(),
      takenOrders = new ArrayList<>();
   private static HashMap<Supply, Integer> storage = new HashMap<>();

   static void acquireSupplies(Supplier agent) throws Exception {
      Supply[] supplies = {
         Bread.me, Beef.me, Chicken.me, Cheese.me, Lettuce.me,
         Tomato.me, SodaS.me, JuiceS.me, Box.me, CupHolder.me
      };

      System.out.println("\n0 - finalizar");
      int s;

      for (s = 1; s <= supplies.length; s++)
         System.out.println(s + " - " + supplies[s - 1]);
      System.out.println();

      HashMap<Supply, Integer> nSupplies = new HashMap<>();

      while (true) {
         System.out.print("Suprimento: ");
         s = Integer.parseInt(BurgerMan.input.nextLine());

         if (s == 0)
            break;

         Supply supply = supplies[s - 1];

         System.out.print("Quantidade: ");
         int nSupply = Integer.parseInt(BurgerMan.input.nextLine());

         if (nSupply > 0)
            nSupplies.put(supply, nSupply);
      }

      if (!nSupplies.isEmpty()) {
         for (Supply supply : nSupplies.keySet()) {
            int nSupply = nSupplies.get(supply);
            Integer value = storage.get(supply);
            int nStored = value == null ? 0 : value;
            storage.put(supply, nStored + nSupply);
         }
 
         PaymentHandler.addSupplier(agent);
         System.out.println("\nSuprimentos adicionados.");
      }
   }

   static void boxOrder(Boxer agent) throws Exception {
      if (madeOrders.isEmpty())
         throw new Exception("Nenhum pedido para embalar.");

      for (Order order : madeOrders) {
         System.out.println("\nPedido " + order.id + ":");

         if (getSupplies(order, false)) {
            order.addEmployee(agent);
            madeOrders.remove(order);
            boxedOrders.add(order);
            System.out.println("\nPedido encaminhado para entrega.");
            break;
         } else
            System.out.println("\n<!> Pedido não pode ser embalado.");
      }
   }

   static void deliverOrder(Deliverer agent) throws Exception {
      if (boxedOrders.isEmpty())
         throw new Exception("Nenhum pedido para entregar.");

      Order order = boxedOrders.remove(0);
      System.out.println("\nPedido " + order.id + ":\n\nDados do cliente:");
      System.out.println("  Nome: " + order.client.getName());
      System.out.println("  CPF: " + order.client.getCPF());
      System.out.println("  E-mail: " + order.client.getEmail());
      System.out.print("  Endereço de entrega: ");
      String address = order.client.getAddress();

      if (address.equals("-"))
         System.out.println("Viagem");
      else
         System.out.println(address);

      System.out.print("\nConfirmar entrega (s/n): ");
      if (BurgerMan.input.nextLine().toLowerCase().equals("n")) {
         boxedOrders.add(order);
         System.out.println("<!> Entrega cancelada.");
      } else {
         order.addEmployee(agent);
         deliveredOrders.add(order);
         PaymentHandler.addOrder(order);
         System.out.println("Pedido entregue.");
      }
   }

   private static boolean getSupplies(Order order, boolean make) {
      HashMap<Food, Integer> foods = order.getFoods();
      HashMap<Supply, Integer> nSupplies = new HashMap<>();

      for (Food food : foods.keySet()) {
         int nFood = foods.get(food);
         Supply[] supplies;
         
         if (make)
            supplies = food.getIngredients();
         else
            supplies = new Supply[] {food.getPackage()};

         for (Supply supply : supplies) {
            Integer value = nSupplies.get(supply);
            int nSupply = value == null ? 0 : value;
            nSupplies.put(supply, nSupply + nFood);
         }
      }

      boolean ok = true;
      System.out.println("\nSuprimentos:");

      for (Supply supply : nSupplies.keySet()) {
         int nSupply = nSupplies.get(supply);
         Integer value = storage.get(supply);
         int nStored = value == null ? 0 : value;
         System.out.println("  " + supply + ": " + nSupply + " (" + nStored + " em estoque)");
         nSupply = nStored - nSupply;
         ok = ok && nSupply >= 0;
         nSupplies.put(supply, nSupply);
      }

      if (ok)
         for (Supply supply : nSupplies.keySet())
            storage.put(supply, nSupplies.get(supply));

      return ok;
   }

   static void makeOrder(Cook agent) throws Exception {
      if (takenOrders.isEmpty())
         throw new Exception("Nenhum pedido para preparar.");

      for (Order order : takenOrders) {
         System.out.println("\nPedido " + order.id + ":");

         if (getSupplies(order, true)) {
            order.addEmployee(agent);
            takenOrders.remove(order);
            madeOrders.add(order);
            System.out.println("\nPedido encaminhado para embalagem.");
            break;
         } else
            System.out.println("\n<!> Pedido não pode ser preparado.");
      }
   }

   static void takeOrder(Cashier agent) throws Exception {
      Client client = new Client();

      System.out.println("\nDados do cliente:");
      System.out.print("\nNome: ");
      client.setName(BurgerMan.input.nextLine());
      System.out.print("CPF: ");
      client.setCPF(BurgerMan.input.nextLine());
      System.out.print("E-mail: ");
      client.setEmail(BurgerMan.input.nextLine());
      System.out.print("Endereço de entrega ('-' para viagem): ");
      client.setAddress(BurgerMan.input.nextLine());

      Order order = new Order(client);
      Food[] foods = {BeefBurger.me, ChickenBurger.me, CheeseBurger.me, SodaF.me, JuiceF.me};
      System.out.println("\n0 - finalizar");
      int f;

      for (f = 1; f <= foods.length; f++)
         System.out.println(f + " - " + foods[f - 1]);

      System.out.println();

      while (true) {
         System.out.print("Item: ");
         f = Integer.parseInt(BurgerMan.input.nextLine());

         if (f == 0)
            break;

         Food food = foods[f - 1];
         System.out.print("Quantidade: ");
         int nFood = Integer.parseInt(BurgerMan.input.nextLine());

         for (f = 0; f < nFood; f++)
            order.addFood(food);
      }

      order.addEmployee(agent);
      takenOrders.add(order);
      System.out.println("\nPedido " + order.id + " encaminhado para preparo.");
   }

   public static void viewDeliveredOrders() {
      System.out.println("Pedidos entregues:");

      for (Order order : deliveredOrders)
         System.out.println("\n" + order);
   }

   public static void viewStorage() {
      System.out.println("Suprimentos em estoque:");

      for (Supply supply : storage.keySet())
         System.out.println("  " + supply + ": " + storage.get(supply));
   }
}