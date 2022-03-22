public class P617 {
  /*
   * 617. Merge Two Binary Trees
   * You are given two binary trees root1 and root2.
   * 
   * Imagine that when you put one of them to cover the other, some nodes of the
   * two trees are overlapped while the others are not. You need to merge the two
   * trees into a new binary tree. The merge rule is that if two nodes overlap,
   * then sum node values up as the new value of the merged node. Otherwise, the
   * NOT null node will be used as the node of the new tree.
   * 
   * Return the merged tree.
   * 
   * Note: The merging process must start from the root nodes of both trees.
   */

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  
    TreeNode() {
    }
  
    TreeNode(int val) {
      this.val = val;
    }
  
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if(root1==null && root2==null){
        return null;
      }

      if(root1==null ){
        return new TreeNode(root1.val, root1.left, root1.right);
      }

      if(root2==null){
        return new TreeNode(root2.val, root2.left, root2.right);
      }

      TreeNode newNode = new TreeNode(root1.val+root2.val, mergeTrees(root1.left, root2.left), mergeTrees(root1.right, root2.right));
      return newNode;
  }

  public static void main(String[] args){

  }
}
