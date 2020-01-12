package burger.model.food;

import burger.model.supply.Box;
import burger.model.supply.Bread;
import burger.model.supply.Cheese;
import burger.model.supply.Lettuce;
import burger.model.supply.Supply;
import burger.model.supply.Tomato;

public class CheeseBurger extends Food {
   private Supply[] ingredients = {Bread.me, Cheese.me, Lettuce.me, Tomato.me};
   public static final CheeseBurger me = new CheeseBurger();

   private CheeseBurger() {}

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
      return "cheeseburger";
   }
}