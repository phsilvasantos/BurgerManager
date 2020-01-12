package burger.factory;

import burger.model.employee.Deliverer;

public class DelivererFactory implements Factory {
   public static final DelivererFactory me = new DelivererFactory();
   private int nDeliverer;

   private DelivererFactory() {}

   @Override
   public Deliverer create() {
      return new Deliverer(getType() + "_" + nDeliverer++);
   }

   @Override
   public String getType() {
      return Deliverer.type;
   }
}