package burger.model.product;

import burger.model.MapKey;
import burger.model.supply.CupHolder;
import burger.model.supply.Supply;
import burger.model.supply.ValueException;

public class Juice extends MapKey implements Product, Supply {
   private static final Juice[] ingredient = new Juice[] {new Juice()};
   private static final CupHolder pack = new CupHolder();
   private static double price;

   @Override
   public Juice[] getIngredients() {
      return ingredient;
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
      Juice.price = price;
   }

   @Override
   public String toString() {
      return "suco";
   }
}