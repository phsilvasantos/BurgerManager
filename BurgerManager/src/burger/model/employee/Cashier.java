package burger.model.employee;

import burger.action.TakeOrder;

public class Cashier extends Employee {
   private static final TakeOrder action = new TakeOrder();
   private static int nCashier;

   public Cashier() {
      super();
   }

   public Cashier(String login) {
      super(login);
   }

   public Cashier build() {
      return new Cashier(toString() + (nCashier++));
   }

   public void signIn() {
      signIn(action);
   }

   @Override
   public String toString() {
      return "caixa";
   }
}