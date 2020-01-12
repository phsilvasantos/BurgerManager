package burger.action.employee;

import burger.action.Action;
import burger.model.employee.Employee;

public class AddEmployee implements Action {
   public static final AddEmployee me = new AddEmployee();

   private AddEmployee() {}

   @Override
   public void execute(Employee agent) throws Exception {
      EmployeeHandler.addEmployee();
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}