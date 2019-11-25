package burger.model.employee;

import burger.action.AcquireSupplies;
import burger.model.ValueException;

public class Supplier extends Employee {
   private static AcquireSupplies action = new AcquireSupplies();
   private static int nSupplier;
   private static double salary;

   public Supplier() {
      super();
   }

   public Supplier(String login) {
      super(login);
   }

   @Override
   public Supplier build() {
      return new Supplier(toString() + (nSupplier++));
   }

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) throws Exception {
      if (salary < 0)
         throw new ValueException();
      Supplier.salary = salary;
   }

   @Override
   public void signIn() {
      signIn(action);
   }

   @Override
   public String toString() {
      return "fornecedor";
   }
}