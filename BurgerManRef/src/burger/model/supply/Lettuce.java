package burger.model.supply;

public class Lettuce extends Supply {
   public static final Lettuce me = new Lettuce();

   private Lettuce() {}

   @Override
   public String toString() {
      return "alface";
   }
}