import java.util.Stack;

public class P19_RemoveNthNodeFromEndOfList {
  /*
   * Given the head of a linked list, remove the nth node from the end of the list
   * and return its head.
   * (P.S do this in one pass)
   */

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode method1(ListNode head, int n) {   // One pass, but not 2 pointer approach
      Stack<ListNode> stackNodes = new Stack<ListNode>();
      ListNode tmp = head;
      while(tmp!=null){
        stackNodes.add(tmp);
        tmp = tmp.next;
      }
      for(int i =0; i < n ; i++){
        tmp = stackNodes.pop();
      }
      if(stackNodes.empty()){
        return tmp.next;
      }else{
        stackNodes.pop().next = tmp.next;
      }
      return head;

    }
  
  public ListNode method2(ListNode head, int n){
        // Step 1. init leftPtr, rightPtr
        ListNode leftPtr = head;
        ListNode rightPtr = head;
        ListNode prev = null;
        // Step 2. make rightPtr to be 'n' nodes ahead leftPtr
        for(int i = 0 ; i < n ; i++){
          rightPtr = rightPtr.next;
        }
        // Step 3. iterate both leftPtr and rightPtr until the end
        while(rightPtr!=null){
          prev = leftPtr;
          leftPtr = leftPtr.next;
          rightPtr = rightPtr.next;
        }
        // Step 4. remove node pointed by leftPtr
        if(prev==null){   
          return leftPtr.next;//remove the first node
        }else{
          prev.next = leftPtr.next;
        }
        return head;
  }
}
