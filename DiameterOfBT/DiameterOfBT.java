package DiameterOfBT;

import java.uti.*;

public class DiameterOfBT{
    static int res = Integer.MIN_VALUE;
	public static void main(String[] args) {
		 width(root);
        System.out.println(( res==Integer.MIN_VALUE)?0:res-1);
	}
	public int width(TreeNode root){
       if(root==null)
            return 0;

        if(root.left==null && root.right==null)
            return 1;

        int left = width(root.left);
        int right = width(root.right);

        int maxSingle = Math.max(left+1, right+1);
        int maxCurr = Math.max(maxSingle,left+right+1);

        res = Math.max(res,maxCurr);
        return maxSingle;
    }
}