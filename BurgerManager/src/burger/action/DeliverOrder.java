
package burger.action;

import burger.BurgerMan;
import burger.model.Order;

import java.util.ArrayList;

public class DeliverOrder implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();
   
   public static boolean addOrder(Order order) {
      return orders.add(order);
   }

   @Override
   public void execute() throws Exception {
      if (orders.isEmpty())
         throw new Exception("Nenhum pedido para entregar.");

      Order order = orders.remove(0);
      System.out.print("\nEndereço de entrega: ");
      if (order.address == null)
         System.out.println("Viagem");
      else
         System.out.println(order.address);

      System.out.print("Confirmar entrega (s/n): ");
      if (BurgerMan.input.nextLine().equals("n")) {
         addOrder(order);
         System.out.println("Entrega do pedido " + order.id + " cancelada.");
      } else
         System.out.println("Pedido " + order.id + " entregue.");
   }

   @Override
   public String toString() {
      return "entregar pedido";
   }
}