package burger.action.employee;

import burger.BurgerMan;
import burger.exception.NotFoundException;
import burger.factory.BoxerFactory;
import burger.factory.Factory;
import burger.factory.CashierFactory;
import burger.factory.CookFactory;
import burger.factory.DelivererFactory;
import burger.factory.SupplierFactory;
import burger.model.employee.Employee;
import burger.model.employee.Manager;

import java.util.HashMap;

public class EmployeeHandler {
   private static HashMap<String, Employee> employees = new HashMap<>();

   static void addEmployee() throws Exception {
      Factory[] factories = {
         CashierFactory.me, CookFactory.me, BoxerFactory.me, DelivererFactory.me, SupplierFactory.me
      };

      System.out.println();
      int f;

      for (f = 0; f < factories.length; f++)
         System.out.println(f + " - " + factories[f].getType());

      System.out.print("\nFunção: ");
      f = Integer.parseInt(BurgerMan.input.nextLine());
      Employee employee = factories[f].create();
      setInfo(employee);
      put(employee);
      System.out.println("\nFuncionário " + employee.getName() + " adicionado.");
   }

   public static void addManager() throws Exception {
      setInfo(Manager.me);
      put(Manager.me);
      System.out.println("\nGerente " + Manager.me.getName() + " adicionado.");
   }

   public static Employee get(String login) throws Exception {
      Employee employee = employees.get(login);

      if (employee == null)
         throw new NotFoundException();

      return employee;
   }

   private static Employee put(Employee employee) {
      return employees.put(employee.login, employee);
   }

   static void removeEmployee(Manager agent) throws Exception {
      System.out.print("\nLogin do funcionário: ");
      String login = BurgerMan.input.nextLine();

      if (login.equals(agent.login))
         throw new Exception("Login inválido.");

      Employee employee = employees.remove(login);
      System.out.println("Funcionário " + employee.getName() + " removido.");
   }

   private static void setInfo(Employee employee) throws Exception {
      System.out.println("\nLogin: " + employee.login);
      System.out.print("Nome: ");
      employee.setName(BurgerMan.input.nextLine());
      System.out.print("CPF: ");
      employee.setCPF(BurgerMan.input.nextLine());
      System.out.print("E-mail: ");
      employee.setEmail(BurgerMan.input.nextLine());
   }

   public static void viewEmployees() {
      System.out.println("Funcionários:");

      for (Employee employee : employees.values())
         System.out.println("\n" + employee);
   }
}