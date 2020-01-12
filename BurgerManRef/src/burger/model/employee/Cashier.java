package burger.model.employee;

import burger.action.order.TakeOrder;
import burger.action.profile.EditProfile;

public class Cashier extends Employee {
   public static final String type = "atendente";

   public Cashier(String login) {
      super(login);
   }

   @Override
   protected String getType() {
      return type;
   }

   @Override
   public void signIn() {
      signIn(TakeOrder.me, EditProfile.me);
   }
}