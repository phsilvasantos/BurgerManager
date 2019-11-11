package burger.model.employee;

import burger.BurgerMan;
import burger.action.Action;
import burger.action.AddEmployee;

public class Manager extends Employee {
   public Manager(String login) {
      super(login);
   }

   public void signIn() throws Exception {
      Action[] actions = new Action[] {new AddEmployee()};

      while (true) {
         System.out.println("---\n0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.println(a + " - " + actions[a - 1]);
         System.out.print("---\nAção: ");
         a = Integer.parseInt(BurgerMan.input.nextLine());
         if (a == 0)
            break;

         actions[a - 1].execute();
      }
   }
}