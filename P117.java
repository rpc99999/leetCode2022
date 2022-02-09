package leetCode2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class P117{

  public Node connect(Node root) {
    
    // check root is null
    if(root==null){
      return root;
    }

    // put root left, right into stack
    Queue<Node> nodeQueue = new LinkedList<Node>();
    if(root.left!=null){
      nodeQueue.add(root.left);
    }

    if(root.right!=null){
      nodeQueue.add(root.right);
    }

    // iterate stack until empty


    // for each node in stack, add it into another stack

    return null;
  }

    public static void main(String[] args){
        System.out.println("Sdfsdf");
    }
}