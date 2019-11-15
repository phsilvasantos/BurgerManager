package burger.model.employee;

import burger.action.AcquireSupplies;

public class Supplier extends Employee {
   private static final AcquireSupplies action = new AcquireSupplies();

   public Supplier(String login) {
      super(login);
   }

   public void signIn() {
      signIn(action);
   }
}