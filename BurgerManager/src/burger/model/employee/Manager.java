package burger.model.employee;

import burger.action.Action;
import burger.action.AddEmployee;

public class Manager extends Employee {
   public Manager(String login) {
      super(login);
      actions = new Action[] {new AddEmployee()};
   }
}