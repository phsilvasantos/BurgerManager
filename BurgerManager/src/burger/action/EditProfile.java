package burger.action;

import burger.BurgerMan;
import burger.model.employee.Employee;

import java.util.HashMap;

public class EditProfile implements Action {
   @Override
   public void execute(Employee executor) throws Exception {
      HashMap<String, String> profile = new HashMap<>();
      profile.put("login", executor.login);

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

      ValidateProfile.addProfile(profile);
      System.out.println("Alteração de perfil encaminhada para validação.");
   }

   @Override
   public String toString() {
      return "alterar perfil";
   }
}