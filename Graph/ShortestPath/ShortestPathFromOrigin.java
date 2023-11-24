package Graph.ShortestPath;

public class ShortestPathFromOrigin{
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        int N = graph.length;
        int [] visited = new int[N];
        int source=0;
        for(int i=0;i<N;i++){
            if(i!=source){
                printSortestPath(graph,source,i,0,visited,N);
                System.out.println(min);
            }
            min=Integer.MAX_VALUE;
        }

    }
    public static void printSortestPath(int [][] graph,int source,int dest,int w,int [] visited,int N){
        if(source == dest){
            min = Math.min(w, min);
            // System.out.println(min);
        }
        if(visited[source]!=1){
            visited[source]=1;
            for(int i=0;i<N;i++){
                if(graph[source][i]!=0 && visited[i]==0){
                    printSortestPath(graph,i, dest, w+graph[source][i], visited, N);
                }
            }
            visited[source]=0;
        }
    }
}