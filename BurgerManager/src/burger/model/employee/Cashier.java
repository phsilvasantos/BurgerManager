package burger.model.employee;

import burger.action.TakeOrder;

public class Cashier extends Employee {
   private static final TakeOrder action = new TakeOrder();

   public Cashier(String login) {
      super(login);
   }

   public void signIn() {
      super.signIn(action);
   }
}