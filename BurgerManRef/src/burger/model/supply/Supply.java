package burger.model.supply;

import burger.exception.ValueException;

public abstract class Supply {
   private double price;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw new ValueException();
      this.price = price;
   }
}