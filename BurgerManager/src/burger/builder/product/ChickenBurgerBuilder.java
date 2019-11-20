package burger.builder.product;

import burger.model.product.ChickenBurger;

public class ChickenBurgerBuilder implements ProductBuilder {
   public ChickenBurger build() {
      return new ChickenBurger();
   }

   public String getType() {
      return "hamburger de frango";
   }
}