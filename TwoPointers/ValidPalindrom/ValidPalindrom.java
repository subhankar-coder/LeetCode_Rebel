package TwoPointers.ValidPalindrom;

public class ValidPalindrom {
    public static void main(String[] args) {
        String s= "0P";
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            int asciiI=Character.toLowerCase(s.charAt(i));
            int asciiE=Character.toLowerCase(s.charAt(j));
            if((asciiI<97 || asciiI>122) && (asciiI<48 || asciiI>57)) {
                i++;
                continue;
            }
            if((asciiE<97 || asciiE>122) && (asciiE<48 || asciiE>57)){
                j--;
                continue;
            }
            if(asciiI!=asciiE){

                System.out.println(false);
                break;
            }
            
            i++;
            j--;
        }
        System.out.println(true);
    }
    
}
