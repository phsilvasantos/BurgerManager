package burger.factory;

import burger.model.employee.Employee;

public interface Factory {
   public Employee create();
   public String getType();
}