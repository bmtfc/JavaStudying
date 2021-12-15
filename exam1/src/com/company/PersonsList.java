package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PersonList{
    private ArrayList<String> data;

    public PersonList(){
        data = new ArrayList<>();
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public void ReadFromFile(){

        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Print(){
        System.out.println(data);
    }

    public void SortBySurname(){
        Collections.sort(data);
    }

    public void ToMap(){

    }

    public void WriteToFile(){
        BufferedWriter bw = null;
        try {
            File file = new File("src/output.txt");


            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (String datum : data) {
                bw.write(datum);
                bw.write('\n');
            }
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

    public void DoWork(){
        this.ReadFromFile();
        this.Print();
        this.SortBySurname();
        this.Print();
        this.ToMap();
        this.WriteToFile();
    }
}