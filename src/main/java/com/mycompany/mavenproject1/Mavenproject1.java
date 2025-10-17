/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;


public class Mavenproject1 {

    public static void main(String[] args) {
        EmployeeUser x=new EmployeeUser("456","malak","kfkg@gmail.com"," allam","7101018");
      EmployeeDataBase y=new EmployeeDataBase();
      y.insertRecord(x);
    y.setFilename("Employees.txt");
    y.readFromFile();
    y.saveToFile();
    
        
       System.out.println(y.contains("123"));
      y.deleteRecord("123");
        System.out.println(y.contains("123"));
    }
}
