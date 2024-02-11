package DP.IntegerReplacement;

import java.util.*;;
public class IntegerReplacement {
    static Map<Long,Integer> map;
    public static void main(String[] args) {
        int n = 2147483647;
        map=new HashMap<>();
        System.out.println(solve(n));
    }
    public static int solve(long n){
        if(map.containsKey(n))
            return map.get(n);
        if(n==1)
            return 0;
        int count =0;
        if(n%2==0)
            count=1+solve(n/2);
        else{
            count=1+Math.min(solve(n+1), solve(n-1));
        }
        map.put(n, count);
        return count;
    }
}
