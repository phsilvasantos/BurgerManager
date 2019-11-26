package burger.exception;

public class ValueException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   public ValueException() {
      super("Valor incorreto.");
   }
}