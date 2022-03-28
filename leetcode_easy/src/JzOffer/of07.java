package JzOffer;

import java.util.HashMap;

/** 原理：前序遍历的第一个节点就是根，在中序遍历中 通过根 区分哪些是左子树，哪些是右子树
 * @author shkstart
 * @create 2022-03-23 20:35
 */
public class of07 {
    int[] preorder;  //保留的前序遍历
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)  //通过map记录中序遍历的节点索引
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // root是在前序遍历里面的
        int i = dic.get(preorder[root]);                       // 根据前序中root，在中序遍历中获得当前根的索引
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归，左子树根节点就是前序遍历中root+1个，左边界就是中序的left，右边边界为中序的根节点index - 1
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归，右子树根节点为前序遍历中根节点+左子树节点长度+1，左边界为中序里i + 1，右边界为right
        return node;                                           // 回溯返回根节点
    }

    public static void main(String[] args) {
        of07 test = new of07();
        int[] pre = {3,9,2,1,7};
        int[] inorder = {9,3,1,2,7};
        TreeNode root = test.buildTree(pre, inorder);
        System.out.println(root);
    }


}
