package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManager {
    private ArrayList<String> list;

    public StringManager(){
        list = new ArrayList<String>();
    }

    public static String GetDataFromFile(String path) {
        String data = null;
        File dataFile = new File(path);
        if(dataFile.exists()){
            try {
                data = Files.readString(Path.of(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("File does not exist.");
            return null;
        }
        return data;
    }

    public void SplitStringIntoSentences(String data) {
        if( !data.isEmpty()) {
            String pattern = "([^.?!]*)[.?!]";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(data);
            while (m.find()) {
                list.add(m.group());
            }
        }
        else{
            System.out.println("File is empty.");
        }
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public String ThreadWork(int begin, int end){
        String out = "";
        ArrayList<String> stringList = new ArrayList<>();
        String pattern = "/(\\b[A-Z][A-Z]+|\\b[A-Z]\\b)/g";
        Pattern r = Pattern.compile(pattern);
        for(int i=begin; i<end; i++){
            Matcher m = r.matcher(list.get(i));
            out = out.concat("Sentence number #");
            out = out.concat(Integer.toString(i+1));
            out = out.concat("\n");
            int numberOfWords = 0;
            while (m.find()) {
                out = out.concat(m.group());
                out = out.concat(" ");
                numberOfWords++;
            }
            out = out.concat("Number of words: ");
            out = out.concat(Integer.toString(numberOfWords));
            out = out.concat("\n");
        }
        return out;
    }

    public void WorkWithStrings() throws ExecutionException, InterruptedException {
        SplitStringIntoSentences(GetDataFromFile("src/input.txt"));
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number of threads");
        int n = myObj.nextInt();
        int temp = 0;
        //System.out.println(n);
        ArrayList<Integer> sentences = new ArrayList<>();
        System.out.printf("Enter number of sentences, sum of numbers must be < %d \n", list.size()-1);
        for (int i = 0; i < n-1; i++){
            System.out.println("Enter number of sentences for thread");
            int x = myObj.nextInt();
            sentences.add(x);
            temp += x;
        }
        sentences.add(list.size()-temp);
        //System.out.println(sentences);
        ExecutorService executor = Executors.newFixedThreadPool(n);
        List<Callable> threads = new ArrayList<>();
        int temp2 = 0;
        for (int i=0; i < sentences.size(); i++){
            int finalI = i;
            threads.add(()->ThreadWork(temp2, temp2+sentences.get(finalI)));
        }

        for (Callable c: threads){
            Future future = executor.submit(c);
            System.out.println( future.get());
        }
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
