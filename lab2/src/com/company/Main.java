package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<ShopItem> items = new ArrayList<>();
        Shop.fullFillArray(items);

        ShopItemManager manager = new ShopItemManager();

        manager.sortByBrand(items, Order.ASC);
        manager.sortByCategory(items, Order.DESC);
        manager.sortByColor(items, Order.ASC);
        manager.sortByPrice(items, Order.DESC);

        manager.search(items);
    }

}
