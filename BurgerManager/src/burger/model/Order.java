package burger.model;

import burger.model.employee.Employee;
import burger.model.food.Food;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
   public final Client client;
   private ArrayList<Employee> employees;
   public final int id;
   private static int nOrder;
   private HashMap<Food, Integer> foods;

   public Order(Client client) {
      this.client = client;
      employees = new ArrayList<>();
      id = nOrder++;
      foods = new HashMap<>();
   }

   public boolean addEmployee(Employee employee) {
      return employees.add(employee);
   }

   public int addFood(Food food) {
      Integer value = foods.get(food);
      int nFood = value == null ? 0 : value;
      foods.put(food, nFood + 1);

      return nFood;
   }

   public Employee[] getEmployees() {
      Employee[] employees = new Employee[this.employees.size()];
      int e = 0;
      for (Employee employee : this.employees)
         employees[e++] = employee;

      return employees;
   }

   public HashMap<Food, Integer> getFoods() {
      return new HashMap<>(foods);
   }

   @Override
   public String toString() {
      String o = "id: " + id;

      o += "\nItens:";
      for (Food food : foods.keySet()) {
         int nFood = foods.get(food);
         o += "\n  " + food + ": " + nFood;
      }

      o += "\nCliente:\n" + client;

      return o;
   }
}