package burger.action.payment;

import burger.action.Action;
import burger.model.employee.Employee;

public class PayEmployees implements Action {
   public static final PayEmployees me = new PayEmployees();

   private PayEmployees() {}

   @Override
   public void execute(Employee agent) throws Exception {
      PaymentHandler.payEmployees();
   }

   @Override
   public String toString() {
      return "remunerar funcionários";
   }
}