package coffeemachine;

import appender.IOrderAppender;
import drinkmaker.IDrinkMaker;
import messagesender.IMessageSender;
import models.orders.Order;
import ordertaker.IOrderTaker;

public class CoffeeMachine implements ICoffeeMachine {

    private IOrderAppender orderAppender;
    private IDrinkMaker drinkMaker;
    private IMessageSender messageSender;
    private IOrderTaker orderTaker;

    public CoffeeMachine(IOrderAppender orderAppender,
                         IDrinkMaker drinkMaker,
                         IMessageSender messageSender,
                         IOrderTaker orderTaker) {
        this.orderAppender = orderAppender;
        this.drinkMaker = drinkMaker;
        this.messageSender = messageSender;
        this.orderTaker = orderTaker;
    }

    @Override

    public void serveDrink() {
        Order order = this.orderTaker.takeOrder();
        String extractedOrder = this.orderAppender.extractOrder(order);
        this.drinkMaker.makeDrink();
        messageSender.send(extractedOrder);
    }
}
