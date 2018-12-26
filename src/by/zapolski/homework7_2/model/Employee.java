package by.zapolski.homework7_2.model;

public class Employee {
    private String name;
    private PaymentType paymentType;
    private long sum;
    private int countChildren;
    private boolean isOffshore;
    private int hours;
    private int premium;

    public Employee(String name, PaymentType paymentType, long sum, int countChildren, boolean isOffshore, int hours) {
        this.name = name;
        this.paymentType = paymentType;
        this.sum = sum;
        this.countChildren = countChildren;
        this.isOffshore = isOffshore;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", paymentType=" + paymentType +
                ", sum=" + sum +
                '}';
    }

    public String getName() {
        return name;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public long getSum() {
        return sum;
    }

    public int getCountChildren() {
        return countChildren;
    }

    public boolean isOffshore() {
        return isOffshore;
    }

    public int getHours() {
        return hours;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }
}
