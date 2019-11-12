package burger.action;

import burger.BurgerMan;
import burger.builder.employee.EmployeeBuilder;

public class AddEmployee implements Action {
   private EmployeeBuilder[] builders;

   public AddEmployee() {
      builders = new EmployeeBuilder[] {};
   }

   public void execute() throws Exception {
      System.out.println("---");
      int e;
      for (e = 0; e < builders.length; e++)
         System.out.println(e + " - " + builders[e].getType());
      System.out.print("---\nCargo: ");
      e = Integer.parseInt(BurgerMan.input.nextLine());

      builders[e].build();
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}