package EvaluateDivision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluateDivision {

    static List<String> present = new ArrayList<>();
    static List<Double> result = new ArrayList<>();
    static List<Integer> visited ;
    public static void main(String[] args) {

        List<List<String>> eqList = new ArrayList<>(Arrays.asList(Arrays.asList("x1","x2"),Arrays.asList("x2","x3"),Arrays.asList("x3","x4"),Arrays.asList("x4","x5")));
        List<List<String>> queryList = new ArrayList<>(Arrays.asList(Arrays.asList("x1","x5"),Arrays.asList("x5","x2"),Arrays.asList("x2","x4"),Arrays.asList("x2","x2"),Arrays.asList("x","x"),Arrays.asList("x2","x9"),Arrays.asList("x9","x9")));

        // List<List<String>> eqList = new ArrayList<>(Arrays.asList(Arrays.asList("a","b"),Arrays.asList("b","c"),Arrays.asList("a","c"),Arrays.asList("d","e")));
        // List<List<String>> queryList = new ArrayList<>(Arrays.asList(Arrays.asList("a","c"),Arrays.asList("b","c"),Arrays.asList("a","e"),Arrays.asList("a","a"),Arrays.asList("a","d"),Arrays.asList("x3","x4"),Arrays.asList("x4","x3")));
        double [] values = new double[]{3.0,4.0,5.0,6.0};

        for(List<String> list: eqList){
            if(!present.contains(list.get(0)))
                present.add(list.get(0));

            if(!present.contains(list.get(1)))
                present.add(list.get(1));    
        }
        int len = present.size();
        int count=0;
        
        double[][] graph = new double[len][len];
        // double [] result = new double[queryList.size()];

        for(int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                graph[i][j]=-1;
                if(i==j)
                    graph[i][j]=1;
            }
            
        }
        for(List<String> list: eqList){
            int a = present.indexOf(list.get(0));
            int b = present.indexOf(list.get(1));

            graph[a][b] = values[count];
            graph[b][a]=1/values[count];

            count++;
        }
        // for(int i=0;i<len;i++){
        //     graph[i][i]=1;
        // }
        for(int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                System.out.print(graph[i][j]+"  ==> ");
            }
            System.out.println();
        }
        
        // count=0;
        for(List<String> list : queryList){
            int a = present.indexOf(list.get(0));
            int b = present.indexOf(list.get(1));
            if(a==-1 || b==-1)
                result.add(Double.valueOf(-1));
            else{
                visited=new ArrayList<>();
                if(graph[a][b]==-1){
                    if(!solve(graph, a,a, b, 1)){
                        result.add(Double.valueOf(-1));
                    }
                }else{
                    result.add(graph[a][b]);
                }
            }
        }
        System.out.println(result);
    }
    public static boolean solve(double [][]graph,int src,int lastIndex,int dest,double sum){
        if(src==dest){
            result.add(sum);
            return true;
        }
        // int start = dest>src?src:0;
        for(int i=0;i<graph.length;i++){
                if(graph[src][dest]!=-1){
                    return solve(graph,dest,src,dest,sum*graph[src][dest]);
                }
                if(!visited.contains(i) && graph[src][i]!=-1){
                    visited.add(i);
                    if(solve(graph,i,src, dest, sum*graph[src][i]))
                        return true;
                }
            
        }
        return false;
    }
    
}
