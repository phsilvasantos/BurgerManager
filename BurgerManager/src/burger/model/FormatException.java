package burger.model;

public class FormatException extends Exception {
   private static final long serialVersionUID = 1L;

   public FormatException() {
      super("Formato incorreto.");
   }
}