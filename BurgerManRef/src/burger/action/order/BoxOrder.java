package burger.action.order;

import burger.action.Action;
import burger.model.employee.Boxer;
import burger.model.employee.Employee;

public class BoxOrder implements Action {
   public static final BoxOrder me = new BoxOrder();

   private BoxOrder() {}

   @Override
   public void execute(Employee agent) throws Exception {
      OrderHandler.boxOrder((Boxer) agent);
   }

   @Override
   public String toString() {
      return "embalar pedido";
   }
}