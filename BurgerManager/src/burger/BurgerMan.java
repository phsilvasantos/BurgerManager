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
         System.out.println("Login: " + manager.login + "\nGerente adicionado.");

         while (true) {
            System.out.print("\nLogin ('-' para encerrar): ");
            String login = input.nextLine();
            if (login.isEmpty() || login.equals("-"))
               break;

            try {
               Employee employee = EmployeeBuilder.get(login);
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