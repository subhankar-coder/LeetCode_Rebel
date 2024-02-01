/*
 *                                          Naive approach 
 *  
 *   we can traverse form [0 to n] ,
 *   For each i in range [0,n] we can convert the i to string and count total numbers of 1 in it and store it to some variable
 *   so, result = result+numOfOne(i)
 *  
 *                                          Digit Dp approach(memorization)
 * 
 *   instead of thinking the number n as a int, we can think it as an array of length len(n), i.e. 213 --> [2,1,3]
 *   now there can be 0 to 9 numbers for the each filed of the array we can change the number of the array elements s.t
 *   the corresponding number of the array [] is less than equals to the number n 
 *   (i.e.    13 -> [1,3]  can be writtern as below  
 *  
 *                      [0,0]   
 *                      [0,1]
 *                         .
 *                         .
 *                      [1,0]
 *                      [1,1]
 *                      [1,2]
 *                      [1,3]
 *    )
 * 
 *    Now for each change at the ith position of the array[] , we can change the (i+1 ... n-1) positions from 0-9
 *    s.t the resulting number is less than equals the number n . 
 * 
 *    if we reach the last element of the array [] then we will return 1 if the last element is 1 , we return  0.
 *    and store the result in a dp [n][digit][tight] ---->(n length , 0-9 numbers, 0/1 that says wheather we are at the boundary or not)
 *    
 *    if we encounter an one in the array we will make countOfOne = countOfOne+1 for the next elements and will add keep on 
 *    increasing the counter as we go more into the array [], and will generate every element from [0 to n ] and there corresponding 
 *    number of ones to dp , while recuring if see the dp[n][digit][tight] then we will return the value
 * 
 *                                    
 *                                       Numerical Math problem
 *    
 *    if we watch closer ,    number of one in each interval of power 10
 *                                          
 *                                         10---> 1     
 *                                         100--->20     
 *                                         1000-->300
 *                                         10000-->4000
 * 
 *   so , for each  n=[0,1,2...], number = n*10^(n-1);
 * 
 *    To solve a number lets say, 253, we can observe the following .......
 * 
 *   253 - > [2,5,3]  for, each element of the array we can see the max power of 10 is in the number (i.e 253 --> 200+50+3 )
 *              so , 200 --> 2*100 
 *                                            
 *                       max 1s in the range = 100( 100 number of 1s (100->199 ) )+ 2*20(from 0 to 100 there are 20 1s) ........[ form the eq n*10^(n-1)] 
 * 
 * 
 *                      50 ----> 5*10 
 *                              similarly , max no of 1s in this range = 10 (for 11 to 19)+ 5*1 (from 0 10 there is only one 1)
 * 
 *                      3-------> 3*1
 *                             for , 0 to 10 only single one.
 * 
 * 
 * 
 *    But the scenario changes when we see digit , 1 in the array,
 * 
 *    let's say for , 113 --->[1,1,3] ---> 1*100 + 1*10+ 3*1;
 *   
 *    so, there are 13 elements gt 100 hence total num of 1 , 
 *    for the numbers of >=100 = 13+1 ( 113-100=13 + 1 (for the number 100) )= 14 + 20( for 0 10 100)= 34 ,
 * 
 *    similarly, for 13 ---> number of 1s more than equals 10 =3+1=4 + number of 1s upto 10 =1----> 5  
 *    and for 3 its --->1 , 
 * 
 *   so the total sum =  34+5+4 = 40
 */



package DP.NumberOfDigitOne;

public class NumberOfDigitOne {

    static int res=0;
    static int dp[][][];
    public static void main(String[] args) {

        int s = 11;
        System.out.println(numberOfDigitOneMath(s));
        
        String str = "11";
        int n = str.length();
        dp=new int [n+1][10][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=9;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
       solve(str, n,0,0,1);
       System.out.println(res);
    }
    public static int solve(String str,int n ,int digit,int countOne,int tight){
        
        if(dp[n][digit][tight]!=-1)
            return dp[n][digit][tight];
        if(n==0){
            if(digit==1 ){
                if(dp[n][digit][tight]==-1)
                    dp[n][digit][tight]=1;
                return 1;
            }
            if(dp[n][digit][tight]==-1)
                dp[n][digit][tight]=0;
            return 0;
        }

        int ub = tight ==1?Integer.parseInt(str.substring(str.length()-n,str.length()-n+1)):10;
        if(digit==1)
         countOne+=1;
       int ans=0;
        for(int i=0;i<=ub;i++){
            tight= i==ub?1:0;
            ans =countOne;
            ans+=solve(str, n-1, i ,countOne,   tight==1?1:0);
            if(dp[n-1][i][tight]==-1 && ans>0)
                dp[n-1][i][tight]=ans;
            if(ans>=0)
                res+=ans;
            if(i==9)
                break;
        }
        // System.out.println(ans);
        return -10;
    }

    public static int numberOfDigitOneMath(int  s){

        int dupstr = s;
        if(s==0 )
            return 0;
        if(s>=1 && s<=9)
            return 1;

        int factor = 10;
        int count=0;
        int res=0;
        while(s>0){
            int mod = s%factor;
            if(mod==0){
                s=s/10;
                count++;
                continue;
            }else if(count==0){
                res+=1;
            }else if(mod==1){

                res+=(((dupstr%Math.pow(factor, count+1)-Math.pow(factor, count))+1 )+count*(Math.pow(factor,count-1)));
            }else{
                res+= Math.pow(factor, count)+mod*(count*(Math.pow(factor, count-1))); 
            }

            s=s/10;
            count++;
        }

        return res;
    }
     
}