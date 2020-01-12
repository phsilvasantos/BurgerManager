package burger.model.food;

import burger.model.supply.CupHolder;
import burger.model.supply.SodaS;

public class SodaF extends Food {
   private SodaS[] ingredient = {SodaS.me};
   public static final SodaF me = new SodaF();

   private SodaF() {}

   @Override
   public SodaS[] getIngredients() {
      return ingredient;
   }

   @Override
   public CupHolder getPackage() {
      return CupHolder.me;
   }

   @Override
   public String toString() {
      return "refrigerante";
   }
}