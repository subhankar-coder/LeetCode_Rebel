package BackTracking.StringPermutation;

public class StringPermutation {
    public static void main(String[] args) {
        String str="ABC";
        generateAllPermutation(str,0);

    }
    public static String swap(String str,int i,int j){
        char [] strArray = str.toCharArray();
        char temp = strArray[i];
        strArray[i]=strArray[j];
        strArray[j]=temp;

        return new String(strArray);
    }
    public static void generateAllPermutation(String str,int startIndex){
        if(startIndex==str.length())
            return;
        for(int i=startIndex;i<str.length();i++){
            str=swap(str,startIndex,i);
            System.out.println(str);
            generateAllPermutation(str,startIndex+1);
        }
    }
}
