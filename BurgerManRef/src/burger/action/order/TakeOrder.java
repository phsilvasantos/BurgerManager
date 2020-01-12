package burger.action.order;

import burger.action.Action;
import burger.model.employee.Cashier;
import burger.model.employee.Employee;

public class TakeOrder implements Action {
   public static final TakeOrder me = new TakeOrder();

   private TakeOrder() {}

   @Override
   public void execute(Employee agent) throws Exception {
      OrderHandler.takeOrder((Cashier) agent);
   }

   @Override
   public String toString() {
      return "anotar pedido";
   }
}