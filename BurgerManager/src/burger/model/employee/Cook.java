package burger.model.employee;

import burger.action.MakeOrder;

public class Cook extends Employee {
   private static final MakeOrder action = new MakeOrder();

   public Cook(String login) {
      super(login);
   }

   public void signIn() {
      signIn(action);
   }
}