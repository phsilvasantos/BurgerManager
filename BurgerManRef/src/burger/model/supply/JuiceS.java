package burger.model.supply;

public class JuiceS extends Supply {
   public static final JuiceS me = new JuiceS();

   private JuiceS() {}

   @Override
   public String toString() {
      return "suco";
   }
}