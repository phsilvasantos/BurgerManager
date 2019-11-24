package burger.model;

public class Client extends Person {
   private String address;

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      if (address.isEmpty())
         address = "-";
      this.address = address;
   }
}