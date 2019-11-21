package burger.model.employee;

import burger.action.DeliverOrder;

public class Deliverer extends Employee {
   private static final DeliverOrder action = new DeliverOrder();
   private static int nDeliverer;

   public Deliverer() {
      super();
   }

   public Deliverer(String login) {
      super(login);
   }

   public Deliverer build() {
      return new Deliverer(toString() + (nDeliverer++));
   }

   public void signIn() {
      signIn(action);
   }

   @Override
   public String toString() {
      return "entregador";
   }
}