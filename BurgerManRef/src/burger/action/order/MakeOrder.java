package burger.action.order;

import burger.action.Action;
import burger.model.employee.Cook;
import burger.model.employee.Employee;

public class MakeOrder implements Action {
   public static final MakeOrder me = new MakeOrder();

   private MakeOrder() {}

   @Override
   public void execute(Employee agent) throws Exception {
      OrderHandler.makeOrder((Cook) agent);
   }

   @Override
   public String toString() {
      return "preparar pedido";
   }
}