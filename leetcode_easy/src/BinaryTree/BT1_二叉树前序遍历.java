package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-22 8:58
 */
public class BT1_二叉树前序遍历 {
    //递归法：
    public ArrayList<Integer> preOrderReverse(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right,result);
    }

    //深度优先遍历 就是以下迭代遍历！！！
    //迭代法： 前序遍历顺序：中- 左- 右， 入栈顺序：中- 右- 左
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pop(); //中间的节点已经先pop出来了
            res.add(node.val);
            if(node.right != null){      //先右节点
                deque.add(node.right);
            }
            if(node.left != null){       //再左节点
                deque.add(node.left);
            }
        }
        return res;
    }

}
