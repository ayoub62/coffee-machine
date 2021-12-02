package appender;

import models.drinks.Chocolate;
import models.drinks.Coffee;
import models.drinks.Drink;
import models.drinks.Tea;
import models.orders.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class OrderAppenderTest {


    private IOrderAppender orderAppender;

    @Before
    public void before() {
        this.orderAppender = new OrderAppender();
    }

    @Test
    public void should_be_able_to_make_a_tea_with_one_sugar_and_stick() {
        Order order = this.buildOrder(new Tea());
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("T:1:0");
    }

    @Test
    public void should_be_able_to_make_a_coffee_with_one_sugar_and_stick() {
        Order order = this.buildOrder(new Coffee());
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("C:1:0");
    }

    @Test
    public void should_be_able_to_make_a_chocolate_with_one_sugar_and_stick() {
        Order order = this.buildOrder(new Chocolate());
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("H:1:0");
    }

    @Test
    public void should_be_able_to_make_a_tea_with_two_sugar_and_stick() {
        Order order = this.buildOrder(new Tea());
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("T:2:0");
    }

    @Test
    public void should_be_able_to_make_a_coffee_with_two_sugar_and_stick() {
        Order order = this.buildOrder(new Coffee());
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("C:2:0");
    }

    @Test
    public void should_be_able_to_make_a_chocolate_with_two_sugar_and_stick() {
        Order order = this.buildOrder(new Chocolate());
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("H:2:0");
    }

    @Test
    public void should_be_able_to_make_a_chocolate_without_any_sugar() {
        Order order = this.buildOrder(new Chocolate());
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("H::");
    }

    @Test
    public void should_be_able_to_make_a_tea_without_any_sugar() {
        Order order = this.buildOrder(new Tea());
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("T::");
    }

    @Test
    public void should_be_able_to_make_a_coffee_without_any_sugar() {
        Order order = this.buildOrder(new Coffee());
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("C::");
    }

    private Order buildOrder(Drink drink) {
        return new Order(drink);
    }
}