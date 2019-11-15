package burger.action;

public class MakeOrder implements Action {
   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "preparar pedido";
   }
}