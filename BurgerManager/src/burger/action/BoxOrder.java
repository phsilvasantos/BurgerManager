package burger.action;

import burger.model.supply.Supply;

import java.util.ArrayList;

public class BoxOrder implements Action {
   private static ArrayList<Supply> packs;

   public static boolean addPackage(Supply pack) {
      return packs.add(pack);
   }

   public void execute() {
      System.out.println("Em desenvolvimento.");
   }

   @Override
   public String toString() {
      return "embalar pedido";
   }
}