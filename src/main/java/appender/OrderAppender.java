package appender;

import models.orders.Order;

import java.util.StringJoiner;

public class OrderAppender implements IOrderAppender {

    @Override
    public String extractOrder(Order order) {
        StringJoiner orderJoiner = new StringJoiner(":");
        orderJoiner.add(this.getDrinkId(order));
        orderJoiner.add(this.getSugarCount(order));
        orderJoiner.add(this.getStick(order));
        return orderJoiner.toString();
    }

    private String getStick(Order order) {
        return order.getSugarCount() == 0 ? "" : "0";
    }

    private String getSugarCount(Order order) {
        return order.getSugarCount() == 0 ? "" : String.valueOf(order.getSugarCount());
    }

    private String getDrinkId(Order order) {
        return order.getDrink().getDrinkType().getDrinkId();
    }
}
