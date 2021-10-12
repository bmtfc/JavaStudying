package com.company;

import java.util.ArrayList;
import java.util.Comparator;

enum Order {
    ASC,
    DESC
}

public class ShopItemManager {
    // ANONYMOUS
    public void sortByPrice(ArrayList<ShopItem> items, Order order) {
        System.out.print("******************************************\n" +
                "-SORT items by PRICE\n" +
                "******************************************\n");
        Comparator<ShopItem> comparator = new Comparator<ShopItem>() {
            @Override
            public int compare(ShopItem o1, ShopItem o2) {
                return Float.compare(o1.getPrice(), o2.getPrice());
            }
        };

        if (order.name().equals("ASC")) {
            items.sort(comparator);
        } else {
            items.sort(comparator.reversed());
        }
        items.forEach(System.out::println);
    }

    //STATIC INNER СLASS
    public void sortByColor(ArrayList<ShopItem> items, Order order) {
        System.out.print("******************************************\n" +
                "-SORT items by COLOR\n" +
                "******************************************\n");
        if (order.name().equals("ASC")) {
            items.sort(new ShopItem.StaticInnerComparator());
        } else {
            items.sort(new ShopItem.StaticInnerComparator().reversed());
        }
        items.forEach(System.out::println);
    }

    //INNER
    public void sortByBrand(ArrayList<ShopItem> items, Order order) {
        System.out.print("******************************************\n" +
                "-SORT items by BRAND\n" +
                "******************************************\n");
        ShopItem item = new ShopItem();
        ShopItem.InnerComparator comparator = item.new InnerComparator();

        if (order.name().equals("ASC")) {
            items.sort(comparator);
        } else {
            items.sort(comparator.reversed());
        }
        items.forEach(System.out::println);
    }

    //LAMBDA
    public void sortByCategory(ArrayList<ShopItem> items, Order order) {
        System.out.print("******************************************\n" +
                "-SORT items by CATEGORIES\n" +
                "******************************************\n");

        if (order.name().equals("ASC")) {
            items.sort((ShopItem item1, ShopItem item2) -> item1.getCategory().compareTo(item2.getCategory()));
        } else {
            items.sort((ShopItem item1, ShopItem item2) -> item2.getCategory().compareTo(item1.getCategory()));
        }
        items.forEach(System.out::println);
    }

    public void search(ArrayList<ShopItem> items) {
        System.out.print("******************************************\n" +
                "-FORMAL items\n" +
                "******************************************\n");

        for (ShopItem person : items) {
            if (person.getType().equals("formal")) {
                System.out.println(person.toString());
            }
        }
    }
}
