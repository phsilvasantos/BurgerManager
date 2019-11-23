package burger.model.employee;

import burger.action.AcquireSupplies;

public class Supplier extends Employee {
   private static final AcquireSupplies action = new AcquireSupplies();
   private static int nSupplier;

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

   @Override
   public void signIn() {
      signIn(action);
   }

   @Override
   public String toString() {
      return "fornecedor";
   }
}