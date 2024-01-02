package CloneGraph;

public class CloneGraph {

    public static void main(String[] args) {
        
    }
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return null;
        Map<Integer,Node> mp = new HashMap();
        Queue<Node> queue=new LinkedList();
        Node head = new Node(node.val);
        mp.put(node.val,head);
        queue.add(node);
        while(!queue.isEmpty()){
            Node data = queue.poll();
            List<Node> lt =new ArrayList<>();
            int count =0;

            while(count<data.neighbors.size()){
                Node dup = new Node(data.neighbors.get(count).val);
                lt.add(dup);
                if(!mp.containsKey(data.neighbors.get(count).val)){
                    mp.put(data.neighbors.get(count).val,data.neighbors.get(count));
                    queue.add(data.neighbors.get(count));
                }
                count++;
            } 
            if(mp.containsKey(data.val)){
                Node temp = mp.get(data.val);
                System.out.print(temp.val+"===" );
                temp.neighbors = lt;
            }else{
                Node temp = new Node(data.val);
                System.out.print(temp.val+"===");
                mp.put(data.val,temp);
                temp.neighbors=lt;
            }
            for(Node nd: lt){
                System.out.print(nd.val+" ");
            }
            System.out.println();
        }

        return head;
    }
}