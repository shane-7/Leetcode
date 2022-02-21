package BinaryTree;

/**
 * @author shkstart
 * @create 2021-11-07 15:14
 */
public class BT22_700 {
    //递归法
    public TreeNode searchBST(TreeNode root, int val){
        if(root == null || root.val == val) return root;
        if(root.val < val) return searchBST(root.right, val);
        if(root.val > val) return searchBST(root.left, val);
        return null;
    }

    //迭代法：先一条路走到黑再说
    public TreeNode searchBST1(TreeNode root, int val){
        while(root != null){
            if(root.val > val) root = root.left;
            else if(root.val < val) root = root.right;
            else return root;
        }
        return null;
    }
}
