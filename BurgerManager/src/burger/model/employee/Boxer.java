package burger.model.employee;

import burger.action.Action;
import burger.action.BoxOrder;
import burger.action.EditProfile;

public class Boxer extends Employee {
   private static Action[] actions = new Action[] {new BoxOrder(), new EditProfile()};
   private static int nBoxer;

   public Boxer() {
      super();
   }

   public Boxer(String login) {
      super(login);
   }

   @Override
   public Boxer build() {
      return new Boxer(getType() + "_" + (nBoxer++));
   }

   @Override
   public String getType() {
      return "embalador";
   }

   @Override
   public void signIn() {
      signIn(actions);
   }
}