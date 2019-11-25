package burger.model.food;

import burger.model.supply.CupHolder;
import burger.model.supply.SodaS;

public class SodaP extends Food {
   private static SodaS[] ingredient = new SodaS[] {new SodaS()};
   private static CupHolder pack = new CupHolder();

   @Override
   public SodaS[] getIngredients() {
      return ingredient;
   }

   @Override
   public CupHolder getPackage() {
      return pack;
   }

   @Override
   public String toString() {
      return "refrigerante";
   }
}