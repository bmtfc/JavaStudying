package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HomeApplianceList {
    private final LinkedList<HomeAppliance> list = new LinkedList<>();

    public HomeApplianceList(){};

    public HomeApplianceList(HomeApplianceList l1, HomeApplianceList l2){
        list.addAll(l1.list);
        list.addAll(l2.list);
        list.sort(new HomeAppliance.InnerComparator());
    }

    public void PrintSize(){
        System.out.println( list.size());
    }

    public void PrintSumPrice(){
        double sum_price = 0;
        for (HomeAppliance HomeAppliance : list) {
            sum_price += HomeAppliance.getPrice();
        }
        System.out.println(sum_price);
    }

    public void Print() {
        list.forEach(System.out::println);
    }

    public void ReadFromFile(String file_name) {
        try {
            FileInputStream fis = new FileInputStream(file_name);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                Scanner wc = new Scanner(sc.nextLine());
                list.add(new HomeAppliance(wc.next(), wc.next(), wc.next(), wc.nextDouble(), wc.nextInt()));
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PrintManufacturersModelsMap(int n){
        HashMap<String,String> map = new HashMap<>();

        HashSet<String> set = new HashSet<>();
        for (HomeAppliance HomeAppliance : list) {
            set.add(HomeAppliance.getManufacturer());
        }
        for (String value : set) {
            LinkedList<String> temp_list = new LinkedList<>();
            for (HomeAppliance HomeAppliance : list) {
                if (Objects.equals(value, HomeAppliance.getManufacturer())) {
                    temp_list.add(HomeAppliance.getModel());
                }
            }
            List<String> temp_list_first_n = temp_list.stream().limit(n).collect(Collectors.toList());
            map.put(value, temp_list_first_n.toString());
            temp_list.clear();
        }
        System.out.println(map);
    }

    public void PrintNameFrequency(){
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (HomeAppliance HomeAppliance : list) {
            set.add(HomeAppliance.getName());
        }
        for (String s : set) {
            int count = 0;
            for (HomeAppliance HomeAppliance : list) {
                if (Objects.equals(s, HomeAppliance.getName()))
                    count++;
            }
            map.put(s, count);
        }
        System.out.println(map);
    }


}
