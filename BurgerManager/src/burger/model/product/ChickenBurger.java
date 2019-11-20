package burger.model.product;

import burger.model.supply.Box;
import burger.model.supply.Bread;
import burger.model.supply.Chicken;
import burger.model.supply.Lettuce;
import burger.model.supply.Supply;
import burger.model.supply.Tomato;

public class ChickenBurger implements Product {
   private static final Supply[] ingredients = new Supply[] {
      new Bread(), new Chicken(), new Lettuce(), new Tomato()
   };

   private static final Box pack = new Box();

   public Supply[] getIngredients() {
      return ingredients;
   }

   public Box getPackage() {
      return pack;
   }

   @Override
   public String toString() {
      return "Hamburger de frango";
   }
}