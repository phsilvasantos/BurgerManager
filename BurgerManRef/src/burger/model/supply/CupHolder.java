package burger.model.supply;

public class CupHolder extends Supply {
   public static final CupHolder me = new CupHolder();

   private CupHolder() {}

   @Override
   public String toString() {
      return "porta-copo";
   }
}