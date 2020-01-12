package burger.model.employee;

import burger.action.order.AcquireSupplies;
import burger.action.profile.EditProfile;
import burger.exception.ValueException;

public class Supplier extends Employee {
   private static double salary;
   public static final String type = "fornecedor";

   public Supplier(String login) {
      super(login);
   }

   public static double getSalary() {
      return salary;
   }

   @Override
   protected String getType() {
      return type;
   }

   public static void setSalary(double salary) throws Exception {
      if (salary < 0)
         throw new ValueException();
      Supplier.salary = salary;
   }

   @Override
   public void signIn() {
      signIn(AcquireSupplies.me, EditProfile.me);
   }
}