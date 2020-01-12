package burger.factory;

import burger.model.employee.Cook;

public class CookFactory implements Factory {
   public static final CookFactory me = new CookFactory();
   private int nCook;

   private CookFactory() {}

   @Override
   public Cook create() {
      return new Cook(getType() + "_" + nCook++);
   }

   @Override
   public String getType() {
      return Cook.type;
   }
}