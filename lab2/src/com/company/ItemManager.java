package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

enum Order{
    ASC,
    DESC
}

public class ItemManager {

    public void sortByPriceAnonymous(ArrayList<Item> itemArrayList, Order order) {
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        };

        if (order.name().equals("ASC")) {
            itemArrayList.sort(comparator);
        } else {
            itemArrayList.sort(comparator.reversed());
        }
    }

    public void sortByPriceInner(ArrayList<Item> itemArrayList, Order order) {
        Item device = new Item();
        Item.InnerComparator comparator = device.new InnerComparator();

        if (order.name().equals("ASC")) {
            itemArrayList.sort(comparator);
        } else {
            itemArrayList.sort(comparator.reversed());
        }
    }

    public void sortByName(ArrayList<Item> itemArrayList, Order order) {
        if (order.name().equals("ASC")) {
            itemArrayList.sort(new Item.StaticInnerComparator());
        } else {
            itemArrayList.sort(new Item.StaticInnerComparator().reversed());
        }
    }

    public void sortByNameLambda(ArrayList<Item> itemArrayList, Order order) {
        if (order.name().equals("ASC")) {
            itemArrayList.sort((a, b) -> a.getName().compareTo(b.getName()));
        } else {
            itemArrayList.sort((a, b) -> a.getName().compareTo(b.getName()) * -1);
        }
    }

    public void printItemArrayList(ArrayList<Item> itemArrayList){
        itemArrayList.forEach(System.out::println);
    }

    public void searchBySportType(ArrayList<Item> itemArrayList, String sportType){
        System.out.println("sportType: " + sportType);
        for (Item item : itemArrayList) {
            if (Objects.equals(item.getSportType(), sportType))
                System.out.println(item);
        }
    }

    public void sortBySportName(ArrayList<Item> itemArrayList, Order order){
        Comparator<Item> comparator = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return CharSequence.compare(o1.getSportType(), o2.getSportType());
            }
        };

        if (order.name().equals("ASC")) {
            itemArrayList.sort(comparator);
        } else {
            itemArrayList.sort(comparator.reversed());
        }
    }



}
