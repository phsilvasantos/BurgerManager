package burger.builder.employee;

import burger.builder.Builder;
import burger.model.employee.Employee;

import java.util.HashMap;

public abstract class EmployeeBuilder implements Builder<Employee> {
   private static final HashMap<String, Employee> employees = new HashMap<>();

   public static Employee get(String key) {
      return employees.get(key);
   }

   protected static Employee put(Employee employee) {
      String key = employee.getLogin();
      if (employees.containsKey(key))
         return null;

      return employees.put(key, employee);
   }

   public static Employee remove(String key) {
      return employees.remove(key);
   }
}