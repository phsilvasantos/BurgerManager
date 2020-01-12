package burger.factory;

import burger.model.employee.Supplier;

public class SupplierFactory implements Factory {
   public static final SupplierFactory me = new SupplierFactory();
   private int nSupplier;

   private SupplierFactory() {}

   @Override
   public Supplier create() {
      return new Supplier(getType() + "_" + nSupplier++);
   }

   @Override
   public String getType() {
      return Supplier.type;
   }
}