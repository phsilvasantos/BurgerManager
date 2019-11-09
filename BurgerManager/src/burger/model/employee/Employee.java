package burger.model.employee;

public abstract class Employee {
   public String cpf, email, name;
   private String login;

   public Employee(String login) {
      this.login = login;
   }

   public abstract void callAction();

   public String getLogin() {
      return login;
   }
}