package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-12-22 9:07
 */
public class BT1_二叉树中序遍历 {

    //递归法：
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;

    }
    public void inorder(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    //中序遍历的迭代法直接背下来！
    //迭代法：中序遍历：左- 中- 右， 压入栈顺序：左- 右， 注意！中序遍历的迭代法与其它两种遍历的迭代法不同
    public List<Integer> inorderTraversal1(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !deque.isEmpty()){
            if(cur != null){
                deque.addLast(cur);
                cur = cur.left;
            }else{
                cur = deque.pollFirst();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;

    }


}
