package controller;

import junit.framework.TestCase;
import models.drinks.Tea;
import models.orders.Order;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MoneyControllerTest extends TestCase {

    private IMoneyController moneyController;

    @Before
    public void before() {
        this.moneyController = new MoneyController();
    }

    @Test
    public void should_compare_inserted_coins_with_a_drink_price() {
        Order order = new Order(new Tea());
        order.setInsertedMoney(2);
        Assertions.assertThat(this.moneyController.controle(order))
                .isEqualTo(1.6);
    }
}