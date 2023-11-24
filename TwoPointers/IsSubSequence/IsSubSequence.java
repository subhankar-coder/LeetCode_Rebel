package TwoPointers.IsSubSequence;

public class IsSubSequence {

    public static void main(String[] args) {
        String s="axc";
        String t="ahbgdc";
        int sIndex=0;
        int tIndex=0;

        for(tIndex=0;tIndex<t.length();tIndex++){
            if(sIndex<s.length()){
                if(t.charAt(tIndex)==s.charAt(sIndex))
                    sIndex++;
            }
        }
        if(sIndex==s.length()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    
}
