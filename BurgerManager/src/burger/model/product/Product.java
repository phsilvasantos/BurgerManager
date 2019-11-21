package burger.model.product;

import burger.model.supply.Supply;

public interface Product {
   public Supply[] getIngredients();
   public Supply getPackage();
}