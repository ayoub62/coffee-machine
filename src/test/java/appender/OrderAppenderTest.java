package appender;

import models.drinks.*;
import models.orders.Order;
import models.suppliments.ExtraColdSuppliment;
import models.suppliments.ExtraHotSuppliment;
import models.suppliments.Suppliment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
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
    public void should_be_able_to_make_a_tea_with_two_sugars_and_stick() {
        Order order = this.buildOrder(new Tea());
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("T:2:0");
    }

    @Test
    public void should_be_able_to_make_a_coffee_with_two_sugars_and_stick() {
        Order order = this.buildOrder(new Coffee());
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("C:2:0");
    }

    @Test
    public void should_be_able_to_make_a_chocolate_with_two_sugars_and_stick() {
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

    @Test
    public void should_be_able_to_make_a_orange_with_one_sugar_and_stick() {
        Order order = this.buildOrder(new Orange());
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("O:1:0");
    }

    @Test
    public void should_be_able_to_make_a_orange_with_two_sugars_and_stick() {
        Order order = this.buildOrder(new Orange());
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("O:2:0");
    }

    @Test
    public void should_be_able_to_make_a_orange_without_any_sugar() {
        Order order = this.buildOrder(new Orange());
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("O::");
    }

    @Test
    public void should_be_able_to_make_an_extra_hot_coffee_without_any_sugar() {
        Order order = this.buildOrder(new Coffee(), asList(new ExtraHotSuppliment()));
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("Ch::");
    }

    @Test
    public void should_be_able_to_make_an_extra_hot_chocolate_with_one_sugar() {
        Order order = this.buildOrder(new Chocolate(), asList(new ExtraHotSuppliment()));
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("Hh:1:0");
    }

    @Test
    public void should_be_able_to_make_an_extra_tea_chocolate_with_two_sugars() {
        Order order = this.buildOrder(new Tea(), asList(new ExtraHotSuppliment()));
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("Th:2:0");
    }

    @Test
    public void should_be_able_to_make_an_extra_cold_orange_with_two_sugars() {
        Order order = this.buildOrder(new Orange(), asList(new ExtraColdSuppliment()));
        order.addOneSugar();
        order.addOneSugar();
        assertThat(this.orderAppender.extractOrder(order))
                .isEqualTo("Oc:2:0");
    }

    private Order buildOrder(Drink drink) {
        return new Order(drink);
    }

    private Order buildOrder(Drink drink, List<Suppliment> suppliments) {
        Order order = new Order(drink);
        order.setSuppliments(suppliments);
        return order;
    }
}