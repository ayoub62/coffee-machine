package models.orders;

import models.drinks.Drink;
import models.suppliments.Suppliment;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Drink drink;
    private int sugarCount;
    private double insertedMoney;
    private List<Suppliment> suppliments = new ArrayList<>();

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

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public void setInsertedMoney(double insertedMoney) {
        this.insertedMoney = insertedMoney;
    }

    public List<Suppliment> getSuppliments() {
        return suppliments;
    }

    public void setSuppliments(List<Suppliment> suppliments) {
        this.suppliments = suppliments;
    }

    public void addSuppliment(Suppliment suppliment) {
        this.suppliments.add(suppliment);
    }
}
