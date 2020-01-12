package burger.action.payment;

import burger.action.Action;
import burger.model.employee.Employee;

public class UpdatePrices implements Action {
   public static final UpdatePrices me = new UpdatePrices();

   private UpdatePrices() {}

   @Override
   public void execute(Employee agent) throws Exception {
      PaymentHandler.updatePrices();
   }

   @Override
   public String toString() {
      return "atualizar preços";
   }
}