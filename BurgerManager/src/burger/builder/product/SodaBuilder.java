package burger.builder.product;

import burger.model.product.Soda;

public class SodaBuilder implements ProductBuilder {
   public Soda build() {
      return new Soda();
   }

   public String getType() {
      return "refrigerante";
   }
}