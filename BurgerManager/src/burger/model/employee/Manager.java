package burger.model.employee;

import burger.action.Action;
import burger.action.AddEmployee;

public class Manager extends Employee {
   private static final Action[] actions = new Action[] {new AddEmployee()};

   public Manager(String login) {
      super(login);
   }

   public void signIn() {
      signIn(actions);
   }
}