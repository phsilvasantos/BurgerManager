package burger;

import burger.action.AddEmployee;
import burger.model.employee.Employee;
import burger.model.employee.Manager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class BurgerMan {
   private static HashMap<String, Employee> employees = new HashMap<>();
   public static final Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      Manager manager = new Manager().build();

      System.out.println("Dados do gerente:");
      try {
         AddEmployee.setInfo(manager);
         putEmployee(manager);

         System.out.println("\nGerente '" + manager.getName() + "' adicionado.");

         while (true) {
            System.out.print("\nLogin ('-' para encerrar): ");
            String login = input.nextLine();
            if (login.isEmpty() || login.equals("-"))
               break;

            try {
               Employee employee = getEmployee(login);
               employee.signIn();
            } catch (Exception ex) {
               System.out.println("<!> " + ex.getMessage());
            }
         }
      } catch (Exception ex) {
         System.out.println("<!> " + ex.getMessage());
      }
   }

   private static Employee getEmployee(String key) throws Exception {
      Employee employee = employees.get(key);
      if (employee == null)
         throw new Exception("Funcionário não encontrado.");
      return employee;
   }

   public static Employee[] getEmployees() {
      Collection<Employee> values = BurgerMan.employees.values();
      Employee[] employees = new Employee[values.size()];
      int e = 0;
      for (Employee employee : values)
         employees[e++] = employee;

      return employees;
   }

   public static Employee putEmployee(Employee employee) {
      return employees.put(employee.login, employee);
   }
}