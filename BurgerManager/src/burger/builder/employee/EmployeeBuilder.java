package burger.builder.employee;

import burger.BurgerMan;
import burger.builder.Builder;
import burger.model.employee.Employee;

import java.util.HashMap;

public abstract class EmployeeBuilder implements Builder<Employee> {
   private static final HashMap<String, Employee> employees = new HashMap<>();
   private static final Exception notFoundException = new Exception("Funcionário não encontrado.");

   public static Employee get(String key) throws Exception {
      if (!employees.containsKey(key))
         throw notFoundException;
      return employees.get(key);
   }

   protected Employee put(Employee employee) {
      return employees.put(employee.login, employee);
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