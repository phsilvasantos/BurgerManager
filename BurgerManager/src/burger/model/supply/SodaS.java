package burger.model.supply;

import burger.exception.ValueException;

public class SodaS extends Supply {
   private static double price;

   @Override
   public double getPrice() {
      return price;
   }

   @Override
   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw new ValueException();
      SodaS.price = price;
   }

   @Override
   public String toString() {
      return "refrigerante";
   }
}