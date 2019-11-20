package burger.builder.product;

import burger.model.product.BeefBurger;

public class BeefBurgerBuilder implements ProductBuilder {
   public BeefBurger build() {
      return new BeefBurger();
   }

   public String getType() {
      return "hamburger de carne";
   }
}