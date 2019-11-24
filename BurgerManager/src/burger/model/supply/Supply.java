package burger.model.supply;

public abstract class Supply {
   @Override
   public boolean equals(Object other) {
      if (other == null || getClass() != other.getClass())
         return false;
      return toString().equals(other.toString());
   }

   public abstract double getPrice();

   @Override
   public int hashCode() {
      return toString().hashCode();
   }

   public abstract void setPrice(double price) throws Exception;
}