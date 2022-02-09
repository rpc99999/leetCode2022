package leetCode2022;

import java.util.LinkedList;
import java.util.Queue;

public class P117{

  public Node connect(Node root) {
    
    // check root is null
    if(root==null){
      return root;
    }

    // put root left, right into stack
    Queue<Node> nodeQueue = new LinkedList<Node>();
    nodeQueue.add(root);

    // iterate stack until empty
    Node prev = null;
    while(!nodeQueue.isEmpty()){
      Node tmp = nodeQueue.poll();
      if(tmp==null){    // if node = null, meaning the end of the same depth node
        prev.next = null;
        prev = null;
      }else{
        if(prev!=null){
          prev.next = tmp;
        }else{
          nodeQueue.add(null);  // nodes with new depth begin
        }

        if(tmp.left!=null)
        nodeQueue.add(tmp.left);

        if(tmp.right!=null)
        nodeQueue.add(tmp.right);

        prev = tmp;
      }
    }
    return root;
  }

    public static void main(String[] args){
        System.out.println("117. Populating Next Right Pointers in Each Node II");
    }
}