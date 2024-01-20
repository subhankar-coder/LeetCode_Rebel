package Graph.HamiltonPath;
import java.util.*;
public class HamiltonPath {
    private static final int N =5;

    public static void main(String[] args) {
        int [][] graph = {{0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 0, 1},
        {1, 1, 0, 0, 1},
        {0, 1, 1, 1, 0}};

        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        System.out.println(solve(graph,path,0));
    }
    // public static boolean isSafe(int [][] graph,int source,ArrayList<Integer>path){
    //     if(graph[path.get(path.size()-1)][source]!=0 && !path.contains(source)){
    //         return true;
    //     }
    //     return false;
    // }
    public static boolean solve(int [][]graph,ArrayList<Integer> path,int source){
        if(path.size()==N){
            if(graph[path.get(N-1)][0]==1){
                System.out.println(path);
                return true;
            }
            return false;

        }
        if(path.isEmpty())
            return false;
        for(int i=0;i<N;i++){
            if(graph[source][i]!=0 && !path.contains(i)){
                path.add(i);
                if(solve(graph,path,i)){
                    return true;
                }
                path.remove(path.size()-1);

            }
        }
        return false;
        
    }

    
}
