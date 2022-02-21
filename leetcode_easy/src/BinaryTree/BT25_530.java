package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/** 530.二叉搜索树的最小绝对差
 * @author shkstart
 * @create 2021-11-12 17:06
 */
public class BT25_530 {
    Deque<Integer> deque = new LinkedList<>();
    public void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        deque.addLast(root.val);
        traversal(root.right);
    }
    public int getMinmumDifference(TreeNode root){
        traversal(root);
        //转换成数组
        int size = deque.size();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++){
            nums[i] = deque.pollFirst();
        }

        //计算绝对值
        int Mindiff = nums[1] - nums[0];
        for(int i = 2; i < size; i++){
            Mindiff = Math.min(nums[i] - nums[i - 1], Mindiff);
        }
        return Mindiff;
    }
}
