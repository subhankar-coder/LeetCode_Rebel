package BackTracking.PhoneLetterComb;

import java.util.*;

public class PhoneLetterComb {
    static Map<Integer,String> map=new HashMap<>();
    public static void main(String[] args) {
        map.put(2,"abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result=new ArrayList<>();
        String digits="23";

        if(digits.isEmpty())
            return;

        generateCombinations(digits, 0, "");
        
    }
    public static void generateCombinations(String str,int level,String res){
        if(level>=str.length()){
            System.out.println(res);
            return;
        }
            
        String currentStr=map.get(Integer.parseInt(String.valueOf(str.charAt(level))));

        if(currentStr!=null){

            for(int i=0;i<currentStr.length();i++){
                generateCombinations(str, level+1, res+String.valueOf(currentStr.charAt(i)));
            }
        }
    }
}
