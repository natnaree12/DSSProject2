/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natnaree
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WeaknessScore {
    
    static int[] subjectWeak = new int [5];
    //subjectWeak[0] = math
    //
    
    
    String department[] = new String [48]; //primary key
    int tuitionFee[] = new int [48];
    int math[] = new int [48];
    int english[] = new int [48];
    int physics[] = new int [48];
    int chemistry[] = new int [48];
    int biology[] = new int [48];
    
    
    public WeaknessScore(){
        String csvFile = "/Users/Natnaree/DSSProject2/CareerMapping.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        //String path = "/Users/Natnaree/DSSProject2/CareerMapping.csv";
        //File file = new File(path);
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            int i = 0;
  
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] career = line.split(cvsSplitBy);
                department[i] = career[0];
                tuitionFee[i] = Integer.parseInt(career[1]);
                english[i] = Integer.parseInt(career[2]);
                physics[i] = Integer.parseInt(career[3]);
                chemistry[i] = Integer.parseInt(career[4]);
                biology[i] = Integer.parseInt(career[5]);
                System.out.println(department[i] + " - " + tuitionFee[i]);
                
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public String sort(int[] weak){
        subjectWeak = weak;
        
        int[] score = new int [47];
        for(int i = 1; i < 48; i++){
            if(weak[0] == 1) score[i] *= math[i];
            if(weak[1] == 1) score[i] *= english[i];
            if(weak[2] == 1) score[i] *= physics[i];
            if(weak[3] == 1) score[i] *= chemistry[i];
            if(weak[4] == 1) score[i] *= biology[i];
        }
        
        int first = score[0];
        String firstDep = department[0];
        for(int i = 2; i < 48; i++){
           if(score[i] < first){
               first = score[i];
               firstDep = department[i];
           }
        }   
        return firstDep;
    }
    
    public void insertionSort(int arr[])
    {
       int i, key, j;
       for (i = 1; i < arr.length; i++)
       {
           key = arr[i];
           j = i-1;

           /* Move elements of arr[0..i-1], that are
              greater than key, to one position ahead
              of their current position */
           while (j >= 0 && arr[j] > key)
           {
               arr[j+1] = arr[j];
               j = j-1;
           }
           arr[j+1] = key;
       }
    }
    
    
}
