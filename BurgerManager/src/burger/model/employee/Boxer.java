package burger.model.employee;

import burger.action.BoxOrder;

public class Boxer extends Employee {
   private static final BoxOrder action = new BoxOrder();

   public Boxer(String login) {
      super(login);
   }

   public void signIn() {
      signIn(action);
   }
}