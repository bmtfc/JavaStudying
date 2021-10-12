package com.company;

public class Shoes extends ShopItem {
    private Float shoesSize;

    public Shoes(){

    }

    public Shoes(Float shoesSize){
        this.shoesSize = shoesSize;
    }

    public Shoes(Float price, String type, String color, String brand, String name, String category, Float shoesSize){
        setPrice(price);
        setType(type);
        setColor(color);
        setBrand(brand);
        setName(name);
        setCategory(category);
        this.shoesSize = shoesSize;
    }

    public float getShoesSize(){
        return shoesSize;
    }

    public void setShoesSize(float shoesSize){
        this.shoesSize = shoesSize;
    }


}
