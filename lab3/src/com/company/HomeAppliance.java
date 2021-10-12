package com.company;

import java.util.Comparator;

class HomeAppliance {
    private String name;
    private String model;
    private String manufacturer;
    private Double price;
    private Integer max_power;

    public HomeAppliance() {
    }

    public HomeAppliance(String name, String model, String manufacturer, Double price, Integer max_power){
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.max_power = max_power;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name  = name;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Integer getMaxPower(){
        return max_power;
    }

    public void setMaxPower(Integer max_power){
        this.max_power = max_power;
    }

    static class InnerComparator implements Comparator<HomeAppliance> {
        @Override
        public int compare(HomeAppliance o1, HomeAppliance o2) {
            return -o1.getPrice().compareTo(o2.getPrice());
        }
    }

    @Override
    public String toString(){
        return "Household equipment {" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price='" + price + '\'' +
                ", max power='" + max_power + '\'' +
                '}';
    }

}