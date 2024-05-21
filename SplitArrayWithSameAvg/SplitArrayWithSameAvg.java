package SplitArrayWithSameAvg;

import java.util.Arrays;
import java.util.HashMap;

public class SplitArrayWithSameAvg {

    public static void main(String[] args) {
        
        int [] strengths = {2,0,5,6,16,12,15,12,4};
        int n = strengths.length;
        int sum = Arrays.stream(strengths).sum();
       
        System.out.println(solve(strengths, n, 0, 0, sum, 0));
        System.out.println(solveDp(strengths, n, (float)sum));
    }
    public static boolean solve(int [] strengths,int n,int index,int sum,int total,int numOfele){
        float average = numOfele==0?0:(float)(sum)/numOfele;

        float leftOverSum=(total-sum);
        float leftOver = n==numOfele?0:leftOverSum/(n-numOfele);

        if(average==leftOver)
            return true;

        // if(numOfele>1 && average>leftOver)
        //     return false;

        for(int i=index;i<n;i++){
            if(solve(strengths, n, i+1, sum+strengths[index], total, numOfele+1))
                return true;
        }

        return false;
    }
    public static boolean solveDp(int [] strengths,int n,float sum ){
        
        int calculatedSum=0;
        int n1=-1;

        for(int i=1;i<n;i++){

            float reminder = (sum*i)%n;
            if(reminder==0){
                calculatedSum=((int)sum*i)/n;
                n1=i;
                if(isExists(strengths,n,calculatedSum,n1,0,new HashMap<>()))
                    return true;
            }
        }

        System.out.println(calculatedSum+" "+n1);

        return false;

        

        
    }
    public static boolean isExists(int [] strengths,int n,int targetSum,int targetNumber,int index,HashMap<String,Boolean> dp){

        String key=targetSum+" "+targetNumber+" "+index;

        if(dp.containsKey(key))
            return dp.get(key);

        if(index>=n){
            if(targetSum==0 && targetNumber==0)
                return true;
            dp.put(key,false);
            return false;
        }

        if(targetSum==0 && targetNumber==0){
            dp.put(key,true);
            return true;
        }
        

        if(targetSum<0 || targetNumber<0){
            dp.put(key,false);
            return false;
        }



        if(isExists(strengths,n,targetSum-strengths[index],targetNumber-1,index+1,dp)||isExists(strengths,n,targetSum,targetNumber,index+1,dp)){
            dp.put(key,true);
            return true;
        }

        dp.put(key,false);

        return false;



    }
    
}
