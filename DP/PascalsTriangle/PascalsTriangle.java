package DP.PascalsTriangle;

import java.util.*;
public class PascalsTriangle {

    public static void main(String[] args) {
        int n =5;
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for(int i=1;i<n;i++){
            List<Integer> next = new ArrayList<>();
            next.add(res.get(i-1).get(0));
            for(int j=1;j<i;j++){
                next.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            next.add(res.get(i-1).get(i-1));
            res.add(next);
        }

    }
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList();
        res.add(1);

        for(int i=1;i<=rowIndex;i++){
            List<Integer> next = new ArrayList<>();
            next.add(res.get(0));
            for(int j=1;j<i;j++){
                next.add(res.get(j)+res.get(j-1));
            }
            next.add(res.get(i-1));

            res=next;
        }

        return res;
    }
    
}
