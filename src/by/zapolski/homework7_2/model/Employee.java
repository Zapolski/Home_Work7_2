package by.zapolski.homework7_2.model;

public class Employee {
    private String name;
    private PaymentType paymentType;
    private long sum;
    private int countChildren;

    public Employee(String name, PaymentType paymentType, long sum, int countChildren) {
        this.name = name;
        this.paymentType = paymentType;
        this.sum = sum;
        this.countChildren = countChildren;
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
}
