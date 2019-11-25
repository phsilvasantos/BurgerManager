package burger.model.supply;

import burger.model.Product;

public abstract class Supply extends Product {
   public abstract double getPrice();
   public abstract void setPrice(double price) throws Exception;
}