package burger.model.employee;

import burger.action.order.BoxOrder;
import burger.action.profile.EditProfile;

public class Boxer extends Employee {
   public static final String type = "embalador";

   public Boxer(String login) {
      super(login);
   }

   @Override
   protected String getType() {
      return type;
   }

   @Override
   public void signIn() {
      signIn(BoxOrder.me, EditProfile.me);
   }
}