/*
 * @lc app=leetcode id=1643 lang=java
 * @lcpr version=30116
 *
 * [1643] Kth Smallest Instructions
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int visited[][];
    PriorityQueue<String> pq ;

    public String kthSmallestPath(int[] destination, int k) {
        
        int R=destination[0]+1;
        int C = destination[1]+1;
        visited = new int[R][C];
        // pq = new PriorityQueue<>(new Comparator<String>() {
        //     @Override
        //     public int compare(String a,String b ){
        //             int i=0,j=0;
        //             while (i<a.length() && j<b.length()) {
        //                 int cha = a.charAt(i);
        //                 int chb = b.charAt(j);
        //                 if(cha!=chb)
        //                     return cha-chb;
        //                 i++;
        //                 j++;
        //             }
        //             if(i==a.length() && j!=b.length())
        //                 return -1;
        //             if(j==b.length() && i!=a.length())
        //                 return 1;

        //             return 0;
        //     }
        // });
        solve(destination, 0, 0, R, C, "");
        String res="";
        // while (k>0) {
        //     res=pq.poll();
        //     k--;
        // }
        return res;
    
    }
    public void solve(int [] destination,int r ,int c,int R,int C,String Path){
        //    System.out.println(Path+" r "+r+" c"+c);
            if(r>=R || c>=C || c<0 || r<0 || visited[r][c]==1)
                return;
            if(r==R-1 && c==C-1){
                System.out.println(Path);
                // pq.add(Path);
                return ;
            }
            visited[r][c]=1;
             
            //right 

            solve(destination, r, c+1, R, C, Path+"H");
            solve(destination, r+1, c, R, C, Path+"V");
            visited[r][c]=0;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3]\n1\n
// @lcpr case=end

// @lcpr case=start
// [2,3]\n2\n
// @lcpr case=end

// @lcpr case=start
// [2,3]\n3\n
// @lcpr case=end

 */

