package burger.builder.employee;

import burger.model.employee.Cashier;

public class CashierBuilder extends EmployeeBuilder {
   private static int nCashier;

   public Cashier build() throws Exception {
      Cashier cashier = new Cashier("atendente" + (nCashier++));
      setInfo(cashier);
      put(cashier);

      return cashier;
   }

   public String getType() {
      return "atendente";
   }
}