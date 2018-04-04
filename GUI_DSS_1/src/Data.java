
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natnaree
 */
public class Data {
    
    String personalType[] = new String [125];
    String department[] = new String [125];
    String faculty[] = new String [125];
    String program[] = new String [125];
    int totalExpense[] = new int [125];
    int math[] = new int [125];
    int english[] = new int [125];
    int physics[] = new int [125];
    int chemistry[] = new int [125];
    int biology[] = new int [125];
    
    
    public Data(){
        String csvFile = "/Users/Natnaree/DSSProject2/CareerMappingFull.csv";
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
                personalType[i] = career[0];
                department[i] = career[1];
                faculty[i] = career[2];
                program[i] = career[3];
                totalExpense[i] = Integer.parseInt(career[4]);
                math[i] = Integer.parseInt(career[5]);
                english[i] = Integer.parseInt(career[6]);
                physics[i] = Integer.parseInt(career[7]);
                chemistry[i] = Integer.parseInt(career[8]);
                biology[i] = Integer.parseInt(career[9]);
                System.out.println(personalType[i] + " " + department[i] + " " + math[i] + " " + english[i] +
                        " " + physics[i] + " " + chemistry[i] + " " + biology[i]);
                
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
    
}
