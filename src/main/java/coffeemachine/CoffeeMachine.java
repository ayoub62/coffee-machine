package coffeemachine;

import appender.IOrderAppender;
import controller.IMoneyController;
import drinkmaker.IDrinkMaker;
import messagesender.IMessageSender;
import models.orders.Order;
import ordertaker.IOrderTaker;

import static java.lang.Math.abs;

public class CoffeeMachine implements ICoffeeMachine {

    private IOrderAppender orderAppender;
    private IDrinkMaker drinkMaker;
    private IMessageSender messageSender;
    private IOrderTaker orderTaker;
    private IMoneyController moneyController;

    public CoffeeMachine(IOrderAppender orderAppender,
                         IDrinkMaker drinkMaker,
                         IMessageSender messageSender,
                         IOrderTaker orderTaker,
                         IMoneyController controller) {
        this.orderAppender = orderAppender;
        this.drinkMaker = drinkMaker;
        this.messageSender = messageSender;
        this.orderTaker = orderTaker;
    }

    @Override

    public void serveDrink() {
        Order order = this.orderTaker.takeOrder();
        double diffBetweenInsertedMoneyAndDrinkPrice = this.moneyController.controle(order);
        if (diffBetweenInsertedMoneyAndDrinkPrice < 0) {
            this.messageSender.send(
                    "Sorry, you have to add " + abs(diffBetweenInsertedMoneyAndDrinkPrice) + " euros.",
                    false
            );
            return;
        }
        String extractedOrder = this.orderAppender.extractOrder(order);
        this.drinkMaker.makeDrink();
        messageSender.send(extractedOrder, true);
    }
}
