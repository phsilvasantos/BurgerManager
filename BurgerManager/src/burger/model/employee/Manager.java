package burger.model.employee;

import burger.action.Action;
import burger.action.AddEmployee;
import burger.action.EditProfile;
import burger.action.GenerateReport;
import burger.action.PayEmployees;
import burger.action.RemoveEmployee;
import burger.action.UpdatePrices;
import burger.action.ValidateProfile;

public class Manager extends Employee {
   private static Action[] actions = new Action[] {
      new AddEmployee(), new RemoveEmployee(), new PayEmployees(), new UpdatePrices(),
      new GenerateReport(), new EditProfile(), new ValidateProfile()
   };

   public Manager() {
      super();
   }

   public Manager(String login) {
      super(login);
   }

   @Override
   public Manager build() {
      return new Manager(getType());
   }

   @Override
   public String getType() {
      return "gerente";
   }

   @Override
   public void signIn() {
      signIn(actions);
   }
}