package BinaryTree;
/*
 根据数组构造最大二叉树
 */
// 递归分解法
public class BT3_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null) return null;
        return build(nums, 0, nums.length - 1);

    }

    TreeNode build(int[] nums, int low, int high){
        if(low > high){
            return null;
        }

        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        //找出nums中最大值，及其索引.
        for(int i = low; i < nums.length; i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                index = i;
            }
        }

        //先构造出根节点
        TreeNode root = new TreeNode(maxVal);
        //递归调用构造左右子树
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }
}
