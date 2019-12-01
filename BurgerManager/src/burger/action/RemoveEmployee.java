package burger.action;

import burger.BurgerMan;
import burger.model.employee.Employee;

public class RemoveEmployee implements Action {
   @Override
   public void execute(Employee executor) throws Exception {
      System.out.print("\nLogin do funcionário: ");
      String login = BurgerMan.input.nextLine();
      if (login.equals(executor.login))
         throw new Exception("Login inválido.");

      Employee employee = BurgerMan.removeEmployee(login);
      System.out.println("Funcionário " + employee.getName() + " removido.");
   }

   @Override
   public String toString() {
      return "remover funcionário";
   }
}