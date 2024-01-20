package CourseSchedule;

public class CourseSchedule {

    public static void main(String[] args) {
        
        int numCourses = 2;
        int[][] prerequisites = new int [][]{{0,1}}; 
        int [][] graph = new int [numCourses][numCourses];
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]][prerequisites[i][0]]=1;
        }
        int [] visited = new int[numCourses];
        int [] recStack= new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0)
                if(isCyclePresent(graph, visited, i, recStack))
                    System.out.println(true);
        }
        System.out.println(false);

    }
    public static boolean isCyclePresent(int [][] graph,int [] visited,int src,int [] recStack){

        if(recStack[src]!=0)
            return true;
        if(visited[src]==0){
            visited[src]=1;
            recStack[src]=1;
            int [] array = graph[src];
            for(int i=0;i<array.length;i++){
                if(array[i]==1){
                    if(isCyclePresent(graph, visited, i, recStack))
                        return true;
                }
            }
            recStack[src]=0;
        }
        return false;
    }
    
}
