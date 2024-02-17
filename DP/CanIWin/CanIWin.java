package DP.CanIWin;

import java.util.*;

public class CanIWin {
    static List<Integer> dict;
    public static void main(String[] args) {
        
        int maxChoosableInteger=10;
        int desiredTotal=40;

        dict= new ArrayList<>();
        for(int i=1;i<=maxChoosableInteger;i++){
            dict.add(i);
        }
        System.out.println(solve(maxChoosableInteger, desiredTotal, true));
    }
    public static boolean solve(int maxChoosableInteger,int desiredTotal,boolean firstPlayer){
        if(firstPlayer && dict.stream().filter(i->i>=desiredTotal).count()>=1)
            return true;

        if(!firstPlayer && dict.stream().filter(i->i>=desiredTotal).count()>=1)
            return false;

        for(int i=maxChoosableInteger;i>=1;i--){
            if(dict.contains(i)){
                dict.remove(dict.indexOf(i));
                if(solve(maxChoosableInteger, desiredTotal-i, !firstPlayer)){
                    return true;
                }
                dict.add(i);
            }
        }
        return false;
    }
}
