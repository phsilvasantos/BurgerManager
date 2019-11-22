package burger.model.supply;

import burger.exception.ValueException;
import burger.model.MapKey;

public class Box extends MapKey implements Supply {
   private static double price;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw new ValueException();
      Box.price = price;
   }

   @Override
   public String toString() {
      return "caixa";
   }
}