package burger.model.employee;

import burger.action.MakeOrder;

public class Cook extends Employee {
   private static MakeOrder action = new MakeOrder();
   private static int nCook;

   public Cook() {
      super();
   }

   public Cook(String login) {
      super(login);
   }

   @Override
   public Cook build() {
      return new Cook(toString() + (nCook++));
   }

   @Override
   public void signIn() {
      signIn(action);
   }

   @Override
   public String toString() {
      return "cozinheiro";
   }
}