package DP.AllPalindromePartition;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllPalindromePartition {

    static int N;
    
    static List<List<String>> result; 
    static Map<String,Boolean> map;
    public static void main(String[] args) {
        String s = "aabb";
        N=s.length();
        result=new ArrayList<>();
        map = new HashMap<>();
        generatePlaindromePartition(s, new ArrayList<>());
        System.out.println(result);
    }
    public static List<String> generatePlaindromePartition(String str,List<String> res){
        
        int n = str.length();
        // if(n==1)
        //     return str;
        // if(isPalindrome(str, n-1)){
        //     return str;
        // }
        int i=1;
        while(i<=n){
            String sub = str.substring(0, i);
            List<String> li = new ArrayList<>();
            li.add(sub);
            if(map.containsKey(sub) || isPalindrome(sub, sub.length()-1)){
                map.put(sub, true);
                generatePlaindromePartition(str.substring(i,n),Stream.concat(res.stream(),li.stream()).collect(Collectors.toList()));
            }
            i++;
        }
        
        if(str=="")
            result.add(res);
        
        return res;
    }
    public static boolean isPalindrome(String str,int n){
        int i=0;
        while(i<=n){
            if(str.charAt(i)!=str.charAt(n)){
                return false;
            }
            i++;
            n--;
        }
        return true;
    }
    
}
