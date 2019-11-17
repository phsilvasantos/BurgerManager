package burger.builder.product;

import burger.model.product.CheeseBurger;

public class CheeseBurgerBuilder extends ProductBuilder {
   public CheeseBurger build() {
      CheeseBurger cheeseBurger = new CheeseBurger();
      addToMake(cheeseBurger);

      return cheeseBurger;
   }

   public String getType() {
      return "cheeseburger";
   }
}