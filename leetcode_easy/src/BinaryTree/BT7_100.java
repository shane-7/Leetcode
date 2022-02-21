package BinaryTree;

/** 100.判断是否为相同的树
 * @author shkstart
 * @create 2021-10-28 17:11
 */
public class BT7_100 {
    public boolean isSameTree(TreeNode p, TreeNode q){
        return compare(p, q);
    }

    public boolean compare(TreeNode tree1, TreeNode tree2){
        //1.排除结点为空的情况
        if(tree1 == null && tree2 != null) return false;
        else if(tree1 != null && tree2 == null) return false;
        else if(tree1 == null && tree2 == null) return true;
        //2.此时左右结点不为空的情况，且数值不相同的情况我们也处理了
        else if(tree1.val != tree2.val) return false;
        //3.比较左孩子是否对称：传入的左节点的左孩子，右节点的左孩子
        boolean leftSide = compare(tree1.left, tree2.left);
        //4.比较右孩子是否对称，传入左节点的右孩子，右节点的右孩子
        boolean rightSide = compare(tree1.right, tree2.right);
        //5.如果左右都对称就返回true，有一侧不对称就返回false
        boolean isSame = leftSide && rightSide;
        return isSame;
    }
}
