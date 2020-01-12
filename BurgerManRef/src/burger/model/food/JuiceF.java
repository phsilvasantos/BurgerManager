package burger.model.food;

import burger.model.supply.CupHolder;
import burger.model.supply.JuiceS;

public class JuiceF extends Food {
   private JuiceS[] ingredient = {JuiceS.me};
   public static final JuiceF me = new JuiceF();

   private JuiceF() {}

   @Override
   public JuiceS[] getIngredients() {
      return ingredient;
   }

   @Override
   public CupHolder getPackage() {
      return CupHolder.me;
   }

   @Override
   public String toString() {
      return "suco";
   }
}