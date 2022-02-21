package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  98.递增二叉树
 * 方法：用中序遍历，二叉搜索树将得到一个递增数组
 * @author shkstart
 * @create 2021-11-09 10:15
 */
public class BT23_98 {

    //递归法
    //通过比较中序遍历得到的数组是否为递增数组
    Deque<Integer> deque = new LinkedList<>();
    public void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        deque.addLast(root.val);
        traversal(root.right);
    }

    public boolean isValidBST(TreeNode root){
        traversal(root);
        int size = deque.size();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){
            nums[i] = deque.pollFirst();
        }
        for (int i = 1; i < nums.length; i++){
            if(nums[i - 1] >  nums[i]) {
                return false;
            }
        }
        return true;
    }

    //掌握
    //迭代法：
    public boolean isValidBST1(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null || !deque.isEmpty()){
            if(cur != null){
                deque.push(cur);
                cur = cur.left;    //左
            }else{
                cur = deque.pop();  //中
                if(pre != null && cur.val <= pre.val){
                    return false;
                }
                pre = cur;
                cur = cur.right;  //右
            }
        }
        return true;
    }
}
