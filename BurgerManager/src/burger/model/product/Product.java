package burger.model.product;

import burger.model.supply.Supply;

public abstract class Product extends Supply {
   public abstract Supply[] getIngredients();
   public abstract Supply getPackage();

   @Override
   public double getPrice() {
      double price = getPackage().getPrice();
      for (Supply ingredient : getIngredients())
         price += ingredient.getPrice();

      return price;
   }

   @Override
   public void setPrice(double price) throws Exception {
      throw new Exception("Somente leitura.");
   }
}