package com.company;
import java.util.*;

public class Shop {
    static public void fullFillArray(ArrayList<ShopItem> items){
        items.add(new Shoes((Float.parseFloat("543.23")), "informal", "yellow", "Adidas", "Ultraboost", "Sport Sneakers", Float.parseFloat("44")));
        items.add(new Shoes((Float.parseFloat("201.50")), "informal", "green", "Nike", "Stan Smith", "Sport Sneakers", Float.parseFloat("42")));
        items.add(new Shoes((Float.parseFloat("672.17")), "informal", "black", "Reebok", "Superstar", "Sport Sneakers", Float.parseFloat("39")));

        items.add(new Shoes((Float.parseFloat("932")), "formal", "gray", "Timberland", "Chelsea", "CLSC Boots", Float.parseFloat("41")));
        items.add(new Shoes((Float.parseFloat("1024")), "formal", "black", "Zanzara", "Cole Ha", "Loafers", Float.parseFloat("45")));
        items.add(new Shoes((Float.parseFloat("761")), "formal", "black", "Penttatin", "Verke", "Moccasins", Float.parseFloat("42")));

        items.add(new Tops((Float.parseFloat("212.20")) , "informal", "white", "Adidas", "Blogedemash", "Loungewears WS", "L"));
        items.add(new Tops((Float.parseFloat("456")), "informal", "purple", "Balenca", "Glammorcan", "Loungewears WS", "XS"));
        items.add(new Tops((Float.parseFloat("673.99")), "informal", "yellow", "Nike", "Shmoofoil", "T-Shirts Man", "M"));

        items.add(new Tops((Float.parseFloat("891.50")), "formal", "black", "Tom Ford", "La Greca", "Shirts WS", "XL"));
        items.add(new Tops((Float.parseFloat("643.99")), "formal", "gray", "Versace", "Medusa", "Jackets", "M"));
        items.add(new Tops((Float.parseFloat(" 1031.99")), "formal", "gray", "Versace", "Barocco", "Sleeveless", "XL"));
    }
}
