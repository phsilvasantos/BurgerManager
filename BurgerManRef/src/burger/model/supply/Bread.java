package burger.model.supply;

public class Bread extends Supply {
   public static final Bread me = new Bread();

   private Bread() {}

   @Override
   public String toString() {
      return "pão";
   }
}