package burger.builder.employee;

import burger.model.employee.Manager;

public class ManagerBuilder extends EmployeeBuilder {
   public Manager build() {
      Manager manager = new Manager("gerente");

      manager.name = "Gerente";
      manager.cpf = "123.456.789-01";
      manager.email = "gerente@burgerman.com";

      put(manager);

      return manager;
   }
}