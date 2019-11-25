package burger.model.food;

import burger.model.supply.CupHolder;
import burger.model.supply.JuiceS;

public class JuiceP extends Food {
   private static JuiceS[] ingredient = new JuiceS[] {new JuiceS()};
   private static CupHolder pack = new CupHolder();

   @Override
   public JuiceS[] getIngredients() {
      return ingredient;
   }

   @Override
   public CupHolder getPackage() {
      return pack;
   }

   @Override
   public String toString() {
      return "suco";
   }
}