package burger.model.employee;

import burger.BurgerMan;
import burger.action.Action;

public abstract class Employee {
   private String cpf, email, name;
   public final String login;
   private static final Exception formatException = new Exception("Formato incorreto.");

   public Employee() {
      this("-");
   }

   public Employee(String login) {
      this.login = login;
   }

   public abstract Employee build();

   public String getCPF() {
      return cpf;
   }

   public String getEmail() {
      return email;
   }

   public String getName() {
      return name;
   }

   public void setCPF(String cpf) throws Exception {
      if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
         throw formatException;
      this.cpf = cpf;
   }

   public void setEmail(String email) throws Exception {
      if (!email.matches("[a-z0-9\\.]+@[a-z\\.]+"))
         throw formatException;
      this.email = email;
   }

   public void setName(String name) {
      if (name.isEmpty())
         name = "-";
      this.name = name;
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

            actions[a - 1].execute();
         } catch (NumberFormatException | IndexOutOfBoundsException ex) {
            System.out.println("<!> Entrada inválida.");
         } catch (Exception ex) {
            System.out.println("<!> " + ex.getMessage());
         }
      }
   }
}