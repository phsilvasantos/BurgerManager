package burger.action;

public class DeliverOrder implements Action {
   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "entregar pedido";
   }
}