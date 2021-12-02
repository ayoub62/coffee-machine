package appender;

import models.orders.Order;

public interface IOrderAppender {

    String extractOrder(Order order);
}
