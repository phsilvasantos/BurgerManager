package burger.builder.employee;

import burger.model.employee.Deliverer;

public class DelivererBuilder extends EmployeeBuilder {
   private static int nDeliver;

   public Deliverer build() throws Exception {
      Deliverer deliverer = new Deliverer("entregador" + (nDeliver++));
      setInfo(deliverer);
      put(deliverer);

      return deliverer;
   }

   public String getType() {
      return "entregador";
   }
}