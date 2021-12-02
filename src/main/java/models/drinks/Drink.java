package models.drinks;

public class Drink {

    protected EDrinkType drinkType;
    protected double drinkPrice;

    public EDrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(EDrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public Drink(EDrinkType drinkType, double drinkPrice) {
        this.drinkType = drinkType;
        this.drinkPrice = drinkPrice;
    }

    public Drink() {
    }
}
