package burger.model;

public abstract class Person {
   private String cpf, email, name;

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
         throw new FormatException();
      this.cpf = cpf;
   }

   public void setEmail(String email) throws Exception {
      if (!email.matches("[a-z0-9\\.]+@[a-z\\.]+"))
         throw new FormatException();
      this.email = email;
   }

   public void setName(String name) {
      if (name.isEmpty())
         name = "-";
      this.name = name;
   }
}