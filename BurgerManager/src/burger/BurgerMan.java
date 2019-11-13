package burger;

import burger.builder.employee.EmployeeBuilder;
import burger.builder.employee.ManagerBuilder;
import burger.model.employee.Employee;
import burger.model.employee.Manager;

import java.util.Scanner;

public class BurgerMan {
   public static final Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      System.out.println("Dados do gerente:");
      try {
         Manager manager = (new ManagerBuilder()).build();
         System.out.println("Gerente '" + manager.login + ": " +
               manager.getName() + "' adicionado.");

         while (true) {
            System.out.print("\nLogin ('-' para encerrar): ");
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
      } catch (Exception ex) {
         System.out.println("<!> " + ex.getMessage());
      }
   }
}