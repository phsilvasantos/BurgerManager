package burger.model.product;

import burger.model.supply.Beef;
import burger.model.supply.Box;
import burger.model.supply.Bread;
import burger.model.supply.Lettuce;
import burger.model.supply.Supply;
import burger.model.supply.Tomato;

public class BeefBurger implements Product {
   private static final Supply[] ingredients = new Supply[] {
      new Bread(), new Beef(), new Lettuce(), new Tomato()
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
      return "hamburger de carne";
   }
}