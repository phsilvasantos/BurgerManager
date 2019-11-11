package burger.action;

public class AddEmployee implements Action {
   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}