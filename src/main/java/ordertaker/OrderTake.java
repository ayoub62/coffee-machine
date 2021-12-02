package ordertaker;

import models.drinks.Tea;
import models.orders.Order;

public class OrderTake implements IOrderTaker {
    @Override
    public Order takeOrder() {
        return new Order(new Tea());
    }
}
