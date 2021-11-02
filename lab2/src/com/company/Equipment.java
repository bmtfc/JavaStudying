package com.company;

public class Equipment extends Item {
    private Integer minTemperature;
    private Integer maxTemperature;

    Equipment(String name, Double price, String sportType, Integer minTemperature, Integer maxTemperature) {
        super(name, price, sportType);
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }


    public Integer getMinTemperature() {
        return minTemperature;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", sportType='" + sportType + '\'' +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}
