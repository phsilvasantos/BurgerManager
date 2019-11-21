package burger.model.supply;

public class CupHolder extends Supply {
   private static double price;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw valueException;
      CupHolder.price = price;
   }

   @Override
   public String toString() {
      return "porta-copo";
   }
}