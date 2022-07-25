package BinaryTree;

/**
 * @author shkstart
 * @create 2021-10-25 16:26
 */
public class TreeNode {
     int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}