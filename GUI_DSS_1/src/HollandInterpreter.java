/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natnaree
 */
import java.util.ArrayList;

public class HollandInterpreter {
    static int answer[] = new int [48];
    int[] codeKey = new int [48];
    int[] code = new int [6];
    String result;
    int[] departmentFiltered;
    ArrayList<String> departmentFiltered2 = new ArrayList <String> ();
    
    public HollandInterpreter(){
        for(int i = 0; i < 48; i++){
            int n = i%6;
            switch(n){
                case 0: codeKey[i] = 0; break;
                case 1: codeKey[i] = 1; break;
                case 2: codeKey[i] = 2; break;
                case 3: codeKey[i] = 3; break;
                case 4: codeKey[i] = 4; break;
                case 5: codeKey[i] = 5; break;
            }
            //System.out.println("codeKey[" + i + "] = " + codeKey[i]);
        }
    }
    
    public int[] countAns(int[] ans){
        answer = ans;
        for(int i = 0; i < 48; i++){
            if(ans[i] == 1) code[codeKey[i]]++;
        }
        
        return code;
    }
    
    public void interprete(int[] code){
        this.code = code;
        int max = code[0];
        int maxCode = 0;
        for(int i = 1; i < 6; i++){
            if(code[i] > max){
                max = code[i];
                maxCode = i;
            }
        }
        if(maxCode == 0) result = "Realistic";
        else if(maxCode == 1) result = "Investigative";
        else if(maxCode == 2) result = "Artistic";
        else if(maxCode == 3) result = "Social";
        else if(maxCode == 4) result = "Enterprising";
        else if(maxCode == 5) result = "Conventional";
        
        this.result = result;
    }
    
    public int[] filter(){ //return index that are match the the result type
        
        int departmentFiltered[] = new int [32];
        
        if(this.result.equalsIgnoreCase("Realistic")) departmentFiltered = new int [28];
        else if(this.result.equalsIgnoreCase("Investigative")) departmentFiltered = new int [32];
        else if(this.result.equalsIgnoreCase("Artistic")) departmentFiltered = new int [15];
        else if(this.result.equalsIgnoreCase("Social")) departmentFiltered = new int [17];
        else if(this.result.equalsIgnoreCase("Enterprising")) departmentFiltered = new int [7];
        else if(this.result.equalsIgnoreCase("Conventional")) departmentFiltered = new int [26];
        
        int count = 0;
        for(int i = 0; i < 125; i++){
            if(dsshome.data.personalType[i].equalsIgnoreCase(result)){
                departmentFiltered[count++] = i;
            }
        }
        
        this.departmentFiltered = departmentFiltered;
        
        return departmentFiltered;
    }
    
    public ArrayList<String> filter2(){ //return index that are match the the result type
        
        
        for(int i = 0; i < 125; i++){
            if(dsshome.data.personalType[i].equalsIgnoreCase(result)){
                departmentFiltered2.add(i+"");
            }
        }
        
        return departmentFiltered2;
    }
   
}
