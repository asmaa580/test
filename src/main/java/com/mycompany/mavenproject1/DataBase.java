/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;


import java.util.ArrayList;
import java.io.*;


public abstract class DataBase<T extends Record>{
    
//    private ArrayList<T> records;
    private ArrayList<T> records = new ArrayList<>();
    private String filename;
    
    public abstract T createRecordFrom(String line);
    
    public void readFromFile()  
    {
         try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T record = createRecordFrom(line);  // Delegated to child class
                insertRecord(record);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    
    }
    
   
    public ArrayList<T> returnAllRecords()
    {
        return records;
    }
    
    public boolean contains(String key )
    {
       
        for(int i=0;i<records.size();i++)
        {
            if (records.get(i).getSearchKey().equals(key)) {
                return true;
            } 
        }
        return false;
    }
    
    public T getRecord(String key)
    {
         for(int i=0;i<records.size();i++)
        {
            if (records.get(i).getSearchKey().equals(key)) {
                return records.get(i);
            } 
        }
         return null;
   }

    
    public void setRecords(ArrayList<T> records) {
        this.records = records;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public void insertRecord(T record)
    {
        records.add(record);
    }
    
    public void deleteRecord(String key)
    {
        for(int i=0;i<records.size();i++)
        {
            if(records.get(i).getSearchKey().equals(key))
            {
                records.remove(i);
            }
        }
    }
    
    public void saveToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        for(int i=0;i<records.size();i++) {
            writer.write(records.get(i).lineRepresentation());
            writer.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
}
    
    
    
}