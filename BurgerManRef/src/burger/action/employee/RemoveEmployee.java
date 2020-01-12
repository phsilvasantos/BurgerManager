package burger.action.employee;

import burger.action.Action;
import burger.model.employee.Employee;
import burger.model.employee.Manager;

public class RemoveEmployee implements Action {
   public static final RemoveEmployee me = new RemoveEmployee();

   private RemoveEmployee() {}

   @Override
   public void execute(Employee agent) throws Exception {
      EmployeeHandler.removeEmployee((Manager) agent);
   }

   @Override
   public String toString() {
      return "remover funcionário";
   }
}