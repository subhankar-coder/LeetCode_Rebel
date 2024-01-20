package ReversePolish;
import java.util.*;

public class ReversePolish{
	public static void main(String [] args){

		String [] tokens={"2","1","+","3","*"};
		Stack<Integer> st = new Stack<Integer>();
		List<String> list= List.of("+","-","/","*");
		for (String val:tokens){
			if ( list.contains(val)){
				int b= st.pop();
				int a = st.pop();
				int res = doOperation(val,a,b);
				st.push(res);
			}else{
				st.push(Integer.valueOf(val));
			}
		}
		System.out.println(st.peek());

	}
	public static int doOperation(String operands,int a,int b){

		switch(operands){
		case "+":
			return a+b;
		case  "*":
			return a*b;
		case "/":
			return a/b;
		case  "-":
			return a-b;
		default:
			return 0;
		}
	}
}
