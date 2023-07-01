package Recursion.LCS;

public class LCSRecursion {
    public static void main(String[] args) {
        String s1="AGGTAB";
        String s2 ="GXTYAYB";
        int len1= s1.length();
        int len2 = s2.length();
        System.out.println(lcs(s1,s2,len1,len2));
    }
    public static int lcs(String s1, String s2,int len1,int len2){
        
        if (len1==0 || len2==0){
            return 0;
        }
        if (s1.charAt(len1-1)==s2.charAt(len2-1)){
            return 1+lcs(s1,s2,len1-1,len2-1);
        }else{
            return max(lcs(s1, s2, len1-1, len2) ,lcs(s1, s2, len1, len2-1));
        }
    }
   static  int max(int a,int b){
        return a>b ?a:b;
    }
}
