package com.ageev.itstep.entity;


public class Phone {
    private String color;
    private double price;
    private double screenSize;

    public Phone() {
    }

    public Phone(String color, double price, double screenSize) {
        this.color = color;
        this.price = price;
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;

        Phone phone = (Phone) o;

        if (Double.compare(phone.getPrice(), getPrice()) != 0) return false;
        if (Double.compare(phone.getScreenSize(), getScreenSize()) != 0) return false;
        return getColor() != null ? getColor().equals(phone.getColor()) : phone.getColor() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getColor() != null ? getColor().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getScreenSize());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "color='" + color + '\'' +
                ", price=" + price +
                ", screenSize=" + screenSize +
                '}';
    }
}
