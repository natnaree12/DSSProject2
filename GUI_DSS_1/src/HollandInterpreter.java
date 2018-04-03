/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natnaree
 */
public class HollandInterpreter {
    static int answer[] = new int [48];
    int[] codeKey = new int [48];
    int[] code = new int [6];
    
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
//            if(i%6 == 0) codeKey[i] = 0;
//            else if(i%6 == 1) codeKey[i] = 1;
//            else if(i%6 == 2) codeKey[i] = 2;
//            else if(i%6 == 3) codeKey[i] = 3;
//            else if(i%6 == 4) codeKey[i] = 4;
//            else codeKey[i] = 5;
        }
    }
    
    public int[] countAns(int[] ans){
        answer = ans;
        for(int i = 0; i < 48; i++){
            if(ans[i] == 1) code[codeKey[i]]++;
        }
        
        return code;
    }
    
    public char interprete(int[] code){
        this.code = code;
        int max = code[0];
        int maxCode = 0;
        char result = 'X';
        for(int i = 1; i < 48; i++){
            if(code[i] > max){
                max = code[i];
                maxCode = i;
            }
        }
        if(maxCode == 0) result = 'R';
        else if(maxCode == 1) result = 'I';
        else if(maxCode == 2) result = 'A';
        else if(maxCode == 3) result = 'S';
        else if(maxCode == 4) result = 'E';
        else if(maxCode == 5) result = 'c';
        
        return result;
    }
   
}
