package burger;

import burger.action.employee.EmployeeHandler;
import burger.model.employee.Employee;

import java.util.Scanner;

public class BurgerMan {
   public static final Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      System.out.println("Dados do gerente:");

      try {
         EmployeeHandler.addManager();

         while (true) {
            System.out.print("\nLogin ('-' para encerrar): ");
            String login = input.nextLine();

            if (login.isEmpty() || login.equals("-"))
               break;

            try {
               Employee employee = EmployeeHandler.get(login);
               employee.signIn();
            } catch (Exception ex) {
               System.out.println("<!> " + ex.getMessage());
            }
         }
      } catch (Exception ex) {
         System.out.println("<!> " + ex.getMessage());
      }
   }
}