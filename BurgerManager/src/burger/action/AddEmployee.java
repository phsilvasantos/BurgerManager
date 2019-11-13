package burger.action;

import burger.BurgerMan;
import burger.builder.employee.CasherBuilder;
import burger.builder.employee.EmployeeBuilder;
import burger.model.employee.Employee;

public class AddEmployee implements Action {
   private EmployeeBuilder[] builders;

   public AddEmployee() {
      builders = new EmployeeBuilder[] {new CasherBuilder()};
   }

   public void execute() throws Exception {
      System.out.println("---");
      int e;
      for (e = 0; e < builders.length; e++)
         System.out.println(e + " - " + builders[e].getType());
      System.out.print("---\nCargo: ");
      e = Integer.parseInt(BurgerMan.input.nextLine());

      Employee employee = builders[e].build();

      System.out.println("Funcionário '" + employee.login + ": " +
            employee.getName() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}