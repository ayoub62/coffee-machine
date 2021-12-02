package coffeemachine;

import appender.IOrderAppender;
import controller.IMoneyController;
import drinkmaker.IDrinkMaker;
import junit.framework.TestCase;
import messagesender.IMessageSender;
import models.orders.Order;
import ordertaker.IOrderTaker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineTest extends TestCase {

    @Mock
    private IOrderAppender orderAppender;
    @Mock
    private IDrinkMaker drinkMaker;
    @Mock
    private IMessageSender messageSender;
    @Mock
    private IOrderTaker orderTaker;
    @Mock
    private IMoneyController moneyController;

    @Spy
    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Test
    public void should_serve_drink_and_send_a_message_to_the_client_when_done() {
        when(this.orderTaker.takeOrder())
                .thenReturn(new Order());
        when(this.orderAppender.extractOrder(any()))
                .thenReturn("T:1:0");
        when(this.moneyController.controle(any()))
                .thenReturn(1.2);
        this.coffeeMachine.serveDrink();
        verify(this.drinkMaker).makeDrink();
        verify(this.orderAppender).extractOrder(any());
        verify(this.orderTaker).takeOrder();
        verify(this.messageSender).send("T:1:0", true);
    }

    @Test
    public void should_controle_insterted_amount_before_to_serve_a_drink() {
        when(this.orderTaker.takeOrder())
                .thenReturn(new Order());
        when(this.moneyController.controle(any()))
                .thenReturn(-0.1);
        this.coffeeMachine.serveDrink();
        verify(this.drinkMaker,never()).makeDrink();
        verify(this.orderAppender,never()).extractOrder(any());
        verify(this.orderTaker).takeOrder();
        verify(this.messageSender).send("Sorry, you have to add 0.1 euros.", false);
    }
}