package Trees;

import java.util.*;

public class ZigZagTraversal {
    public static void zigzag(Node root){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean flag = false;
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> level_nodes = new ArrayList<>();
            int queueCount = queue.size();
            for(int i=0;i<queueCount;i++){
                Node node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                level_nodes.add(node.data);
            }
            if(!flag){
                list.add(level_nodes);//normal
            }else{
                Collections.reverse(level_nodes);//reverse
                list.add(level_nodes);
            }
            flag=!flag;
        }
        for (int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        zigzag(root);
    }
}
