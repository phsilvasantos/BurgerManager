package burger.builder.employee;

import burger.BurgerMan;
import burger.model.employee.Manager;

public class ManagerBuilder extends EmployeeBuilder {
   public Manager build() throws Exception {
      System.out.print("Login: ");
      Manager manager = new Manager(BurgerMan.input.nextLine());
      setInfo(manager);
      put(manager);

      return manager;
   }

   public String getType() {
      return "gerente";
   }
}