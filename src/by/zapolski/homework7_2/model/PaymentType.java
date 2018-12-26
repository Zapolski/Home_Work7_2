package by.zapolski.homework7_2.model;

public enum PaymentType {
    RATE ("ставка"),
    HOURLY ("почасовая"),
    MADE ("сдельная");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
