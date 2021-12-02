package models.suppliments;

public class Suppliment {

    private ESupplimentType supplimentType;

    public Suppliment() {
    }

    public Suppliment(ESupplimentType supplimentType) {
        this.supplimentType = supplimentType;
    }

    public ESupplimentType getSupplimentType() {
        return supplimentType;
    }

    public void setSupplimentType(ESupplimentType supplimentType) {
        this.supplimentType = supplimentType;
    }
}
