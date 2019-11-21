package burger.model.supply;

public class Tomato extends Supply {
   private static double price;

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) throws Exception {
      if (price < 0)
         throw valueException;
      Tomato.price = price;
   }

   @Override
   public String toString() {
      return "tomate";
   }
}