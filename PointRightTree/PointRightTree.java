package PointRightTree;
import java.util.*;
public class PointRightTree {
    public static void main(String[] args) {
        Node node= new Node(1);
        node.left=new Node(2);
        node.left.left=new Node(4);
        node.left.right=new Node(5);

        node.right=new Node(3);
        node.right.right=new Node(7);

        connect(node);
        // root.printTreeIn2D();

    }
    public static void connect(Node root){
        if(root==null){
            return;
        }
        Stack<Node> st=new Stack<>();
        Queue<Node> q= new LinkedList<>();
        q.offer(root);

        while(true){
            int nodeCount=q.size();
            if(nodeCount==0)
                break;
            while(nodeCount>0){
                Node node = q.poll();
                st.push(node);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                nodeCount--;
            }
            for(int i=1;i<st.size();i++){
                st.get(i-1).next=st.get(i);
            } 
            st.clear();  
        }
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    // public void printTreeIn2D(){
    //     Main.TreePrinter(this);
    //   }
}
// class Main {
 
//     public static int height(Node root) {
//         if (root == null)
//             return 0;
//         return Math.max(height(root.left), height(root.right)) + 1;
//     }
 
//     public static int getcol(int h) {
//         if (h == 1)
//             return 1;
//         return getcol(h - 1) + getcol(h - 1) + 1;
//     }
 
//     public static void printTree(int[][] M, Node root, int col, int row, int height) {
//         if (root == null)
//             return;
//         M[row][col] = root.val;
//         printTree(M, root.left, col - (int)Math.pow(2, height - 2), row + 1, height - 1);
//         printTree(M, root.right, col + (int)Math.pow(2, height - 2), row + 1, height - 1);
//     }
 
//     public static void TreePrinter(Node root) {
//         int h = height(root);
//         int col = getcol(h);
//         int[][] M = new int[h][col];
//         printTree(M, root, col / 2, 0, h);
//         for (int i = 0; i < h; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (M[i][j] == 0)
//                     System.out.print("  ");
//                 else
//                     System.out.print(M[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

