package burger.model.employee;

import burger.action.order.MakeOrder;
import burger.action.profile.EditProfile;

public class Cook extends Employee {
   public static final String type = "cozinheiro";

   public Cook(String login) {
      super(login);
   }

   @Override
   protected String getType() {
      return type;
   }

   @Override
   public void signIn() {
      signIn(MakeOrder.me, EditProfile.me);
   }
}