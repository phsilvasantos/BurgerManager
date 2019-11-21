package burger.model.supply;

public class Cheese extends Supply {
   private static double price;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw valueException;
      Cheese.price = price;
   }

   @Override
   public String toString() {
      return "queijo";
   }
}