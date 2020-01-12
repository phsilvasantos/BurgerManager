package burger.model.supply;

public class SodaS extends Supply {
   public static final SodaS me = new SodaS();

   private SodaS() {}

   @Override
   public String toString() {
      return "refrigerante";
   }
}