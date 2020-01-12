package burger.factory;

import burger.model.employee.Boxer;

public class BoxerFactory implements Factory {
   public static final BoxerFactory me = new BoxerFactory();
   private int nBoxer;

   private BoxerFactory() {}

   @Override
   public Boxer create() {
      return new Boxer(getType() + "_" + nBoxer++);
   }

   @Override
   public String getType() {
      return Boxer.type;
   }
}