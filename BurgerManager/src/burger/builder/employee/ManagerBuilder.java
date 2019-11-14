package burger.builder.employee;

import burger.model.employee.Manager;

public class ManagerBuilder extends EmployeeBuilder {
   public Manager build() throws Exception {
      Manager manager = new Manager("gerente");
      setInfo(manager);
      put(manager);

      return manager;
   }

   public String getType() {
      return "gerente";
   }
}