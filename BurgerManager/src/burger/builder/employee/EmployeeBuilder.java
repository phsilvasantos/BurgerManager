package burger.builder.employee;

import burger.BurgerMan;
import burger.builder.Builder;
import burger.model.employee.Employee;

import java.util.HashMap;

public abstract class EmployeeBuilder implements Builder<Employee> {
   private static final HashMap<String, Employee> employees = new HashMap<>();
   protected static final Exception existentException = new Exception("Funcionário já existente.");

   public static boolean contains(String key) {
      return employees.containsKey(key);
   }

   public static Employee get(String key) {
      return employees.get(key);
   }

   protected Employee put(Employee employee) {
      return employees.put(employee.login, employee);
   }

   protected Employee remove(String key) {
      return employees.remove(key);
   }

   protected void setInfo(Employee employee) throws Exception {
      System.out.print("Nome: ");
      employee.setName(BurgerMan.input.nextLine());

      System.out.print("CPF: ");
      employee.setCPF(BurgerMan.input.nextLine());

      System.out.print("E-mail: ");
      employee.setEmail(BurgerMan.input.nextLine());
   }
}