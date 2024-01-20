package SnakeAndLadders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SnakeAndLadders {

    public static int dest;
    private static int rowCount;
    private static int res=Integer.MAX_VALUE;
    private static boolean isEven;

    public static void main(String[] args) {
        int [][] board = {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
        };
        // int [][] board={
        //     {-1,-1,-1},
        //     {-1,9,8},
        //     {-1,8,9},
        // };
        // int [][] board={
        //     {-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}
        // };
        // int [][] board ={{1,1,-1},{1,1,1},{-1,1,1}};
        // int [][] board={{-1,4,-1},{6,2,6},{-1,3,-1}};
        // int [][] board = {{-1,-1,19,10,-1},{2,-1,-1,6,-1},{-1,17,-1,19,-1},{25,-1,20,-1,-1},{-1,-1,-1,-1,15}};
        // int [][] board = {{-1,-1,30,14,15,-1},{23,9,-1,-1,-1,9},{12,5,7,24,-1,30},{10,-1,-1,-1,25,17},{32,-1,28,-1,-1,32},{-1,-1,23,-1,13,19}};
        // int [][] board = {
        //     {-1,-1,27,13,-1,25,-1},
        //     {-1,-1,-1,-1,-1,-1,-1},
        //     {44,-1,8,-1,-1,2,-1},
        //     {-1,30,-1,-1,-1,-1,-1},
        //     {3,-1,20,-1,46,6,-1},
        //     {-1,-1,-1,-1,-1,-1,29},
        //     {-1,29,21,33,-1,-1,-1}};

        // int [][] board = {
        //     {-1,-1,-1,63,-1,-1,-1,62,-1},
        //     {53,52,13,32,-1,-1,-1,-1,-1},
        //     {-1,-1,26,-1,73,-1,-1,-1,55},
        //     {-1,-1,-1,-1,74,-1,-1,-1,-1},
        //     {-1,-1,35,42,-1,45,-1,-1,-1},
        //     {81,-1,3,46,-1,-1,-1,-1,59},
        //     {74,-1,66,16,-1,-1,-1,-1,-1},
        //     {-1,-1,-1,28,-1,-1,81,-1,22},
        //     {-1,-1,-1,-1,61,17,39,21,-1}};

        rowCount = board.length;
        int [] graph = new int [rowCount*rowCount];
        int count=0;
        boolean isFwd =true;
        int j;
        int dest = rowCount*rowCount-1;
        for(int i=rowCount-1;i>=0;i--){
            if(isFwd){
                j=0;
            }else{
                j=rowCount-1;
            }
            while (j>=0 && j<rowCount) {
                
                graph[count++]=board[i][j]==-1?board[i][j]:board[i][j]-1;
                
                if(isFwd)
                    j++;
                else
                    j--;
            }
        }

        if(graph[dest]!=-1)
            return;

        int [] visited = new int [dest];

        List<Integer>list=new ArrayList<>();
        count=1;
        list.add(0);
        while (!list.isEmpty()) {
            int start = list.get(0);
            list.remove(0);
            int end = start+6;
            if(dest>= start+1 && end>=dest)
                break;
            List<Integer> temp=new ArrayList<>();
            for(int i=start+1;i<=end && i<=dest;i++){
                if(visited[i]==0){
                    visited[i]=1;
                    if(graph[i]!=-1){
                        temp.add(graph[i]);
                    }else{
                        temp.add(i);
                    }
                }
            }
            list=Stream.concat(temp.stream(),list.stream()).distinct().collect(Collectors.toList());

        }
        System.out.println(count);
        // for(int i: graph){
        //     System.out.print(i+" ");
        // }
    }
    
        
}
