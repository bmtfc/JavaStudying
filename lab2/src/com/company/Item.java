package com.company;

import java.util.Comparator;

public class Item {
    protected String name;
    protected Double price;
    protected String sportType;

    public Item(String name, Double price, String sportType) {
        this.name = name;
        this.price = price;
        this.sportType = sportType;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sportType='" + sportType + '\'' +
                '}';
    }

    static class StaticInnerComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.name.compareTo(o2.getName());
        }
    }

    class InnerComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.price, o2.getPrice());
        }
    }


}
