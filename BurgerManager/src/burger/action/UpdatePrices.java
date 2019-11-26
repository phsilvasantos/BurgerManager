package burger.action;

import burger.BurgerMan;
import burger.model.employee.Employee;
import burger.model.supply.*;

public class UpdatePrices implements Action {
   private Supply[] supplies;

   public UpdatePrices() {
      supplies = new Supply[] {
         new Bread(), new Beef(), new Chicken(), new Cheese(), new Lettuce(),
         new Tomato(), new SodaS(), new JuiceS(), new Box(), new CupHolder()
      };
   }

   @Override
   public void execute(Employee executor) throws Exception {
      System.out.println("\nTaxa de lucro ($)\n  atual: " + PayEmployees.getProfit());
      System.out.print("  novo: ");
      PayEmployees.setProfit(Double.parseDouble(BurgerMan.input.nextLine()));

      System.out.print("Porcentagem de remuneração (%)\n  atual: ");
      int percentage = (int) (100 * PayEmployees.getFraction());
      System.out.println(percentage);
      System.out.print("  novo: ");
      percentage = Integer.parseInt(BurgerMan.input.nextLine());
      PayEmployees.setFraction(percentage / 100.0);

      System.out.println("Preço dos suprimentos ($)");
      for (Supply supply : supplies) {
         System.out.println("  " + supply + "\n    atual: " + supply.getPrice());
         System.out.print("    novo: ");
         supply.setPrice(Double.parseDouble(BurgerMan.input.nextLine()));
      }
   }

   @Override
   public String toString() {
      return "atualizar preços";
   }
}