package DP.CoinChange;

import java.util.*;

public class CoinChange {


    public static void main(String[] args) {
        int [] coins={1,2,5};
        int amount = 11;
        coins=Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        int dp [] = new int[amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int min=getMinCoins(dp,coins,amount);
        System.out.println(Arrays.toString(dp));
        
    }

    public static int getMinCoins(int [] dp,int [] coins,int amount){
        if(amount==0)
            return 0;
        if(dp[amount]!=-1)
            return dp[amount];

        int res = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                int sub_res= getMinCoins(dp, coins, amount-coins[i]);

                if(sub_res!=Integer.MAX_VALUE && sub_res+1<res)
                    res=sub_res+1;
            }
        }
        dp[amount]=res;
        return res;
    }
}
