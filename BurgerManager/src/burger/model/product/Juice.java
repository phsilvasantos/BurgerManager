package burger.model.product;

import burger.model.ValueException;
import burger.model.supply.CupHolder;

public class Juice extends Product {
   private static CupHolder pack = new CupHolder();
   private static double price;

   @Override
   public Juice[] getIngredients() {
      return new Juice[] {this};
   }

   @Override
   public CupHolder getPackage() {
      return pack;
   }

   @Override
   public double getPrice() {
      return price + pack.getPrice();
   }

   @Override
   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw new ValueException();
      Juice.price = price;
   }

   @Override
   public String toString() {
      return "suco";
   }
}