/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;


public class EmployeeDataBase {
    
    public EmployeeUser createRecordFrom(String line)
{
    String[] str=line.split(",");
    EmployeeUser employee=new EmployeeUser(str[0],str[1],str[2],str[3],str[4]);
    
    return employee;
}
    
}
