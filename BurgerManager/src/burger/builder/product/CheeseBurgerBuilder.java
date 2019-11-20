package burger.builder.product;

import burger.model.product.CheeseBurger;

public class CheeseBurgerBuilder implements ProductBuilder {
   public CheeseBurger build() {
      return new CheeseBurger();
   }

   public String getType() {
      return "cheeseburger";
   }
}