package burger.builder.employee;

import burger.BurgerMan;
import burger.model.employee.Casher;

public class CasherBuilder extends EmployeeBuilder {
   public Casher build() throws Exception {
      System.out.print("Login: ");
      String login = BurgerMan.input.nextLine();
      if (contains(login))
         throw existentException;

      Casher casher = new Casher(BurgerMan.input.nextLine());
      setInfo(casher);
      put(casher);

      return casher;
   }

   public String getType() {
      return "atendente";
   }
}