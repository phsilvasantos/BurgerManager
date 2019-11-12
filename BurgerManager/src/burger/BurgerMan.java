package burger;

import burger.builder.employee.EmployeeBuilder;
import burger.builder.employee.ManagerBuilder;
import burger.model.employee.Employee;

import java.util.Scanner;

public class BurgerMan {
   public static final Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      System.out.println("Dados do gerente:");
      try {
         (new ManagerBuilder()).build();
      } catch (Exception ex) {
         System.out.println("<!> " + ex.getMessage());
      }

      while (true) {
         System.out.print("Login ('-' para encerrar): ");
         String login = input.nextLine();
         if (login.isEmpty() || login.equals("-"))
            break;

         Employee employee = EmployeeBuilder.get(login);

         try {
            employee.signIn();
         } catch (NumberFormatException | IndexOutOfBoundsException ex) {
            System.out.println("<!> Entrada inválida.");
         } catch (Exception ex) {
            System.out.println("<!> " + ex.getMessage());
         }
      }
   }
}