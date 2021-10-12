package com.company;

import java.util.Comparator;

public class ShopItem {
    private String name;
    private String category;
    private Float price;
    private String type;
    private String color;
    private String brand;

    public ShopItem() {

    }

    public ShopItem(Float price, String type, String color, String brand, String name, String category) {
        this.price = price;
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.name = name;
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    class InnerComparator implements Comparator<ShopItem> {
        @Override
        public int compare(ShopItem o1, ShopItem o2) {
            return o1.getBrand().compareTo(o2.getBrand());
        }
    }

    static class StaticInnerComparator implements Comparator<ShopItem> {
        @Override
        public int compare(ShopItem o1, ShopItem o2) {
            return o1.getColor().compareTo(o2.getColor());
        }
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
