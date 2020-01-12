package burger.model.supply;

public class Tomato extends Supply {
   public static final Tomato me = new Tomato();

   private Tomato() {}

   @Override
   public String toString() {
      return "tomate";
   }
}