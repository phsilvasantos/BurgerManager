package burger.model.employee;

import burger.action.Action;
import burger.action.EditProfile;
import burger.action.TakeOrder;

public class Cashier extends Employee {
   private static Action[] actions = new Action[] {new TakeOrder(), new EditProfile()};
   private static int nCashier;

   public Cashier() {
      super();
   }

   public Cashier(String login) {
      super(login);
   }

   @Override
   public Cashier build() {
      return new Cashier(getType() + (nCashier++));
   }

   @Override
   public String getType() {
      return "atendente";
   }

   @Override
   public void signIn() {
      signIn(actions);
   }
}