package BackTracking.SumString;

public class SumString {
    public static  void main(String[] args) {
        String str = "111112223";
        System.out.println (sumString(str));
    }
    public static boolean sumString(String str){
        for (int i=1;i<str.length();i++){
            for (int j=1;i+j<str.length();j++){
                if(sumStringUtil(str,0,i,j))
                return true;
            }
        }
        return false;
    }
    public static boolean sumStringUtil(String str,int beg,int index1,int index2){
        String str1=str.substring(beg,beg+index1);
        String str2=str.substring(beg+index1,beg+index1+index2);
        String str3=String.valueOf(Integer.parseInt(str1)+Integer.parseInt(str2));

        if(str3.length()>(str.length()-(beg+index1+index2))){
            return false;
        }
        String curr=str.substring(beg+index1+index2,beg+index1+index2+str3.length());
        if(str3.equals(curr)){
            if(beg+index1+index2+str3.length()==str.length())
                return true;
            return sumStringUtil(str,beg+index1,index2,str3.length());
        }
        return false;
    }
}
