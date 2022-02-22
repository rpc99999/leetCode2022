public class P876_MiddleOfTheLinkedList {

  /*
   * Given the head of a singly linked list, return the middle node of the linked
   * list.
   * 
   * If there are two middle nodes, return the second middle node.
   * 
   * Input: head = [1,2,3,4,5]
   * Output: [3,4,5]
   * Explanation: The middle node of the list is node 3.
   * 
   * Input: head = [1,2,3,4,5,6]
   * Output: [4,5,6]
   * Explanation: Since the list has two middle nodes with values 3 and 4, we
   * return the second one.
   * 
   * 1 <= Node.val <= 100
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

  public ListNode middleNode(ListNode head) {
    /*
     * Time Complexity: O(N), where NN is the number of nodes in the given list.
     * 
     * Space Complexity: O(1), the space used by slow and fast
     */
    ListNode leftPtr = head;
    ListNode rightPtr = head;

    if (head.next == null) {
      return head;
    }

    while (true) {
      if (rightPtr.next != null && rightPtr.next.next != null) {
        leftPtr = leftPtr.next;
        rightPtr = rightPtr.next.next;
      } else if (rightPtr.next == null) {
        return leftPtr;
      } else {
        return leftPtr.next;
      }
    }
  }
}
