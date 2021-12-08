package main.java.com.company;
import com.company.WordsManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordsManagerTest {

    @Test
    void splitStringIntoSentences() {
        ArrayList<String> l1 = new ArrayList<>(WordsManager.SplitStringIntoSentences("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec vulputate lectus."));
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        l2.add(" Donec nec vulputate lectus.");
        Assert.assertArrayEquals(l2.toArray(),l1.toArray());
    }

    @Test
    void getSecondLastWords() {
        String[] arr = {"adipiscing", "vulputate"};
        ArrayList<String> l1 = new ArrayList<>( WordsManager.SplitStringIntoSentences("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec nec vulputate lectus."));
        ArrayList<String> l2 = new ArrayList<>(WordsManager.GetSecondLastWords(l1));
        Assert.assertArrayEquals(arr,l2.toArray());
    }
}