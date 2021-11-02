package com.company;

import java.util.ArrayList;

public class Shop {
    public void fillItemArrayList(ArrayList<Item> itemArrayList){
        itemArrayList.add(new Clothing("diving mask tnf laguna", 19.99, "diving", "s"));
        itemArrayList.add(new Clothing("diving mask tnf laguna", 19.99, "diving", "m"));
        itemArrayList.add(new Clothing("dry suit  extrwt blue", 39.99, "scuba diving", "m"));
        itemArrayList.add(new Clothing("dry suit  extrwt black", 49.99, "scuba diving", "m"));
        itemArrayList.add(new Clothing("wet suit power 200", 24.99, "surfing", "m"));
        itemArrayList.add(new Clothing("helmet extrmsnow def100+", 69.99, "snowboarding", "s"));
        itemArrayList.add(new Clothing("helmet extrmsnow def100+", 69.99, "snowboarding", "m"));
        itemArrayList.add(new Clothing("helmet extrmsnow def500+", 99.99, "snowboarding", "m"));
        itemArrayList.add(new Equipment("flippers extwt pwr100", 14.99, "diving", -10,60));
        itemArrayList.add(new Equipment("flippers extwt pwr200", 24.99, "diving", -15,65));
        itemArrayList.add(new Equipment("rebreather o2 xw100", 89.99, "scuba diving", -30,70));
        itemArrayList.add(new Equipment("rebreather o2 xw150", 119.99, "scuba diving", -40,80));
        itemArrayList.add(new Equipment("snowboard snw glide1000", 139.99, "snowboarding", -70,30));
        itemArrayList.add(new Equipment("surfboard wtr super gilde", 124.99, "surfing", -15,65));
        itemArrayList.add(new Equipment("wingsuit gdfl inv500", 199.99, "wingsuit", -40,60));
        itemArrayList.add(new Equipment("parachute gdfl dwn300", 179.99, "wingsuit", -50,70));

    }
}
