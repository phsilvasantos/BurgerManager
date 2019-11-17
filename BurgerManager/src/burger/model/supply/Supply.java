package burger.model.supply;

public abstract class Supply {
   protected static final Exception valueException = new Exception("Valor inválido.");

   public abstract double getPrice();
   public abstract void setPrice(double price) throws Exception;
}