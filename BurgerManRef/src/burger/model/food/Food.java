package burger.model.food;

import burger.model.supply.Supply;

public abstract class Food {
   public abstract Supply[] getIngredients();
   public abstract Supply getPackage();

   public double getPrice() {
      double price = getPackage().getPrice();
      for (Supply ingredient : getIngredients())
         price += ingredient.getPrice();

      return price;
   }
}