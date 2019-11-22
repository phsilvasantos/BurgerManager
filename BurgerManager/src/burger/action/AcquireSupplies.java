package burger.action;

import burger.BurgerMan;
import burger.model.product.Juice;
import burger.model.product.Soda;
import burger.model.supply.*;

public class AcquireSupplies implements Action {
   private Supply[] supplies;

   public AcquireSupplies() {
      supplies = new Supply[] {
         new Bread(), new Beef(), new Chicken(), new Cheese(), new Lettuce(),
         new Tomato(), new Soda(), new Juice(), new Box(), new CupHolder()
      };
   }

   public void execute() throws Exception {
      System.out.println("\n0 - finalizar");
      int s;
      for (s = 1; s <= supplies.length; s++)
         System.out.println(s + " - " + supplies[s - 1]);
      System.out.println();

      while (true) {
         System.out.print("Suprimento: ");
         s = Integer.parseInt(BurgerMan.input.nextLine());
         if (s == 0)
            break;

         Supply supply = supplies[s - 1];

         System.out.print("Quantidade: ");
         int t = Integer.parseInt(BurgerMan.input.nextLine());

         for (s = 0; s < t; s++)
            if (supply instanceof Box || supply instanceof CupHolder)
               BoxOrder.addPackage(supply);
            else
               MakeOrder.addIngredient(supply);
      }

      System.out.println("\nSuprimentos adicionados.");
   }

   @Override
   public String toString() {
      return "adquirir suprimentos";
   }
}