package Graph.AllPathBetweenTwoVertices;
import Graph.*;
import java.util.*;
public class PathsBetweenTwoVertices {


    public static void main(String[] args) {
        Graph.createGraph(5,true);
        Graph.addEdge(0, 1);
        Graph.addEdge(0, 2);
        Graph.addEdge(0, 4);
        Graph.addEdge(1, 3);
        Graph.addEdge(1, 4);
        Graph.addEdge(2, 1);
        Graph.addEdge(2, 4);
        // Graph.addEdge(2, 1);
        Graph.addEdge(3, 2);
        int [][] graph = Graph.getGraph();
        pathBetweenTwoVertices(graph,5);

    }
    public static void pathBetweenTwoVertices(int [][] graph,int n){
        int [] visited = new int [n];
        Arrays.fill(visited,0);
        String result="";
    
        DFS(visited,0,4,graph,n,result);

    }
    public static void DFS(int [] visited,int start,int end,int [][] graph,int n,String result){
         if (start==end){
            System.out.println(result+Character.toString(end+65));
            return ;
         }
         if(visited[start]!=1){
            visited[start]=1;
            for(int i=0;i<n;i++){
                if(graph[start][i]!=0 && visited[i]!=1){
                    DFS(visited,i,end,graph,n,result+Character.toString(start+65)+"->");
                    visited[start]=0;
                }
            }
         }
    }
}
