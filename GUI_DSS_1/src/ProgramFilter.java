/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natnaree
 */
public class ProgramFilter {
    static String program;
    
    int isSciMath;
    int isMathLang;
    int isLang;
    
    int[] departmentProgramFilteredFinal;
    
    public int[] filter(int[] department){
        
        //department = dsshome.holland.departmentFiltered;
        int[] departmentProgramFiltered = new int [department.length];
        
        
        //transform the result of X2_dssgrade from text to int
        if(program.equalsIgnoreCase("Science - Mathematics")){
            isSciMath = 1;
        }else if(program.equalsIgnoreCase("Mathematics - Art")){
            isMathLang = 1;
        }else if(program == "Languages - Art"){
            isLang = 1;
        }
        
        //filter
        int count = 0;
        for(int i = 0; i < department.length; i++){
            if(isSciMath == 1){
                if(dsshome.data.sciMath[department[i]] == isSciMath){
                    departmentProgramFiltered[count++] = department[i];
                }
            }else if(isMathLang == 1){
                if(dsshome.data.mathLang[department[i]] == isMathLang){
                    departmentProgramFiltered[count++] = department[i];
                }
            }else if(isLang == 1){
                if(dsshome.data.lang[department[i]] == isLang){
                    departmentProgramFiltered[count++] = department[i];
                }
            }
        }
        
        //fitting arrays size
        int[] departmentProgramFilteredFinal = new int [count];
        for(int i = 0; i < departmentProgramFilteredFinal.length; i++){
            departmentProgramFilteredFinal[i] = departmentProgramFiltered[i];
        }
        
        this.departmentProgramFilteredFinal = departmentProgramFilteredFinal;
        
        return departmentProgramFilteredFinal; 
    }
    
}
