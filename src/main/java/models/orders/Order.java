package models.orders;

import models.drinks.Drink;

public class Order {

    private Drink drink;
    private int sugarCount;

    public Order(Drink drink) {
        this.drink = drink;
    }

    public Order() {
    }

    public void addOneSugar() {
        this.sugarCount++;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getSugarCount() {
        return sugarCount;
    }

    public void setSugarCount(int sugarCount) {
        this.sugarCount = sugarCount;
    }
}
