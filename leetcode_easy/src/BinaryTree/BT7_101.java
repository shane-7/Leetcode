package BinaryTree;

/** 101.对称二叉树
 * @author shkstart
 * @create 2021-10-26 22:30
 */
public class BT7_101 {

    public boolean isSymmetric(TreeNode root){
        return compare(root.left, root.right);
    }
    //1.递归法
    public boolean compare(TreeNode left, TreeNode right){
        //1.排除结点为空的情况
        if(left == null && right != null) return false;
        else if(left != null && right == null) return false;
        else if(left == null && right == null) return true;
        //2.此时左右结点不为空的情况，且数值不相同的情况我们也处理了
        else if(left.val != right.val) return false;
        //3.比较二叉树外侧是否对称：传入的左节点的左孩子，右节点的右孩子
        boolean outside = compare(left.left, right.right);
        //4.比较二叉树内侧是否对称，传入左节点的右孩子，右节点的左孩子
        boolean inside = compare(left.right, right.left);
        //5.如果左右都对称就返回true，有一侧不对称就返回false
        boolean isSame = outside && inside;
        return isSame;
    }
}
