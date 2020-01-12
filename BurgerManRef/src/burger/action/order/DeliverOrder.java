package burger.action.order;

import burger.action.Action;
import burger.model.employee.Employee;
import burger.model.employee.Deliverer;

public class DeliverOrder implements Action {
   public static final DeliverOrder me = new DeliverOrder();

   private DeliverOrder() {}

   @Override
   public void execute(Employee agent) throws Exception {
      OrderHandler.deliverOrder((Deliverer) agent);
   }

   @Override
   public String toString() {
      return "entregar pedido";
   }
}
