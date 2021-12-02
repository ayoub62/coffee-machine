package models.drinks;

public class Drink {

    protected EDrinkType drinkType;

    public EDrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(EDrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public Drink(EDrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public Drink() {
    }
}
