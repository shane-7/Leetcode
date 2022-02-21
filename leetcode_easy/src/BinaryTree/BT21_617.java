package BinaryTree;

/** 617.合并二叉树
 * @author shkstart
 * @create 2021-11-07 14:58
 */
public class BT21_617 {

    //前序遍历
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
