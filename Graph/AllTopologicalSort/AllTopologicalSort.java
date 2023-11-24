package Graph.AllTopologicalSort;
import Graph.*;
import java.util.*;

public class AllTopologicalSort {
    public static void main(String[] args) {
        Graph.createGraph(6,true);
        Graph.addEdge(5,0);
        Graph.addEdge(4,0);
        Graph.addEdge(5,2);
        Graph.addEdge(4,1);
        Graph.addEdge(2,3);
        Graph.addEdge(3,1);
        int [][] graph = Graph.getGraph();
        int v =6;
        int [] visited = new int[v];
        Arrays.fill(visited,0);
        int [] inDegree = Graph.getInDegree();
        Stack<Integer> stack = new Stack<>();
        allTopologicalSort(graph,inDegree,v,visited,stack);
        
    }
    public static void allTopologicalSort(int [][] graph,int [] inDeg,int v,int [] visited,Stack<Integer> stack){
        
        boolean flag =false;
        for(int i=0;i<v;i++){
            if(visited[i]!=1 && inDeg[i]==0){
                visited[i]=1;
                stack.add(i);
                for(int j=0;j<v;j++){
                    if(graph[i][j]!=0){
                        inDeg[j]--;
                    }
                        
                }
                allTopologicalSort(graph,inDeg,v,visited,stack);
                visited[i]=0;
                stack.pop();
                for(int j=0;j<v;j++){
                    if(graph[i][j]!=0){
                        inDeg[j]++;
                    }
                }
                flag=true;
            }
            
        }
        if(!flag){
            System.out.println(stack);
        }
    }
}
