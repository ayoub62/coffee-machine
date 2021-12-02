package integrationtests;

import appender.IOrderAppender;
import appender.OrderAppender;
import coffeemachine.CoffeeMachine;
import coffeemachine.ICoffeeMachine;
import controller.IMoneyController;
import controller.MoneyController;
import drinkmaker.DrinkMaker;
import drinkmaker.IDrinkMaker;
import messagesender.CustomerMessageSender;
import messagesender.IMessageSender;
import models.drinks.*;
import models.orders.Order;
import models.suppliments.ExtraColdSuppliment;
import models.suppliments.ExtraHotSuppliment;
import models.suppliments.Suppliment;
import ordertaker.IOrderTaker;
import ordertaker.OrderTaker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineIntegrationTest {


    private ICoffeeMachine coffeeMachine;

    private IOrderAppender orderAppender = spy(OrderAppender.class);
    private IDrinkMaker drinkMaker = spy(DrinkMaker.class);
    private IMoneyController moneyController = spy(MoneyController.class);
    private IOrderTaker orderTaker = spy(OrderTaker.class);
    private IMessageSender messageSender = spy(CustomerMessageSender.class);

    @Before
    public void before() {
        this.coffeeMachine = new CoffeeMachine(
                orderAppender,
                drinkMaker,
                messageSender,
                orderTaker,
                moneyController
        );
    }

    @Test
    public void should_controle_inserted_coins_before_serving_a_drink() {
        doReturn(this.buildOrder(0.3, new Coffee(), null)).when(this.orderTaker)
                .takeOrder();
        this.coffeeMachine.serveDrink();
        verify(this.messageSender).send("Sorry, you have to add 0.3 euros.", false);
    }

    @Test
    public void should_serve_chocolate_with_one_sugar_without_any_suppliments() {
        doReturn(this.buildOrder(1, new Chocolate(), null)).when(this.orderTaker)
                .takeOrder();
        this.coffeeMachine.serveDrink();
        verify(this.messageSender).send("H:1:0", true);
    }

    @Test
    public void should_serve_tea_with_one_sugar_with_extra_hot_suppliment() {
        doReturn(this.buildOrder(1, new Tea(), new ExtraHotSuppliment())).when(this.orderTaker)
                .takeOrder();
        this.coffeeMachine.serveDrink();
        verify(this.messageSender).send("Th:1:0", true);
    }

    @Test
    public void should_serve_orange_with_one_sugar_with_extra_cold_suppliment() {
        doReturn(this.buildOrder(1, new Orange(), new ExtraColdSuppliment())).when(this.orderTaker)
                .takeOrder();
        this.coffeeMachine.serveDrink();
        verify(this.messageSender).send("Oc:1:0", true);
    }

    private Order buildOrder(double insertedMoney, Drink drink, Suppliment suppliment) {
        Order order = new Order(drink);
        order.addOneSugar();
        order.setInsertedMoney(insertedMoney);
        if (suppliment != null) {
            order.addSuppliment(suppliment);
        }
        return order;
    }
}
