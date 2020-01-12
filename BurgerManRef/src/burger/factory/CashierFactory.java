package burger.factory;

import burger.model.employee.Cashier;

public class CashierFactory implements Factory {
   public static final CashierFactory me = new CashierFactory();
   private int nCashier;

   private CashierFactory() {}

   @Override
   public Cashier create() {
      return new Cashier(getType() + "_" + nCashier++);
   }

   @Override
   public String getType() {
      return Cashier.type;
   }
}