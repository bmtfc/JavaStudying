package com.company;

public class Tops extends ShopItem{
    private String topSize;

    public Tops(){

    }

    public Tops(Float price, String type, String color, String brand, String name, String category, String topSize) {
        super(price, type, color, brand, name, category);
        this.topSize = topSize;
    }

    public String getTopSize() {
        return topSize;
    }

    public void setTopSize(String topSize) {
        this.topSize = topSize;
    }
}
