package burger.model.supply;

public class Box extends Supply {
   public static final Box me = new Box();

   private Box() {}

   @Override
   public String toString() {
      return "caixa";
   }
}