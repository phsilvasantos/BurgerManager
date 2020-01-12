package burger.model.employee;

import burger.action.employee.AddEmployee;
import burger.action.employee.RemoveEmployee;
import burger.action.payment.PayEmployees;
import burger.action.payment.UpdatePrices;
import burger.action.profile.EditProfile;
import burger.action.profile.ValidateProfile;
import burger.action.GenerateReport;

public class Manager extends Employee {
   public static final Manager me = new Manager();
   public final String type;

   private Manager() {
      super("gerente");
      type = "gerente";
   }

   @Override
   protected String getType() {
      return type;
   }

   @Override
   public void signIn() {
      signIn(
         AddEmployee.me, RemoveEmployee.me, PayEmployees.me, UpdatePrices.me,
         GenerateReport.me, EditProfile.me, ValidateProfile.me
      );
   }
}