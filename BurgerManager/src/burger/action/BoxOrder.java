package burger.action;

public class BoxOrder implements Action {
   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "embalar pedido";
   }
}