package burger.model.product;

import burger.model.supply.Box;
import burger.model.supply.Bread;
import burger.model.supply.Cheese;
import burger.model.supply.Lettuce;
import burger.model.supply.Supply;
import burger.model.supply.Tomato;

public class CheeseBurger implements Product {
   private static final Supply[] ingredients = new Supply[] {
      new Bread(), new Cheese(), new Lettuce(), new Tomato()
   };

   private static final Box pack = new Box();

   public CheeseBurger build() {
      return new CheeseBurger();
   }

   public Supply[] getIngredients() {
      return ingredients;
   }

   public Box getPackage() {
      return pack;
   }

   @Override
   public String toString() {
      return "cheeseburger";
   }
}