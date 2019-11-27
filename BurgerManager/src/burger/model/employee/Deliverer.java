package burger.model.employee;

import burger.action.Action;
import burger.action.DeliverOrder;
import burger.action.EditProfile;

public class Deliverer extends Employee {
   private static Action[] actions = new Action[] {new DeliverOrder(), new EditProfile()};
   private static int nDeliverer;

   public Deliverer() {
      super();
   }

   public Deliverer(String login) {
      super(login);
   }

   @Override
   public Deliverer build() {
      return new Deliverer(getType() + (nDeliverer++));
   }

   @Override
   public String getType() {
      return "entregador";
   }

   @Override
   public void signIn() {
      signIn(actions);
   }
}