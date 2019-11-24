package burger.model.supply;

public class Lettuce extends Supply {
   private static double price;

   @Override
   public double getPrice() {
      return price;
   }

   @Override
   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw new ValueException();
      Lettuce.price = price;
   }

   @Override
   public String toString() {
      return "alface";
   }
}