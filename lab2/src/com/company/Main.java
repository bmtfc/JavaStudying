package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();
        Shop shop = new Shop();
        shop.fillItemArrayList(items);
        ItemManager itemManager = new ItemManager();
        System.out.println("Unsorted array: ");
        itemManager.printItemArrayList(items);
        System.out.println();
        itemManager.sortByName(items, Order.ASC);
        System.out.println("Sorted by name in ascending order: ");
        itemManager.printItemArrayList(items);
        System.out.println();
        itemManager.sortByNameLambda(items, Order.DESC);
        System.out.println("Sorted by name in descending order: ");
        itemManager.printItemArrayList(items);
        System.out.println();
        System.out.println("Sorted by price in ascending order: ");
        itemManager.sortByPriceInner(items, Order.ASC);
        itemManager.printItemArrayList(items);
        System.out.println();
        itemManager.sortByPriceAnonymous(items, Order.DESC);
        System.out.println("Sorted by price in descending order: ");
        itemManager.printItemArrayList(items);
        System.out.println();
        System.out.println("Sorted by sport name in ascending order: ");
        itemManager.sortBySportName(items, Order.ASC);
        itemManager.printItemArrayList(items);
        System.out.println();
        itemManager.searchBySportType(items, "scuba diving");
    }
}
