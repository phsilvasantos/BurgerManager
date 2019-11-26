package burger.action;

import burger.BurgerMan;
import burger.model.employee.Employee;

public class RemoveEmployee implements Action {
   @Override
   public void execute(Employee executor) throws Exception {
      System.out.print("\nLogin do funcionário: ");
      Employee employee = BurgerMan.removeEmployee(BurgerMan.input.nextLine());
      System.out.println("Funcionário " + employee.getName() + " removido.");
   }

   @Override
   public String toString() {
      return "remover funcionário";
   }
}