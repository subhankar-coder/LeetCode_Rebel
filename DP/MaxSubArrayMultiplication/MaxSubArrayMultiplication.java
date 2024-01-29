/* 
 * For getting the max Multiplication of a the contiguous subarray  ([-3,-3,-6,-1,-5,2])
 * The idea is to keep track of 3 variables
 * 
 * maxUptoNow - That holds the maximum multiplication we have seen till now 
 * minTillNow - That holds the min multiplications we have seen till now (i.e negetive multiplication )
 * maxoverall - That is our final ans.(i.e. the max subarray multiplication) 
 * 
 * Now initially all the variables are marked as array[0]
 * Starting from i=1 to n ,we take maximum of continuous multiplication of the subarray elements upto i 
 * and ith ele (Math.max(maxUptoNow*array[i],array[i])). 
 * 
 * maxUptoNow = (-3*-3,-3)=9, max(9,-3)=9, max(9*-6,-6,-3*-6)=18 , max(-54*-1,-1)=54
 * 
 * 
 * we also check if the product of the array[i] and minTillNow is greater than the maxUptoNow (i.e. maxUptoNow=Math.max(minTillNow*array[i], maxUptoNow))
 * because if the current element is negetive and the minTillNow is also negetive there  product would be positive and its possible 
 * that the  value is greater than the maxUptoNow.
 * 
 * Now minTillNow variable can be updated as the minimum between the  product of the continuous 
 * array product from the last minimun and the current array element (i.e. Math.min(array[i]*minTillNow, array[i]))
 * 
 * also we update the minTillNow as the  min of product of the maxUptoNow (before updating the maxUptoNow )
 * and array[i] (i.e. minTillNow=Math.min(maxDup*array[i], minTillNow))
 * 
 *  minTillNow = min(-3*-3,-3)=-3 , min(-6*9,-6 ,-3*-6)=-54
 */




package DP.MaxSubArrayMultiplication;

public class MaxSubArrayMultiplication {

    public static void main(String[] args) {
        int [] array = {-3 ,-3, -6, -1, -5, 2};
        int n = array.length;

        int maxUptoNow = array[0];
        int maxOverall = array[0];

        int minTillNow = array[0];

        for(int i=1;i<n;i++){
            
            
            int maxDup = maxUptoNow;

            maxUptoNow= Math.max(maxUptoNow*array[i], array[i]);
            maxUptoNow=Math.max(minTillNow*array[i], maxUptoNow);
            minTillNow=Math.min(minTillNow*array[i], array[i]);
            minTillNow=Math.min(maxDup*array[i], minTillNow);
            maxOverall=Math.max(maxOverall, maxUptoNow);
            // maxOverall=Math.max(maxOverall, minTillNow);
        }

        System.out.println(maxOverall);
    }
    
}
