package DP.ScrambledString;

import java.util.*;

public class ScrambledString {

//     static int N ;
    static Map<String,Boolean> map;
    public static void main(String[] args) {
        
        String s1="coder";
        String s2="ocred";
     //    int n=s1.length();
        map=new HashMap<>();
        System.out.println(divideAndConqure(s1,s2));
    }

    public static boolean divideAndConqure(String s1,String s2){

           int  n = s1.length();
           char [] array1= s1.toCharArray();
           char [] array2= s2.toCharArray();

           Arrays.sort(array1);
           Arrays.sort(array2);
          
           if(map.containsKey(s1+" "+s2)){
               return map.get(s1+" "+s2);
           }
           if(s1.length()!=s2.length()){
               // map.put(s1+" "+s2,false);
                return false;
           }
           if(s1.equals(s2)){
               // map.put(s1+" "+s2 ,true);
               return true;
           }
            if(s1.isEmpty() && s2.isEmpty()){
               //   map.put(s1+" "+s2, true);
                 return true;
            }
           if(!new String(array1).equals(new String(array2))){
               // map.put(s1+" "+s2, false);
                return false; 
           }

           String key = s1+" "+s2;
           boolean flag =false;

           for(int i=1;i<n;i++){
                if(divideAndConqure( s1.substring(0,i),s2.substring(0,i)) && 
                   divideAndConqure(s1.substring(i,n),s2.substring(i,n))){
                    flag=true;
                    map.put(key,flag);
                    return true;
                }
                if(divideAndConqure(s1.substring(0,i),s2.substring(n-i,n)) && 
                   divideAndConqure(s1.substring(i,n),s2.substring(0,n-i))){
                    flag=true;
                    map.put(key, flag);
                    return true;
                }
           }
          //  flag=false;

           map.put(key, flag);
           return false;
    }
    
}
