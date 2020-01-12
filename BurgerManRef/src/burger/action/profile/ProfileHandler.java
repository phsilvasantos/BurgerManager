package burger.action.profile;

import burger.BurgerMan;
import burger.action.employee.EmployeeHandler;
import burger.model.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileHandler {
   private static ArrayList<HashMap<String, String>> profiles = new ArrayList<>();

   static void editProfile(Employee agent) {
      HashMap<String, String> profile = new HashMap<>();
      profile.put("login", agent.login);
      System.out.println();

      while (true) {
         System.out.print("Atributo ('-' para encerrar): ");
         String key = BurgerMan.input.nextLine().toLowerCase();

         if (key.isEmpty() || key.equals("-"))
            break;

         if (key.equals("login")) {
            System.out.println("<!> Atributo inválido.");
            continue;
         }

         System.out.print("Valor: ");
         profile.put(key, BurgerMan.input.nextLine());
      }

      profiles.add(profile);
      System.out.println("Alteração de perfil encaminhada para validação.");
   }

   static void validateProfile() throws Exception {
      for (HashMap<String, String> profile : profiles) {
         String login = profile.remove("login");
         Employee employee = EmployeeHandler.get(login);
         System.out.println("\nFuncionário: " + employee.getName() + " (" + login + ")");

         for (String key : profile.keySet()) {
            String value = profile.get(key);
            System.out.println(key + ": " + value);
            System.out.print("ok? (s/n): ");

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
}