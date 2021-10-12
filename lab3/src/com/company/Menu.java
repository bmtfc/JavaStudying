package com.company;

import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    public void Run(){

        HomeApplianceList l1 = new HomeApplianceList();
        l1.ReadFromFile("data.txt");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Створити карту з ключем -виробник  та значенням –списку назв моделей.\n    Видрукувати з кожного списку тільки n перших позицій цього списку.");
            System.out.println("2 - Знайти частотну характеристику різних назв.");
            System.out.println("3 - З 2 різних файлів зчитати 2 вихідні набори інформації про прилади. Створити спільну колекцію,\n   відсортовану в зворотному порядку відносно вартості, без дозволу її модифіковувати.\n   Використовуючи стандартний метод, знайти кількість автомобілів, сумарну вартість всіх приладів.");
            System.out.println("0 - Вийти з програми.");
            Scanner keyboard = new Scanner(System.in);
            int opt = keyboard.nextInt();
            switch (opt) {
                case 1: {
                    System.out.println("Введіть к-сть позицій у списку :");
                    int n = keyboard.nextInt();
                    l1.PrintManufacturersModelsMap(n);
                    break;
                }
                case 2:{
                    l1.PrintNameFrequency();
                    break;
                }
                case 3:{
                    HomeApplianceList l21 = new HomeApplianceList();
                    l21.ReadFromFile("data1.txt");
                    HomeApplianceList l22 = new HomeApplianceList();
                    l22.ReadFromFile("data2.txt");
                    final HomeApplianceList l2 = new HomeApplianceList(l21, l22);
                    l2.Print();
                    l2.PrintSize();
                    l2.PrintSumPrice();
                    l2.ReadFromFile("data.txt");
                    break;
                }
                case 0:
                    exit(0);
            }

        }
    }
}
