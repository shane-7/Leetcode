package 宫水三叶.JZoffer.BFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shkstart
 * @create 2022-05-05 13:45
 */
//前序遍历: 中 右 左
public class bfs1_27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if(node.left != null){
                deque.addLast(node.left);
            }
            if(node.right != null){
                deque.addLast(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    //递归
    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree1(root.right);
        root.right = mirrorTree1(temp);
        return root;
    }

}
