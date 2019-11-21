package burger.model.product;

import burger.model.Builder;
import burger.model.supply.Supply;

public interface Product extends Builder<Product> {
   public Supply[] getIngredients();
   public Supply getPackage();
}