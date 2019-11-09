package burger.model.employee;

public class Manager extends Employee {
   public Manager(String login) {
      super(login);
   }

   public void callAction() {
      System.out.println("Em desenvolvimento.");
   }
}