package burger.model.product;

import burger.exception.ValueException;
import burger.model.MapKey;
import burger.model.supply.CupHolder;
import burger.model.supply.Supply;

public class Juice extends MapKey implements Product, Supply {
   private static final Juice[] ingredient = new Juice[] {new Juice()};
   private static final CupHolder pack = new CupHolder();
   private static double price;

   public Juice[] getIngredients() {
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
         throw new ValueException();
      Juice.price = price;
   }

   @Override
   public String toString() {
      return "suco";
   }
}