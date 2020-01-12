package burger.model.employee;

import burger.action.order.DeliverOrder;
import burger.action.profile.EditProfile;

public class Deliverer extends Employee {
   public static final String type = "entregador";

   public Deliverer(String login) {
      super(login);
   }

   @Override
   protected String getType() {
      return type;
   }

   @Override
   public void signIn() {
      signIn(DeliverOrder.me, EditProfile.me);
   }
}