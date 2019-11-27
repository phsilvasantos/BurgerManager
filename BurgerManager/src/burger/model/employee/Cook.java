package burger.model.employee;

import burger.action.Action;
import burger.action.EditProfile;
import burger.action.MakeOrder;

public class Cook extends Employee {
   private static Action[] actions = new Action[] {new MakeOrder(), new EditProfile()};
   private static int nCook;

   public Cook() {
      super();
   }

   public Cook(String login) {
      super(login);
   }

   @Override
   public Cook build() {
      return new Cook(getType() + (nCook++));
   }

   @Override
   public String getType() {
      return "cozinheiro";
   }

   @Override
   public void signIn() {
      signIn(actions);
   }
}