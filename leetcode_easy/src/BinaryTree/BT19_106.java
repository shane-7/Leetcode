package BinaryTree;

/** 106. 从中序与后序遍历序列构造二叉树
 *
 *  注意：在切中序和前序数组时，只要知道它们需要切割的索引就好了
 *       不用真正new新的数组来保存切割后的两个数组。
 *
 * @author shkstart
 * @create 2021-11-02 9:08
 */
//递归处理
public class BT19_106 {
    public TreeNode traversal(int[] inorder, int inorderBegin, int inorderEnd,
                              int[] postorder, int posterBegin, int posterEnd){
        if(posterBegin == posterEnd) return null;

        int rootValue = postorder[posterEnd - 1];
        TreeNode root = new TreeNode(rootValue);

        //判断是否到叶子节点
        if(posterEnd - posterBegin == 1) return root;

        //找分割点的索引
        int delimiterIndex = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                delimiterIndex = i;
                break;
            }
        }

        //找到分割点索引之后，开始切割
        //左中序区间，左闭右开 [leftInorderBegin, leftInorderEnd]
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = delimiterIndex;
        //右中序区间，也是左闭右开 [rightInorderBegin, rightInorderEnd]
        int rightInorderBegin = delimiterIndex + 1;
        int rightInorderEnd = inorderEnd;

        //左后序区间，左闭右开 [leftPostorderBegin, leftPostorderEnd]
        int leftPostorderBegin = posterBegin;
        int leftPostorderEnd = posterBegin + delimiterIndex - inorderBegin;  //终止位置是：起始位置加上 左中序区间的大小size
        //右后序区间，左闭右开 [rightPostorderBegin, rightPostorderEnd]
        int rightPostorderBegin = leftPostorderEnd;
        int rightPostorderEnd = posterEnd - 1; //(排除最后一个元素)，这个元素已经作为节点了

        root.left = traversal(inorder, leftInorderBegin, leftInorderEnd, postorder, leftPostorderBegin, leftPostorderEnd);
        root.right = traversal(inorder, rightInorderBegin, rightInorderEnd, postorder, rightPostorderBegin, rightPostorderEnd);

        return root;

    }
    public TreeNode buildeTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        //左闭右开的原则, 右区间是inorder.length、postorder.length，而不是inorder.length - 1、postorder.length - 1
        return traversal(inorder,0, inorder.length, postorder, 0, postorder.length);
    }
}
