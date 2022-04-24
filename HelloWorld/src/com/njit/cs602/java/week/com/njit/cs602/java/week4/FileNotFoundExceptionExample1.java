package com.njit.cs602.java.week4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFoundExceptionExample1   
{  
    public static void main(String[] args) throws IOException   
    {  
         
         try {  
             FileReader fileReader = new FileReader("T:\\NJIT startup\\Semester 1\\CS602_Java\\week1\\hello1.txt");  
             BufferedReader bufferReader = new BufferedReader(fileReader);  
             String fileData = null;  
             while ((fileData = bufferReader.readLine()) != null)   
             {  
                 System.out.println(fileData);  
             }  
            bufferReader.close();  
        } catch (FileNotFoundException f) {
        	System.out.println("This file is not present here.");
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
    }  
}  
