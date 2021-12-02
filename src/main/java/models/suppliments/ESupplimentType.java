package models.suppliments;

public enum ESupplimentType {

    EXTRA_HOT("h"),
    EXTRA_COLD("c");

    private String supplimentId;

    ESupplimentType(String supplimentId) {
        this.supplimentId = supplimentId;
    }

    public String getSupplimentId() {
        return supplimentId;
    }
}
