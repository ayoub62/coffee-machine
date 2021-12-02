package coffeemachine;

import appender.IOrderAppender;
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

    @Spy
    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Test
    public void should_serve_coffee_and_send_a_message_to_the_client_when_done() {
        when(this.orderTaker.takeOrder())
                .thenReturn(new Order());
        when(this.orderAppender.extractOrder(any()))
                .thenReturn("T:1:0");
        this.coffeeMachine.serveDrink();
        verify(this.drinkMaker).makeDrink();
        verify(this.orderAppender).extractOrder(any());
        verify(this.orderTaker).takeOrder();
        verify(this.messageSender).send("T:1:0");
    }
}