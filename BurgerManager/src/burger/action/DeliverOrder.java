package burger.action;

import burger.BurgerMan;
import burger.model.Order;
import burger.model.employee.Employee;

import java.util.ArrayList;

public class DeliverOrder implements Action {
   private static ArrayList<Order> orders = new ArrayList<>();
   
   static boolean addOrder(Order order) {
      return orders.add(order);
   }

   @Override
   public void execute(Employee executor) throws Exception {
      if (orders.isEmpty())
         throw new Exception("Nenhum pedido para entregar.");

      Order order = orders.remove(0);
      System.out.println("Dados do cliente:");
      System.out.println("\nNome: " + order.client.getName());
      System.out.println("CPF: " + order.client.getCPF());
      System.out.println("E-mail: " + order.client.getEmail());

      System.out.print("Endereço de entrega: ");
      String address = order.client.getAddress();
      if (address.equals("-"))
         System.out.println("Viagem");
      else
         System.out.println(address);

      System.out.print("Confirmar entrega (s/n): ");
      if (BurgerMan.input.nextLine().toLowerCase().equals("n")) {
         addOrder(order);
         System.out.println("<!> Entrega do pedido " + order.id + " cancelada.");
      } else {
         order.addEmployee(executor);
         PayEmployees.addOrder(order);
         //GenerateReport.addOrder(order);
         System.out.println("Pedido " + order.id + " entregue.");
      }
   }

   @Override
   public String toString() {
      return "entregar pedido";
   }
}