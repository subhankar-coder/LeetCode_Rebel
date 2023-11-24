package Graph;
import java.util.*;
public class Graph {
    private Graph(){};

    private static int adjMatrix[][];
    private static int vertexCountGlobal;
    private static boolean isDirectedGlobal=false;
    private static int inDegree[];

    public static void main(String[] args) {
        createGraph(5,true);
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,2);
        addEdge(1,3);
        addEdge(2,4 );
        addEdge(3, 4);
        BFS(vertexCountGlobal);
        

    }
    public static void createGraph(int vertexCount,boolean isDirected){
        vertexCountGlobal=vertexCount;
        adjMatrix = new int [vertexCount][vertexCount];
        isDirectedGlobal = isDirected;
        inDegree=new int[vertexCount];
    }
    public static void addEdge(int i,int j){
        if (0<= i && i<vertexCountGlobal && j>=0 && j< vertexCountGlobal){
            adjMatrix[i][j]=1;
            inDegree[j]++;
            if(!isDirectedGlobal){

                adjMatrix[j][i]=1;
                inDegree[i]++;
            }
        }
    }
    public static void addEdge(int i,int j,int w){
        if (0<= i && i<vertexCountGlobal && j>=0 && j< vertexCountGlobal){
            adjMatrix[i][j]=w;
            adjMatrix[j][i]=w;
        }
    }
    public static int getEdge(int i,int j){
        if (0<= i && i<vertexCountGlobal && j>=0 && j< vertexCountGlobal){
            return adjMatrix[i][j];
        }
        return 0;
    }
    public static void removeEdge(int i,int j){
        if (0<= i && i<vertexCountGlobal && j>=0 && j< vertexCountGlobal){
            adjMatrix[i][j]=0;
            if(!isDirectedGlobal)
                adjMatrix[j][i]=0;
            
        }
    }
    public static void printGraph(){
        for (int a=0;a<vertexCountGlobal;a++){
            System.out.print((char)(a+97));
        }
        for (int i=0;i<vertexCountGlobal;i++){
            for(int j=0;j<vertexCountGlobal;j++){
                System.out.println((char)j+97 +" "+adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void DFS(){
        int [] visited = new int[vertexCountGlobal];
        Arrays.fill(visited,0);
        DFSUtil(visited,0);

    }
    public static void DFSUtil(int [] visited,int n){
        if(visited[n]!=1){
            visited[n]=1;
            for (int i=0;i<vertexCountGlobal;i++){
                if(adjMatrix[n][i]!=0 && visited[i]!=1)
                    DFSUtil(visited, i);
            }
        }
    }
    public static void BFS(int n){
        int [] visited = new int [vertexCountGlobal];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(0);
        Arrays.fill(visited, 0);
        BFSUtil(visited,0);
    }
    public static void BFSUtil(int [] visited,int start){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(start);
        while(!queue.isEmpty()){
            int index = queue.poll();
            System.out.print(Character.toString(index+65)+" ");
            visited[index]=1;
            for(int i=0;i<vertexCountGlobal;i++){
                if(adjMatrix[index][i]!=0 && visited[i]!=1){
                    queue.add(i);
                    visited[i]=1;
                }
            }
        }
    }
    public static int [][] getGraph(){
        return adjMatrix;
    }
    public static int[] getInDegree(){
        return inDegree;
    }
    public static int increaseInDeg(int i){
        return inDegree[i]++;
    }
    public static int decreaseInDeg(int i){
        return inDegree[i]--;
    }

}
