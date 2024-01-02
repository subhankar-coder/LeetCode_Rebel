package CourseScheduleII;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses=3;
        int [][] prerequisites = new int [][]{{1,0},{0,2},{2,1}};
        int [] result = findOrder(numCourses,prerequisites);
        for(int i: result){
            System.out.println(i);
        }
    }
     public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer> list = new ArrayList<>();
        int [][] graph = new int [numCourses][numCourses];
        if(prerequisites.length==0){
            int [] res = new int [numCourses];
            for(int i=0;i<numCourses;i++)
                res[i]=i;
            return res;
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]][prerequisites[i][0]]=1;
            if(graph[prerequisites[i][0]][prerequisites[i][1]]==1)
                return new int []{};
        }
        int [] visited = new int[numCourses];
        int [] recStack = new int [numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==0)
                if(isCyclePresent(graph, visited, i, recStack))
                    return new int[]{};
        }
        visited = new int [numCourses];
        for(int i=0;i<numCourses;i++){

            if(visited[i]==0){
                topologicalSort(graph,visited,i,list);
            }
        }
        reverseList(list);
        return list.stream().mapToInt(i->i).toArray();
    }

    public static boolean isCyclePresent(int [][] graph,int [] visited,int src,int [] recStack){
        if (recStack[src]==1)
            return true;
        if(visited[src]==0){
            visited[src]=1;
            recStack[src]=1;
            int [] array = graph[src];

            for(int i=0;i<array.length;i++){
                if(array[i]!=0){
                    if(isCyclePresent(graph,visited,i,recStack))
                        return true;
                }
            }
            recStack[src]=0;
        }
        return false;
    }
    public static void topologicalSort(int [][] graph ,int [] visited,int src,List<Integer> result){

        if(visited[src]==0){
            visited[src]=1;
            int [] arr = graph[src];
            for(int i=0;i<arr.length;i++){
                if(arr[i]==1){
                    if(visited[i]==0){
                        topologicalSort(graph,visited,i,result);
                        if(!result.contains(i))
                            result.add(i);
                    }
                }
                
            }
            if(!result.contains(src)){
                    result.add(src);
                }
        }
        return ;
    }
    public static void reverseList(List<Integer> list){
        if(list.size()==0)
            return;
        
        int val= list.get(0);
        list.remove(0);

        reverseList(list);
        
        list.add(val);

    }
    
}
