package burger.action;

import burger.BurgerMan;
import burger.model.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidateProfile implements Action {
   private static ArrayList<HashMap<String, String>> profiles = new ArrayList<>();

   static boolean addProfile(HashMap<String, String> profile) {
      return profiles.add(profile);
   }

   @Override
   public void execute(Employee executor) throws Exception {
      for (HashMap<String, String> profile : profiles) {
         String login = profile.remove("login");
         Employee employee = BurgerMan.getEmployee(login);
         System.out.println("\nFuncionário: " + employee.getName() + " (" + login + ")");

         for (String key : profile.keySet()) {
            String value = profile.get(key);
            System.out.println(key + ": " + value);
            System.out.print("ok? (s/n):");

            if (!BurgerMan.input.nextLine().toLowerCase().equals("n"))
               switch (key) {
                  case ("nome"):
                  employee.setName(value);
                  break;

                  case ("cpf"):
                  employee.setCPF(value);
                  break;

                  case ("e-mail"):
                  case ("email"):
                  employee.setEmail(value);
                  break;

                  default:
                  employee.putAttribute(key, value);
               }
         }
      }

      profiles.clear();
   }

   @Override
   public String toString() {
      return "validar alteração de perfil";
   }
}