package SkyLineProblem;


import  java.util.*;
public class SkyLineProblem{

	public static void main(String[] args) {
		int [][] buildings = {{1, 11, 5}, {2, 6, 7}, {3, 13, 9}, {12, 7, 16}, {14, 3, 25}, {19, 18, 22}, {23, 13, 29}, {24, 4, 28} };
		int n = buildings.length;

		List<int []> li =solveDC(buildings, 0, n-1);

		for(int [] arr: li){
			System.err.println(Arrays.toString(arr));
		}
		
	}
	public static List<int []> solveDC(int [][]buildings,int start,int end){
		if(start>=end){
			int [] left = {buildings[start][0],buildings[start][1]};
			int [] right = {buildings[start][2],0};

			return  new ArrayList<>(Arrays.asList(left,right));
		}

		int mid = (start+end)/2;
		List<int []> leftList = solveDC(buildings, start, mid);
		List<int []> rigtList = solveDC(buildings,mid+1,end);


		return  mergeLists(leftList, rigtList);

	}
	public static List<int []> mergeLists(List<int []> left,List<int []> right ){
		
		List<int []> mergedList = new ArrayList<>();
		int h1=0,h2=0;

		while(!left.isEmpty() && !right.isEmpty()){
			int [] strip1 = left.get(0);
			int [] strip2 = right.get(0);

			int [] mergedArray=new int [2];
			if(strip1[0]<strip2[0]){
				mergedArray[0]=strip1[0];
				mergedArray[1]=strip1[1];

				if(strip1[1]<h2){
					mergedArray[1]=h2;
				}
				h1=strip1[1];

				left.remove(0);
			}else if(strip2[0]<strip1[0]){
				mergedArray[0]=strip2[0];
				mergedArray[1]=strip2[1];

				if(strip2[1]<h1){
					mergedArray[1]=h1;
				}
				h2=strip2[1];

				right.remove(0);
			}else{
				mergedArray[0]=strip1[0];
				mergedArray[1]=Math.max(strip1[1],strip2[1]);
				h1=strip1[1];
				h2=strip2[1];

				left.remove(0);
				right.remove(0);
			}

			mergedList.add(mergedArray);
		}

		if(left.isEmpty()){
			while(!right.isEmpty()){
				mergedList.add(right.remove(0));
			}
		}else if(right.isEmpty()){
			while(!left.isEmpty()){
				mergedList.add(left.remove(0));
			}
		}		
		

		int current =0;

		while(current<mergedList.size()){

			int currentHeight = mergedList.get(current)[1];
			int i = current+1;
			while(i<mergedList.size() && mergedList.get(i)[1]==currentHeight){
				mergedList.remove(i);
			}
			current++;
		}
		
		return  mergedList;



	}
	
}
