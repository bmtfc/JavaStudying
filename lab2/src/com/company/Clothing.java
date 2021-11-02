package com.company;

public class Clothing extends Item{

    private String size;

    Clothing(String name, Double price, String sportType, String size) {
        super(name, price, sportType);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sportType='" + sportType + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
