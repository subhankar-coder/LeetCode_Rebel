package SumOfBitString;

/**
 * SumOfBitString
 */
public class SumOfBitString {

    public static void main(String[] args) {
        String str1="1010";
        String str2= "1011";

        addStrings(str1,str2);


    }
    public static void addStrings(String str1,String str2){
        int m=str1.length();
        int n = str2.length();
        if(m<n)
            addStrings(str2, str1);

        int i =m-1;
        int j=n-1;
        int carry=0;
        String res ="";
        while (i>=0) {
            int a=Integer.valueOf(str1.substring(i, i+1));
            int b=0;
            if(j>=0){
                b=Integer.valueOf(str2.substring(j, j+1));
            }
            int digitSum=0;
            int dupCarrey=0;
            if(a==1 && b==1){
                digitSum=0;
                dupCarrey=1;
            }else if(a==1 || b==1){
                digitSum=1;
            }
            if(carry>0){
                if(digitSum==1){
                    digitSum=0;
                    carry++;
                }else{
                    digitSum=1;
                }
                carry--;
            }
            res=String.valueOf(digitSum)+res;
            carry=carry+dupCarrey;
            i--;
            j--;
        }

        if(carry>0)
            System.out.println(String.valueOf(carry)+res);
        else
            System.out.println(res);
    }
}