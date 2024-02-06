package DP.UniqueDigits;

import java.util.HashMap;
import java.util.Map;

public class UniqueDigits {
    static int count;    
    static int N ;
    static Map<String,Integer> map;
       public static void main(String[] args) {
            int n =5;
            int num =(int) Math.pow(10, n);
            count=0;
            map=new HashMap<>();
            N=n;
            solve(n, 1, "",true);
            System.out.println(num-count);
        }
        public static void solve(int n ,int digit,String prevDigits,boolean tight){
            if(prevDigits.length()>1 && prevDigits.substring(0,prevDigits.length()-1).contains(String.valueOf(digit))){
                    count+= (int)Math.pow(10, n);
                    map.put(prevDigits, count);
                    return ;
            }
            if(n==0){
                return ;
            }
            
            for(int i=9;i>=0;i--){
                if(tight && i==0){
                    solve(n-1,i,prevDigits , tight&&i==0);
                }else
                    solve(n-1, i, prevDigits+String.valueOf(i),tight&&i==0);
            }
        }
}
