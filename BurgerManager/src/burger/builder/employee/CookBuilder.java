package burger.builder.employee;

import burger.model.employee.Cook;

public class CookBuilder extends EmployeeBuilder {
   private static int nCook;

   public Cook build() throws Exception {
      Cook cook = new Cook("cozinheiro" + (nCook++));
      setInfo(cook);
      put(cook);

      return cook;
   }

   public String getType() {
      return "cozinheiro";
   }
}