package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** 501.二叉搜索树的众数
 *  分析：因为是二叉搜索树，所以相同的值肯定是相邻的，所以刚好用到前一题的迭代法
 * @author shkstart
 * @create 2021-11-12 20:23
 */
public class BT26_501 {


    public int[] findMode(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>(); //遍历树的栈
        List<Integer> nums = new ArrayList<>();
        int maxCount = 0; //最大频率
        int count = 0; //统计频率
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null || !deque.isEmpty()){
            if(cur != null){
                deque.push(cur);
                cur = cur.left;
            }else {
                cur = deque.pop();
                if(pre == null) { //第一个节点
                    count = 1;
                }else if(cur.val == pre.val){
                    count++;
                }else {  //与前一个值不同，那就是新的值
                    count = 1;
                }

                if(count == maxCount){
                    nums.add(cur.val);
                }
                if(count > maxCount){
                    maxCount = count;
                    nums.clear();
                }

                pre = cur;
                cur = cur.right;
            }
        } //得到nums之后，将其转换成数组：
        return nums.stream().mapToInt(Integer :: intValue).toArray();
    }
}
