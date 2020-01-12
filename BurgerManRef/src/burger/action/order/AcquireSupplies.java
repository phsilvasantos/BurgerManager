package burger.action.order;

import burger.action.Action;
import burger.model.employee.Employee;
import burger.model.employee.Supplier;

public class AcquireSupplies implements Action {
   public static final AcquireSupplies me = new AcquireSupplies();

   private AcquireSupplies() {}

   @Override
   public void execute(Employee agent) throws Exception {
      OrderHandler.acquireSupplies((Supplier) agent);
   }

   @Override
   public String toString() {
      return "adquirir suprimentos";
   }
}