package DP.CountTheRepetations;

public class CountTheRepetations {
    public static void main(String[] args) {
        String s1= "acb";
        int n1 = 4;
        String s2= "ca";
        int n2=1;
      
        solve(s1, s2,n1,n2);

        // System.out.println(str1+"  "+str2);
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
