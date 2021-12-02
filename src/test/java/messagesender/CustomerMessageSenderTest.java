package messagesender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMessageSenderTest {


    @Spy
    private CustomerMessageSender messageSender;

    @Test
    public void should_not_add_any_prefix_to_the_message_when_a_drink_is_served() {
        this.messageSender.send("MSG", true);
        verify(this.messageSender).send("MSG");
    }

    @Test
    public void should_add_a_prefix_to_the_message_when_a_drink_is_served() {
        this.messageSender.send("MSG", false);
        verify(this.messageSender).send("M:MSG");
    }
}