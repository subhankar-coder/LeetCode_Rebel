/*
 * @lc app=leetcode id=836 lang=java
 *
 * [836] Rectangle Overlap
 */

// @lc code=start


class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
       
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
        @Override
        public int compare(int [] a,int [] b){
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        }
       });
       pq.add(new int []{rec1[0],rec1[1]});
       pq.add(new int [] {rec1[2],rec1[3]});

       pq.add(new int [] {rec2[0],rec2[1]});
       pq.add(new int [] {rec2[2],rec2[3]});

       int [] first = pq.poll();
       int [] second = pq.poll();
       int [] third = pq.poll();
       int [] fourth = pq.poll();

       System.out.println(Arrays.toString(first));
       System.out.println(Arrays.toString(second));
       System.out.println(Arrays.toString(third));
       System.out.println(Arrays.toString(fourth));

       if(first[0]==rec1[0] && first[1]==rec1[1]){
            if(second[0]!=rec1[2] && second[1]!=rec1[3]){
               
                if(third[0]==rec1[2] && third[1]==rec1[3]){
                    if(second[1]<third[1]  && first[1]<fourth[1])
                        return true;
                }else if(third[0]==rec2[2] && third[1]==rec2[3]){
                    if(second[1]<fourth[1] && first[1]<third[1])
                        return true;
                }
            }

       }
       else if(first[0]==rec2[0] && first[1]==rec2[1]){
            if(second[0]!=rec2[2] && second[1]!=rec2[3] ){
                if(third[0]==rec1[2] && third[1]==rec1[3]){
                    if(second[1]<fourth[1]  && first[1]<third[1])
                             return true;
                }else if(third[0]==rec2[2] && third[1]==rec2[3]){
                    System.out.println("Here");
                    if(first[1]<fourth[1] && second[1]<third[1])
                        return true;
                }
            }
                
       }
       return false;
    }
}

// @lc code=end

