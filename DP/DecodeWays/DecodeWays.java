package DP.DecodeWays;

import java.util.*;
public class DecodeWays {
    static List<String> dict= new ArrayList<>();
    static int count=0;
    public static void main(String[] args) {
        
        for(int i=1;i<=26;i++){
            dict.add(String.valueOf(i));
        }
        String str= "3123";
        getWays(str, "");
        System.out.println(count);
    }
    public static void getWays(String str,String res){

        int n = str.length();
        if(str.isEmpty()){
            System.out.println(res);
            count++;
        }

        for(int i=1;i<=n;i++){
            if(dict.contains(str.substring(0, i)))
                getWays(str.substring(i, n), res+"->"+str.substring(0,i));
        }
    }
}
