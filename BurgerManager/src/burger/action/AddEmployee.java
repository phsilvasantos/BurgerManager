package burger.action;

import burger.BurgerMan;
import burger.model.employee.Boxer;
import burger.model.employee.Cashier;
import burger.model.employee.Cook;
import burger.model.employee.Deliverer;
import burger.model.employee.Employee;
import burger.model.employee.Supplier;

public class AddEmployee implements Action {
   private Employee[] builders;

   public AddEmployee() {
      builders = new Employee[] {
         new Cashier(), new Cook(), new Boxer(), new Deliverer(), new Supplier()
      };
   }

   @Override
   public void execute(Employee executor) throws Exception {
      System.out.println();
      int e;
      for (e = 0; e < builders.length; e++)
         System.out.println(e + " - " + builders[e]);
      System.out.print("\nFunção: ");
      e = Integer.parseInt(BurgerMan.input.nextLine());

      Employee employee = builders[e].build();
      setInfo(employee);
      BurgerMan.putEmployee(employee);

      System.out.println("\nFuncionário " + employee.getName() + " adicionado.");
   }

   public static void setInfo(Employee employee) throws Exception {
      System.out.println("\nLogin: " + employee.login);

      System.out.print("Nome: ");
      employee.setName(BurgerMan.input.nextLine());

      System.out.print("CPF: ");
      employee.setCPF(BurgerMan.input.nextLine());

      System.out.print("E-mail: ");
      employee.setEmail(BurgerMan.input.nextLine());
   }

   @Override
   public String toString() {
      return "adicionar funcionário";
   }
}