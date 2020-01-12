package burger.model.food;

import burger.model.supply.Box;
import burger.model.supply.Bread;
import burger.model.supply.Chicken;
import burger.model.supply.Lettuce;
import burger.model.supply.Supply;
import burger.model.supply.Tomato;

public class ChickenBurger extends Food {
   private Supply[] ingredients = {Bread.me, Chicken.me, Lettuce.me, Tomato.me};
   public static final ChickenBurger me = new ChickenBurger();

   private ChickenBurger() {}

   @Override
   public Supply[] getIngredients() {
      return ingredients;
   }

   @Override
   public Box getPackage() {
      return Box.me;
   }

   @Override
   public String toString() {
      return "hamburger de frango";
   }
}