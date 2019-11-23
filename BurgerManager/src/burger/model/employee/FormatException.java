package burger.model.employee;

public class FormatException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   public FormatException() {
      super("Formato incorreto.");
   }
}