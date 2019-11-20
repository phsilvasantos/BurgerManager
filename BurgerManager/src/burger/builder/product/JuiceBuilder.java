package burger.builder.product;

import burger.model.product.Juice;

public class JuiceBuilder implements ProductBuilder {
   public Juice build() {
      return new Juice();
   }

   public String getType() {
      return "suco";
   }
}