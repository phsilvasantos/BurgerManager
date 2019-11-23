package burger.model.supply;

import burger.model.MapKey;

public class Bread extends MapKey implements Supply {
   private static double price;

   @Override
   public double getPrice() {
      return price;
   }

   @Override
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