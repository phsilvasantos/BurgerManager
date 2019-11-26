package burger.model.supply;

import burger.exception.ValueException;

public class Bread extends Supply {
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