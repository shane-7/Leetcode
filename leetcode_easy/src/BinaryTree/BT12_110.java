package BinaryTree;

/** 110.判断是否为平衡二叉树（高度差不为1）
 *
 *  此题用递归法比较好
 * @author shkstart
 * @create 2021-10-28 15:04
 */
public class BT12_110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1? false : true;
    }

    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight(node.right);
        if(rightHeight == -1) return -1;
        //不是平衡二叉树返回-1，是则返回以该节点为根节点的高度
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }
}
