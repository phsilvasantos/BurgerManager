package burger.model.employee;

import burger.action.DeliverOrder;

public class Deliverer extends Employee {
   private static final DeliverOrder action = new DeliverOrder();

   public Deliverer(String login) {
      super(login);
   }

   public void signIn() {
      signIn(action);
   }
}