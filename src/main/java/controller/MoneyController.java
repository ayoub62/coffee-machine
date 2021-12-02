package controller;

import models.orders.Order;

public class MoneyController implements IMoneyController {


    @Override
    public double controle(Order order) {
        return order.getInsertedMoney() - order.getDrink().getDrinkPrice();
    }
}
