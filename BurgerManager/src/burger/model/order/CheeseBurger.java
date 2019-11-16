package burger.model.order;

public class CheeseBurger implements Product {
   private static final Supply[] ingredients = new Supply[] {
      Supply.BREAD, Supply.CHEESE, Supply.LETTUCE, Supply.TOMATO
   };

   public Supply[] getIngredients() {
      return ingredients;
   }

   public Supply getPackage() {
      return Supply.BOX;
   }
}