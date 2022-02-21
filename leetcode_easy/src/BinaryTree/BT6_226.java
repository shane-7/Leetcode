package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/** 226.翻转二叉树
 * 迭代法
 * @author shkstart
 * @create 2021-10-26 9:19
 */
public class BT6_226 {
    //层序遍历
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.peek();
            deque.pop();
            swapChildren(node);
            if(node.right != null) deque.push(node.right);
            if(node.left != null) deque.push(node.left);
        }
        return root;
    }
    private void swapChildren(TreeNode root){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
