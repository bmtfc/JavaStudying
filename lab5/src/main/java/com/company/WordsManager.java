package main.java.com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordsManager {

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

    public static List<String> SplitStringIntoSentences(String data) {
        if( !data.isEmpty()) {
            String pattern = "([^.?!]*)[.?!]";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(data);
            ArrayList<String> stringList = new ArrayList<>();
            while (m.find()) {
                stringList.add(m.group());
            }
            return stringList;
        }
        else{
            System.out.println("File is empty.");
            return null;
        }
    }

    public static List<String> GetSecondLastWords(List<String> data) {
        if(! data.isEmpty()) {
            ArrayList<String> stringList = new ArrayList<>();
            String pattern = "\\w(?<!\\d)[\\w'-]*";
            Pattern r = Pattern.compile(pattern);
            for (String currentString : data) {
                Matcher m = r.matcher(currentString);
                ArrayList<String> wordsList = new ArrayList<>();
                while (m.find()) {
                    wordsList.add(m.group());
                }
                if(!wordsList.isEmpty())
                    stringList.add(wordsList.get(wordsList.size() - 2));
            }
            if(!stringList.isEmpty())
                return stringList;
            else{
                System.out.println("There are no words in file.");
                return null;
            }
        }
        else{
            return null;
        }
    }

    public static void DoWork(String path) {
        try {
            ArrayList<String> words = new ArrayList<>(WordsManager.GetSecondLastWords(WordsManager.SplitStringIntoSentences(WordsManager.GetDataFromFile(path))));
            if(!words.isEmpty()) {
                for (String word : words)
                    System.out.println(word);
            }
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }

}
