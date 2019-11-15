package burger.builder.employee;

import burger.model.employee.Supplier;

public class SupplierBuilder extends EmployeeBuilder {
   private static int nSupplier;

   public Supplier build() throws Exception {
      Supplier supplier = new Supplier("fornecedor" + (nSupplier++));
      setInfo(supplier);
      put(supplier);

      return supplier;
   }

   public String getType() {
      return "fornecedor";
   }
}