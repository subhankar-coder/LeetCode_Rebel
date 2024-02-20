package DP.CountTheRepetations;

import java.util.*;

public class CountTheRepetations {
    static Map<Integer,int []> map ;
    public static void main(String[] args) {
        String s1= "acb";
        int n1 = 4;
        String s2= "ca";
        int n2=1;
        map = new HashMap<>();
        countRepetations(s1,s2,n1,n2);
        // solve(s1, s2,n1,n2);

        // System.out.println(str1+"  "+str2);
    }
    public static int countRepetations(String s1,String s2,int n1,int n2){

        int len1 = s1.length();
        int len2 = s2.length();
        int j=0;
        for(int i=0;i<len2;i++){
            j=i;
            int count=0;
            for(int k=0;k<len1;k++){
                if(s1.charAt(k)==s2.charAt(j)){
                    j++;
                    if(j==len2){
                        j=0;
                        count+=1;
                    }
                }
            }
            map.put(i, new int []{j,count});
        }
        // for(Map.Entry<Integer,int [] > mp:map.entrySet()){
        //     System.out.println(mp.getKey()+"  "+Arrays.toString(mp.getValue()));
        // }
        j=0;
        int repetations =0;
        for(;n1>0;n1--){
            repetations+=map.get(j)[1];
            j=map.get(j)[0];
        }

        System.out.println(repetations);
        return repetations/n2;
    }
    public static void solve(String str1,String str2,int n1,int n2){
        
        int n = str1.length();
        int m = str2.length();
        int count =0;
        int i=0;
        int j=0;
        
        while(n2>0){
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==m){
                j=0;
                n2--;
            }
            i++;
            if(i==n){
                count++;
                i=0;
            }
        }

        count=i>0?count+1:count;
        assert count!=0;
        System.out.println(n1/count);
    }

}
