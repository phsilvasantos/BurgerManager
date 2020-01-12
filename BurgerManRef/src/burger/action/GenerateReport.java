package burger.action;

import burger.action.employee.EmployeeHandler;
import burger.action.order.OrderHandler;
import burger.model.employee.Employee;

public class GenerateReport implements Action {
   public static final GenerateReport me = new GenerateReport();

   private GenerateReport() {}

   @Override
   public void execute(Employee agent) {
      System.out.println();
      OrderHandler.viewDeliveredOrders();
      System.out.println();
      OrderHandler.viewStorage();
      System.out.println();
      EmployeeHandler.viewEmployees();
   }

   @Override
   public String toString() {
      return "emitir relatório";
   }
}