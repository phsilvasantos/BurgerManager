package burger.action;

import burger.BurgerMan;
import burger.model.employee.Employee;
import burger.model.employee.Supplier;
import burger.model.supply.*;

import java.util.HashMap;

public class AcquireSupplies implements Action {
   private Supply[] supplies;

   public AcquireSupplies() {
      supplies = new Supply[] {
         new Bread(), new Beef(), new Chicken(), new Cheese(), new Lettuce(),
         new Tomato(), new SodaS(), new JuiceS(), new Box(), new CupHolder()
      };
   }

   @Override
   public void execute(Employee executor) throws Exception {
      System.out.println("\n0 - finalizar");
      int s;
      for (s = 1; s <= this.supplies.length; s++)
         System.out.println(s + " - " + this.supplies[s - 1]);
      System.out.println();

      HashMap<Supply, Integer> supplies = new HashMap<>();
      while (true) {
         System.out.print("Suprimento: ");
         s = Integer.parseInt(BurgerMan.input.nextLine());
         if (s == 0)
            break;

         Supply supply = this.supplies[s - 1];

         System.out.print("Quantidade: ");
         int nSupply = Integer.parseInt(BurgerMan.input.nextLine());
         if (nSupply > 0)
            supplies.put(supply, nSupply);
      }

      if (!supplies.isEmpty()) {
         for (Supply supply : supplies.keySet()) {
            int nSupply = supplies.get(supply);
            for (s = 0; s < nSupply; s++)
               if (supply instanceof Box || supply instanceof CupHolder)
                  BoxOrder.addPackage(supply);
               else
                  MakeOrder.addIngredient(supply);
            }

         PayEmployees.addSupplier((Supplier) executor);
         System.out.println("\nSuprimentos adicionados.");
      }
   }

   @Override
   public String toString() {
      return "adquirir suprimentos";
   }
}