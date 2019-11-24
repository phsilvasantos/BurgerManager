package burger.model.employee;

import burger.action.Action;
import burger.action.AddEmployee;
import burger.action.PayEmployees;

public class Manager extends Employee {
   private static final Action[] actions = new Action[] {new AddEmployee(), new PayEmployees()};

   public Manager() {
      super();
   }

   public Manager(String login) {
      super(login);
   }

   @Override
   public Manager build() {
      return new Manager(toString());
   }

   @Override
   public void signIn() {
      signIn(actions);
   }

   @Override
   public String toString() {
      return "gerente";
   }
}