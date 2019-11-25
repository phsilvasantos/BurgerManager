package burger.model;

public abstract class Product {
   @Override
   public boolean equals(Object other) {
      if (other == null || getClass() != other.getClass())
         return false;
      return toString().equals(other.toString());
   }

   @Override
   public int hashCode() {
      return toString().hashCode();
   }
}