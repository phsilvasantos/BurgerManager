package burger.model.supply;

public class Beef extends Supply {
   public static final Beef me = new Beef();

   private Beef() {}

   @Override
   public String toString() {
      return "carne";
   }
}