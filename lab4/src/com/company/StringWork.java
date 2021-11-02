package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.BreakIterator;
import java.util.*;

public class StringWork {
    private Set<String> dictionary;

    private static  String input = "file.txt";
    private static  String output = "segmentation.txt";

    // clear the content of the output file
    private void clearOutputFile () {
        try {
            Path filePath = Paths.get(output);
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringWork() {
        dictionary = new HashSet<String>();
        clearOutputFile();
    }

    public StringWork(String input, String output) {
        StringWork.input = input;
        StringWork.output = output;
        dictionary = new HashSet<String>();
        clearOutputFile();
    }

    public void Work(){
        String text = this.readFile(input);
        this.addWordsToDictionary(text);
        this.processText(text);
    }

    // convert text to a list of sentences
    public List<String> getSentences (String text){
        List<String> sentences = new LinkedList<String>();

        BreakIterator bi = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        bi.setText(text);
        int start = 0;
        int end = 0;
        while ((end = bi.next()) != BreakIterator.DONE) {
            sentences.add(text.substring(start, end));
            start = end;
        }

        return sentences;
    }

    // convert a sentence into a list of words
    public List<String> getWords (String sentence){
        List<String> words = new LinkedList<String>();

        BreakIterator bi = BreakIterator.getWordInstance(Locale.ENGLISH);
        bi.setText(sentence);
        int start = 0;
        int end = 0;
        while ((end = bi.next()) != BreakIterator.DONE) {
            words.add(sentence.substring(start, end));
            start = end;
        }

        return words;
    }

    // add all words from a text to the dictionary
    public void addWordsToDictionary (String text){
        List<String> sentences = getSentences(text);

        for (String sentence : sentences) {
            List<String> words = getWords(sentence);

            for (String word : words) {
                dictionary.add(word.toLowerCase());
            }
        }
    }

    // process text (output processed sentences)
    public void processText (String text){
        List<String> sentences = getSentences(text);

        for (String sentence : sentences) {
            String processedSentence = processSentence(sentence);

            // output the updated sentence
            System.out.print(processedSentence);
        }
    }

    // process a sentence (break into words, replace with a first word, output possible segmentations)
    public String processSentence (String sentence){
        String processedSentence = new String(sentence);
        List<String> words = getWords(sentence);

        // store the first word in a variable
        String firstWord = new String(words.get(0));
        for (String word : words) {
            // check if a word can be divided into separate words
            List<String> separated = breakIntoWords(word);
            if (separated != null) {
                // replace the word with the first word of the sentence
                processedSentence = replaceWord(processedSentence, word, firstWord);

                // output the word and all of its possible segmentations into the file
                outputSegmentationPair(word, separated, output);
            }
        }

        return processedSentence;
    }

    // replace a word in a sentence
    public String replaceWord (String sentence, String originalWord, String updatedWord){
        String updatedSentence = sentence;

        BreakIterator bi = BreakIterator.getWordInstance(Locale.ENGLISH);
        bi.setText(sentence);
        int start = 0;
        int end = 0;
        while ((end = bi.next()) != BreakIterator.DONE) {
            String nextWord = sentence.substring(start, end);
            if (nextWord.equalsIgnoreCase(originalWord)) {
                updatedSentence = updatedSentence.substring(0, start) + updatedWord
                        + updatedSentence.substring(end, sentence.length());
                break;
            }
            start = end;
        }

        return updatedSentence;
    }

    // break a word into a list of smaller words
    public List<String> breakIntoWords (String word){
        List<String>[] indexes = new ArrayList[word.length() + 1];
        indexes[0] = new ArrayList<String>();

        for (int i = 0; i < word.length(); i++) {
            if (indexes[i] != null) {
                for (int j = i + 1; j <= word.length(); j++) {
                    String part = word.substring(i, j).toLowerCase();
                    if (dictionary.contains(part)) {
                        if (indexes[j] != null) {
                            indexes[j].add(part);
                        } else {
                            List<String> list = new ArrayList<String>();
                            list.add(part);
                            indexes[j] = list;
                        }
                    }
                }
            }
        }

        if (indexes[word.length()] != null) {
            List<String> res = new ArrayList<String>();
            recoverPath(indexes, res, "", word.trim(), word.length());
            if (res.size() < 1) {
                return null;
            }
            return res;
        }

        return null;
    }

    // recover the path using the 'indexes' array (get a resulting list)
    public void recoverPath (List < String >[]indexes, List < String > res, String currentWord, String originalWord,
                             int i){
        if (i == 0) {
            if (!originalWord.equalsIgnoreCase(currentWord.trim())) {
                res.add(currentWord.trim());
            }
            return;
        }

        for (String s : indexes[i]) {
            String combined = s + " " + currentWord;
            recoverPath(indexes, res, combined, originalWord, i - s.length());
        }
    }

    // read text from a file
    public String readFile (String fileName){
        String text = null;

        try {
            text = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    // output the original word and the ways it may be broken into smaller words
    public void outputSegmentationPair (String word, List < String > separated, String fileName){
        StringBuilder output = new StringBuilder();
        Path filePath = Paths.get(fileName);

        output.append(word + " - ");
        for (String part : separated) {
            output.append(part + ", ");
        }
        output = new StringBuilder(output.substring(0, output.length() - 2));
        output.append("\n");

        try {
            Files.writeString(filePath, output, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
