package burger.model.employee;

import burger.action.Action;
import burger.action.AddEmployee;
import burger.action.PayEmployees;
import burger.action.UpdatePrices;

public class Manager extends Employee {
   private static Action[] actions = new Action[] {
      new AddEmployee(), new PayEmployees(), new UpdatePrices()
   };

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