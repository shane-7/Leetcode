package BinaryTree;

/** 111.二叉树的最小深度
 * @author shkstart
 * @create 2021-10-27 14:11
 */
public class BT10_111 {
    public int getDepth(TreeNode node){
        //递归法
        if(node == null) return 0;
        //确定单层递归的逻辑
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        //如果左子树为空，右子树不为空，说明最小深度为1 + 右子树的深度
        if(node.left == null && node.right != null){
            return 1 + rightDepth;
        }
        //如果左子树不为空，右子树为空，最小深度为1 + 左子树的深度
        if(node.left != null && node.right == null){
            return 1 + leftDepth;
        }
        //如果左右都不为空，返回左右子树深度最小值 + 1
        int result = 1 + Math.min(leftDepth, rightDepth);
        return result;
    }


}
