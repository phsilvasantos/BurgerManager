package burger.action;

import burger.model.supply.Supply;

import java.util.ArrayList;

public class BoxOrder implements Action {
   private static ArrayList<Supply> supplies;

   public static boolean addSupply(Supply supply) {
      return supplies.add(supply);
   }

   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "embalar pedido";
   }
}