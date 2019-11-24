package burger.model;

import burger.model.employee.Employee;
import burger.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
   public final Client client;
   private ArrayList<Employee> employees;
   public final int id;
   private static int nOrder;
   private HashMap<Product, Integer> products;

   public Order(Client client) {
      this.client = client;
      employees = new ArrayList<>();
      id = nOrder++;
      products = new HashMap<>();
   }

   public boolean addEmployee(Employee employee) {
      return employees.add(employee);
   }

   public int addProduct(Product product) {
      Integer value = products.get(product);
      int nProduct = value == null ? 0 : value;
      products.put(product, nProduct + 1);

      return nProduct;
   }

   public Employee[] getEmployees() {
      Employee[] employees = new Employee[this.employees.size()];
      int e = 0;
      for (Employee employee : this.employees)
         employees[e++] = employee;

      return employees;
   }

   public HashMap<Product, Integer> getProducts() {
      return new HashMap<>(products);
   }
}