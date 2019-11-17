package burger.model.supply;

public class Lettuce extends Supply {
   private static double price;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw valueException;
      Lettuce.price = price;
   }
}