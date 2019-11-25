package burger.action;

import burger.BurgerMan;
import burger.model.Client;
import burger.model.Order;
import burger.model.employee.Employee;
import burger.model.food.*;

public class TakeOrder implements Action {
   private Food[] foods;

   public TakeOrder() {
      foods = new Food[] {
         new BeefBurger(), new ChickenBurger(), new CheeseBurger(), new SodaP(), new JuiceP()
      };
   }

   @Override
   public void execute(Employee executor) throws Exception {
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

      order.addEmployee(executor);
      MakeOrder.addOrder(order);
      System.out.println("\nPedido " + order.id + " encaminhado para preparo.");
   }

   @Override
   public String toString() {
      return "anotar pedido";
   }
}