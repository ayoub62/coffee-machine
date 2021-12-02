package messagesender;

public class CustomerMessageSender implements IMessageSender {


    @Override
    public void send(String message, boolean drinkServed) {
        if (drinkServed) {
            send(message);
            return;
        }
        send("M:" + message);
    }

    protected void send(String message) {

    }
}
