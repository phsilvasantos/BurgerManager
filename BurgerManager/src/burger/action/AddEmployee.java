package burger.action;

import burger.BurgerMan;
import burger.builder.employee.CashierBuilder;
import burger.builder.employee.CookBuilder;
import burger.builder.employee.EmployeeBuilder;
import burger.model.employee.Employee;

public class AddEmployee implements Action {
   private EmployeeBuilder[] builders;

   public AddEmployee() {
      builders = new EmployeeBuilder[] {new CashierBuilder(), new CookBuilder()};
   }

   public void execute() throws Exception {
      System.out.println();
      int e;
      for (e = 0; e < builders.length; e++)
         System.out.println(e + " - " + builders[e].getType());
      System.out.print("\nCargo: ");
      e = Integer.parseInt(BurgerMan.input.nextLine());

      Employee employee = builders[e].build();

      System.out.println("Login: " + employee.login + "\nFuncionário adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}