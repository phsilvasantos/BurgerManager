package burger.action.profile;

import burger.action.Action;
import burger.model.employee.Employee;

public class ValidateProfile implements Action {
   public static final ValidateProfile me = new ValidateProfile();

   private ValidateProfile() {}

   @Override
   public void execute(Employee agent) throws Exception {
      ProfileHandler.validateProfile();
   }

   @Override
   public String toString() {
      return "validar alteração de perfil";
   }
}