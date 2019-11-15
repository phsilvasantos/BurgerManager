package burger.action;

import burger.BurgerMan;
import burger.builder.employee.BoxerBuilder;
import burger.builder.employee.CashierBuilder;
import burger.builder.employee.CookBuilder;
import burger.builder.employee.DelivererBuilder;
import burger.builder.employee.EmployeeBuilder;
import burger.builder.employee.SupplierBuilder;
import burger.model.employee.Employee;

public class AddEmployee implements Action {
   private EmployeeBuilder[] builders;

   public AddEmployee() {
      builders = new EmployeeBuilder[] {
         new CashierBuilder(), new CookBuilder(), new BoxerBuilder(),
         new DelivererBuilder(), new SupplierBuilder()
      };
   }

   public void execute() throws Exception {
      System.out.println();
      int e;
      for (e = 0; e < builders.length; e++)
         System.out.println(e + " - " + builders[e].getType());
      System.out.print("\nFunção: ");
      e = Integer.parseInt(BurgerMan.input.nextLine());

      Employee employee = builders[e].build();
      System.out.println("\nFuncionário '" + employee.getName() + "' adicionado.");
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}