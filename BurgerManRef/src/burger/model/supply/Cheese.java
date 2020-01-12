package burger.model.supply;

public class Cheese extends Supply {
   public static final Cheese me = new Cheese();

   private Cheese() {}

   @Override
   public String toString() {
      return "queijo";
   }
}