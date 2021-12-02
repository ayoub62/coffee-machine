package models.drinks;

public enum EDrinkType {

    TEA("T"),
    COFFEE("C"),
    CHOCOLATE("H");

    private String drinkId;

    EDrinkType(String drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkId() {
        return drinkId;
    }
}
