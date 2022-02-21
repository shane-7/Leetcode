package BinaryTree;

/** 找公共祖先
 * @author shkstart
 * @create 2021-11-12 23:02
 */
public class BT27_236 {
    //递归、回溯
    TreeNode lowestCommonaAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonaAncestor(root.left, p ,q);
        TreeNode right = lowestCommonaAncestor(root.right, p ,q);
        if(left != null && right != null) return root;
        if(left == null && right != null) return right;
        else if(left != null && right == null) return left;
        else { //  (left == NULL && right == NULL)
            return null;
        }

    }
}
