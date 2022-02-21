package BinaryTree;

/**
 * 222.完全二叉树的节点个数
 *
 * 完全二叉树中，如果左右孩子都是同一深度（leftDepth = rightDepth）,那么左子树肯定是满二叉树
 * 如果左右孩子不是同一深度，那么肯定右子树深度小，并且右子树是满二叉树
 * @author shkstart
 * @create 2021-10-28 9:34
 */
public class BT11_222 {
    //递归
    public int countNodes(TreeNode root){
        if(root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth == rightDepth) { //左子树是满二叉树
           //2^leftDepth - 1 + countNodes(root.right) + 1
            return (1 << leftDepth - 1) + countNodes(root.right) + 1;
        }else { //右边是满二叉树
            return (1 << rightDepth - 1) + countNodes(root.left) + 1;
        }
    }

    //完全二叉树的深度：往左孩子那边摁算就完事了
    private int getDepth(TreeNode root){
        int depth = 0;
        while(root != null){
            root = root.left;
            depth++;
        }
        return depth;
    }
}
