package burger.action.profile;

import burger.action.Action;
import burger.model.employee.Employee;

public class EditProfile implements Action {
   public static final EditProfile me = new EditProfile();

   private EditProfile() {}

   @Override
   public void execute(Employee agent) throws Exception {
      ProfileHandler.editProfile(agent);
   }

   @Override
   public String toString() {
      return "alterar perfil";
   }
}