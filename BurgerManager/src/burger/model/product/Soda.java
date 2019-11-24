package burger.model.product;

import burger.model.supply.CupHolder;
import burger.model.supply.ValueException;

public class Soda extends Product {
   private static final CupHolder pack = new CupHolder();
   private static double price;

   @Override
   public Soda[] getIngredients() {
      return new Soda[] {this};
   }

   @Override
   public CupHolder getPackage() {
      return pack;
   }

   @Override
   public double getPrice() {
      return price;
   }

   @Override
   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw new ValueException();
      Soda.price = price;
   }

   @Override
   public String toString() {
      return "refrigerante";
   }
}