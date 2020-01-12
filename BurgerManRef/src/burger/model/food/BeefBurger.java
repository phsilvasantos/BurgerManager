package burger.model.food;

import burger.model.supply.Beef;
import burger.model.supply.Box;
import burger.model.supply.Bread;
import burger.model.supply.Lettuce;
import burger.model.supply.Supply;
import burger.model.supply.Tomato;

public class BeefBurger extends Food {
   private Supply[] ingredients = {Bread.me, Beef.me, Lettuce.me, Tomato.me};
   public static final BeefBurger me = new BeefBurger();

   private BeefBurger() {}

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
      return "hamburger de carne";
   }
}