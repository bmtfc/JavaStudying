package com.company;

/*
Задано словник.  Визначити всі слова, які можуть бути поділені на частини, кожна з яких буде окремим словом у словнику.
Використати оптимальний алгоритм для аналізу слова.
Замінити шукані слова на перше слово кожного речення, у якому вони знаходяться.
 */

public class Main {
    public static void main (String[]args){
        StringWork m = new StringWork("file.txt","segmentation.txt");
        m.Work();
    }

}

