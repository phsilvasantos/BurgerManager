package burger.model.product;

import burger.model.supply.CupHolder;
import burger.model.supply.Supply;

public class Soda extends Supply implements Product {
   private static final Soda[] ingredient = new Soda[] {new Soda()};
   private static final CupHolder pack = new CupHolder();
   private static double price;

   public Soda[] getIngredients() {
      return ingredient;
   }

   public CupHolder getPackage() {
      return pack;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw valueException;
      Soda.price = price;
   }

   @Override
   public String toString() {
      return "Refrigerante";
   }
}