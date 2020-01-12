package burger.model.employee;

import burger.BurgerMan;
import burger.action.Action;
import burger.model.Person;

import java.util.HashMap;

public abstract class Employee extends Person {
   public final String login;
   private HashMap<String, String> profile;

   public Employee(String login) {
      this.login = login;
      this.profile = new HashMap<>();
   }

   public HashMap<String, String> getProfile() {
      return new HashMap<>(profile);
   }

   protected abstract String getType();

   public String putAttribute(String key, String value) {
      return profile.put(key, value);
   }

   public abstract void signIn();

   protected void signIn(Action... actions) {
      while (true) {
         System.out.println("\n0 - sair");
         int a;
         for (a = 1; a <= actions.length; a++)
            System.out.println(a + " - " + actions[a - 1]);
         System.out.print("\nAção: ");

         try {
            a = Integer.parseInt(BurgerMan.input.nextLine());
            if (a == 0)
               break;

            actions[a - 1].execute(this);
         } catch (NumberFormatException | IndexOutOfBoundsException ex) {
            System.out.println("<!> Entrada inválida.");
         } catch (Exception ex) {
            System.out.println("<!> " + ex.getMessage());
         }
      }
   }

   @Override
   public String toString() {
      String e = "login: " + login;
      e += "\n" + super.toString();

      for (String key : profile.keySet()) {
         String value = profile.get(key);
         e += "\n" + key + ": " + value;
      }

      e += "\nfunção: " + getType();

      return e;
   }
}