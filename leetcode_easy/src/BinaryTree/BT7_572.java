package BinaryTree;

/** 572.另一个子树
 * @author shkstart
 * @create 2021-10-28 20:31
 */
public class BT7_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        //双重递归
        if(root == null && subRoot != null) return false;
        if(root != null && subRoot == null) return false;
        if(root == null && subRoot == null) return true;
        return compare(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean compare(TreeNode left, TreeNode right){
        //遍历root的节点，是否有节点与subRoot的根节点相同
        //1.排除结点为空的情况
        if(left == null && right != null) return false;
        else if(left != null && right == null) return false;
        else if(left == null && right == null) return true;
        //2.此时左右结点不为空的情况，且数值不相同的情况我们也处理了
        else if(left.val != right.val) return false;
        //3.比较左孩子是否对称：传入的左节点的左孩子，右节点的左孩子
        boolean leftSide = compare(left.left, right.left);
        //4.比较右孩子是否对称，传入左节点的右孩子，右节点的右孩子
        boolean rightSide = compare(left.right, right.right);
        //5.如果左右都对称就返回true，有一侧不对称就返回false
        boolean isSame = leftSide && rightSide;
        return isSame;
    }
}
