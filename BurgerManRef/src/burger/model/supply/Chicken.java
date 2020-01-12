package burger.model.supply;

public class Chicken extends Supply {
   public static final Chicken me = new Chicken();

   private Chicken() {}

   @Override
   public String toString() {
      return "frango";
   }
}