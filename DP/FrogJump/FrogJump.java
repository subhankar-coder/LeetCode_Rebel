package DP.FrogJump;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    static Map<String,Boolean> map ;
    public static void main(String[] args) {
        int [] stones = {0,1,3,6,10,13,14};
        map=new HashMap<>();
        System.out.println(solve(stones, 1, stones.length, 0, 1));
    //    System.out.println(solveDp(stones, stones.length));
    }
    public static boolean solve(int [] stones ,int index,int n,int lastIndex,int lastJump){
        
        String key = index+" "+lastJump;
        if(map.containsKey(key))
            return map.get(key);
        if(index==n-1 && stones[lastIndex]+lastJump==stones[index]){
            // map.put(key, true);
            return true;
        }
        
        if(stones[lastIndex]+lastJump!=stones[index]){
            // map.put(key, false);
            return false;
        }else{
            map.put(key, true);
        }
        
        for(int i=index+1;i<n;i++){
            if(solve(stones, i, n, index, lastJump-1) || solve(stones, i, n, index, lastJump) || solve(stones, i, n, index, lastJump+1)){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }
    public  static boolean solveDp(int [] stones,int n){
        if(stones[0]+1!=stones[1])
            return false;

        Value [][] dp = new Value[n-1][n-1];
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                dp[i][j]= new Value(false, -1);
            }
        }
        
        dp[0][0]=new Value(true, 1);
       
        int lastJump =1;
        boolean rechable = true;
        int lastIndex =1;
        boolean res = true;
        for(int i=0;i<n-1;i++){
        int k =i==0?0:i-1;
        while(k>=0){
            // boolean found=false;
            if(i!=0){
                lastJump=dp[k][i].lastJump;
                rechable=dp[k][i].rechable;
                lastIndex=i+1;
                }
                if(rechable){
                    for(int j=i+1;j<n-1;j++){
                        if(stones[lastIndex]+lastJump ==stones[j+1]  ){
                            dp[i][j].lastJump=lastJump;
                            dp[i][j].rechable=true;
                            // found=true;
                            // break;
                        }else if(stones[lastIndex]+lastJump+1 ==stones[j+1]){
                            dp[i][j].lastJump=lastJump+1;
                            dp[i][j].rechable=true;
                            // found=true;
                            // break;
                        }else if(stones[lastIndex]+lastJump-1 ==stones[j+1]){
                            dp[i][j].lastJump=lastJump-1;
                            dp[i][j].rechable=true;
                            // break;
                            // found=true;
                        }
                        if(j==n-2){
                            if(dp[i][j].rechable==true)    
                                return true;
                            else 
                                res=false;
                        }
                }
            }
            
            k--;
                // if(i!=0){

                //     dp[i][j].lastJump = Math.max(dp[i][j].lastJump , dp[i-1][j].lastJump);
                //     dp[i][j].rechable=dp[i][j].rechable || dp[i-1][j].rechable;
                // }
            }
        }
        for(Value [] val: dp){
            for ( Value v: val){
                System.out.print(v.toString());
            }
            System.out.println();
        }

        return res;
    }
}
class Value{
    public boolean rechable;
    public int  lastJump;

    public Value(boolean rechable,int lastJump){
        this.rechable=rechable;
        this.lastJump=lastJump;
    }

    @Override
    public String toString(){
        return this.rechable+" "+this.lastJump+"   ";
    }
}
