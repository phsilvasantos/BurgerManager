package burger.model.supply;

import burger.exception.ValueException;
import burger.model.MapKey;

public class Bread extends MapKey implements Supply {
   private static double price;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw new ValueException();
      Bread.price = price;
   }

   @Override
   public String toString() {
      return "pão";
   }
}