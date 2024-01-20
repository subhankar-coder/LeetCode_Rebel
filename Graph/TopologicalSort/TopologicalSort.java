package Graph.TopologicalSort;
import Graph.*;
import java.util.*;

public class TopologicalSort {
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
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<v;i++){
            topologicalSort(graph, visited, i, stack);
        }
        System.out.println(stack);

    }
    public static void topologicalSort(int [][] graph,int [] visited,int ele,Stack<Integer> stack){
        
        if(visited[ele]!=1){
            visited[ele]=1;
            for(int i=0;i<graph.length;i++){
                if(graph[ele][i]!=0 && visited[i]!=1)
                    topologicalSort(graph, visited, i, stack);
            }
            stack.push(ele);
        }
    }
}
