package BinaryTree;

/** 654.构造最大二叉树
 * @author shkstart
 * @create 2021-11-07 9:56
 */
public class BT20_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return traversal(nums, 0, nums.length);

    }

    //超时
    public TreeNode traversal(int[] nums, int beginIndex, int endIndex){
        if(endIndex - beginIndex < 1) return null;

        //到叶子节点了
        if (endIndex - beginIndex == 1) {// 只有一个元素
            return new TreeNode(nums[beginIndex]);
        }
        //最大值(分割点)索引为：
        int maxIndex = maxValueIndex(nums, beginIndex, endIndex);
        int maxValue = nums[maxIndex];
        TreeNode root = new TreeNode(maxValue);

        //开始分割
        int leftBegin = beginIndex;
        int leftEnd = maxIndex;

        int rightBegin = maxIndex + 1;
        int rightEnd = endIndex;

        root.left = traversal(nums, leftBegin, leftEnd);
        root.right = traversal(nums, rightBegin, rightEnd);

        return root;
    }

    //方法：返回数组中最大值的索引
    private int maxValueIndex(int[] nums, int beginIndex, int endIndex){
        int maxIndex = beginIndex;
        int maxValue = nums[beginIndex];
        for(int i = beginIndex; i < endIndex; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
