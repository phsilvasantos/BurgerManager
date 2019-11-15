package burger.builder.employee;

import burger.model.employee.Boxer;

public class BoxerBuilder extends EmployeeBuilder {
   private static int nBoxer;

   public Boxer build() throws Exception {
      Boxer boxer = new Boxer("embalador" + (nBoxer++));
      setInfo(boxer);
      put(boxer);

      return boxer;
   }

   public String getType() {
      return "embalador";
   }
}