package DP.CanIWin;

import java.util.*;

public class CanIWin {
   static int [] dict;
    public static void main(String[] args) {
        
        int maxChoosableInteger=5;
        int desiredTotal=50;

        dict= new int [maxChoosableInteger+1];
        for(int i=0;i<=maxChoosableInteger;i++){
            dict[i]=i;
        }
        System.out.println(solve(maxChoosableInteger,0, desiredTotal, 0));
    }
    public static boolean solve(int maxChoosableInteger,int currentTotal ,int desiredTotal,int state){
    //    if(Arrays.stream(dict).filter(i->i>=(desiredTotal-currentTotal)).count()>0)
    //         return firstPlayer;
        boolean canWin =false;
        for(int i=1;i<=maxChoosableInteger;i++){
            if(((state>>i)&1)==0){
                if(currentTotal+i>=desiredTotal || !solve(maxChoosableInteger, currentTotal+i, desiredTotal, state | (1<<i))){
                    canWin=true;
                    break;
                }
            }
        }
        return canWin   ;
    }
}
