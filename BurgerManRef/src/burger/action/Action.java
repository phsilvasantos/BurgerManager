package burger.action;

import burger.model.employee.Employee;

public interface Action {
   public void execute(Employee agent) throws Exception;
}